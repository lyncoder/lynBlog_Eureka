package com.lynsite.blog.dao;

import com.lynsite.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectAll();
}