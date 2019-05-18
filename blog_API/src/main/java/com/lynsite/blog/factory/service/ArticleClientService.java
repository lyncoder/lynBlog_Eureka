package com.lynsite.blog.factory.service;

import com.lynsite.blog.entity.Article;
import com.lynsite.blog.factory.fallback.ArticleFallback;
import com.lynsite.blog.vo.ResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Description: feign负载均衡,客户端可依旧采用面向接口编程方式，controller中调用service
 * @Author: 刘亚楠
 * @Date: 2019/3/20 16:24
 * @Version: 1.0
 */
@FeignClient(value = "PROVIDERARTICLE", fallbackFactory = ArticleFallback.class)
public interface ArticleClientService {

    @GetMapping("/articleFeign/get/{id}")
    Object queryArticleById(@PathVariable("id") Long id);

    @GetMapping("/articleFeign/gets/{ids}")
    Object queryArticleByIds(@PathVariable("ids") List<Article> ids);

    @GetMapping("/articleFeign/list")
    Object queryAllArticles();

}
