package com.item.controller;

import com.item.service.BrandService;
import com.leyou.commom.vo.PageResult;
import com.leyou.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService service ;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortby
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryByPage(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortby,
            @RequestParam(value = "desc",required = false) Boolean desc,
            @RequestParam(value = "key",required = false) String key
    )  {
        PageResult<Brand> result=service.queryBrandByPage(page,rows,sortby,desc,key);
        return ResponseEntity.ok(result);
    }
}
