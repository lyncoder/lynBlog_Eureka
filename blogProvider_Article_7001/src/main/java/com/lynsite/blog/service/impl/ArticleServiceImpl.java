package com.lynsite.blog.service.impl;

import com.lynsite.blog.dao.ArticleMapper;
import com.lynsite.blog.entity.Article;
import com.lynsite.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/16 15:48
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article queryArticleById(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> queryArticleByIds(List<Long> ids) {
        List<Article> articles = new ArrayList<>();
        ids.forEach(id -> {
            articles.add(articleMapper.selectByPrimaryKey(id));
        });
        return articles;
    }

    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }
}
