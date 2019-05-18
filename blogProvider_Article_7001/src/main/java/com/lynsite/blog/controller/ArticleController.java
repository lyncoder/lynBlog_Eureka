package com.lynsite.blog.controller;

import com.lynsite.blog.entity.Article;
import com.lynsite.blog.service.ArticleService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Description: 客户端熔断器，Ribben负载机制
 * @Author: 刘亚楠
 * @Date: 2019/3/8 11:06
 * @Version: 1.0
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "queryById")
    public Article queryArticleById(@PathVariable("id") Long id){
        System.out.println(id);
        Article article = articleService.queryArticleById(id);
        if(article == null){
            throw new RuntimeException("没有该ID对应的信息");
        }
        return article;
    }

    //熔断回滚函数
    public Article queryById(@PathVariable("id") Long id){
        Article article = new Article();
        article.setId(id);
        article.setTitle("该ID的文章不存在---@HystrixCommand");
        article.setDate(new Date());
        return article;
    }



    @GetMapping("/gets/{ids}")
    public List<Article> queryArticleByIds(@PathVariable("ids") List<Long> ids){
        return articleService.queryArticleByIds(ids);
    }

    @GetMapping("/list")
    public List<Article> queryAllArticles(){
        return articleService.selectAll();
    }

}
