package com.lynsite.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Article implements Serializable {
    private Long id;

    private String title;

    private String author;

    private Date date;

    private String content;

}