package com.leyou.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_brand")
public class Brand {

    private Long id;
    private String name;
    private String image;
    private Character letter;
}
