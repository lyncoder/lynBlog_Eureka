package com.lynsite.blog.factory.fallback;

import com.lynsite.blog.entity.Article;
import com.lynsite.blog.factory.service.ArticleClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Description: 断路器熔断回滚，与 ArticleClientService 配合使用
 * @Author: 刘亚楠
 * @Date: 2019/3/21 12:27
 * @Version: 1.0
 */
@Component
public class ArticleFallback implements FallbackFactory<ArticleClientService> {

    @Override
    public ArticleClientService create(Throwable e) {
        return new ArticleClientService() {
            @Override
            public Article queryArticleById(Long id) {
                Article article = new Article();
                article.setId(id);
                article.setTitle("该 ID 信息不存在");
                article.setDate(new Date());
                return article;
            }

            @Override
            public List<Article> queryArticleByIds(List<Article> ids) {
                return null;
            }

            @Override
            public List<Article> queryAllArticles() {
                return null;
            }
        };
    }


}
