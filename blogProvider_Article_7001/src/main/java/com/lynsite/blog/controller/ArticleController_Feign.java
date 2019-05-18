package com.lynsite.blog.controller;

import com.lynsite.blog.entity.Article;
import com.lynsite.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/8 11:06
 * @Version: 1.0
 */
@RestController
@RequestMapping("articleFeign")
public class ArticleController_Feign {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/get/{id}")
    public Article queryArticleById(@PathVariable("id") Long id){
        System.out.println(id);
        Article article = articleService.queryArticleById(id);
        if(article == null){
            throw new RuntimeException("没有该ID对应的信息");
        }
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
