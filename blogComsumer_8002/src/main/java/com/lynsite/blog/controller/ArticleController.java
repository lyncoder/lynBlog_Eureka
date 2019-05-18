package com.lynsite.blog.controller;

import com.lynsite.blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/16 17:34
 * @Version: 1.0
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    private static String REST_URL_PREFIX = "http://PROVIDERARTICLE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public Article queryArticleById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/article/get/" + id, Article.class);
    }

    @GetMapping("/gets/{ids}")
    public List<Article> queryArticleByIds(@PathVariable("ids") List<Long> ids){
        List<Article> articles = new ArrayList<>();
        ids.forEach(id -> {
            articles.add(restTemplate.getForObject(REST_URL_PREFIX + "/article/get/" + id, Article.class));
        });
        return articles;
    }

    @GetMapping("/list")
    public List<Article> queryAllArticles(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/article/list", List.class);
    }
}
