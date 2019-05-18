package com.lynsite.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/20 15:17
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {
    
    private boolean success;
    private String msg;
    private Long total;
    private List<T> data;
}
