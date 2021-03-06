package com.leyou.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@Data
public class Category {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String name;
    private Long id;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
}
