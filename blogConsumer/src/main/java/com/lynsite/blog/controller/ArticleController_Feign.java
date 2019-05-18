package com.lynsite.blog.controller;

import com.lynsite.blog.entity.Article;
import com.lynsite.blog.factory.service.ArticleClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Feign方式
 * @Author: 刘亚楠
 * @Date: 2019/3/16 17:34
 * @Version: 1.0
 */
@RestController
@RequestMapping("articleFeign")
public class ArticleController_Feign {

    @Autowired
    private ArticleClientService articleClientService;

    @GetMapping("/get/{id}")
    public Object queryArticleById(@PathVariable("id") Long id){
        System.out.println(id);
        return articleClientService.queryArticleById(id);
    }

    @GetMapping("/gets/{ids}")
    public Object queryArticleByIds(@PathVariable("ids") List<Long> ids){
        List<Article> articles = new ArrayList<>();
        ids.forEach(id -> {
            articles.add((Article)articleClientService.queryArticleById(id));
        });
        return articles;
    }

    @GetMapping("/list")
    public Object queryAllArticles(){
        return articleClientService.queryAllArticles();
    }
}
