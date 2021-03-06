package com.leyou.commom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    CATEGORY_NOT_FOND(404,"商品分类没查到")
    ;
    private int code;
    private String msg;
}
