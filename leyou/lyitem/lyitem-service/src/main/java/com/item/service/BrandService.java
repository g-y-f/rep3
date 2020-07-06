package com.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.item.mapper.BrandMapper;
import com.leyou.commom.vo.PageResult;
import com.leyou.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortby, Boolean desc, String key) {
        //分页
        PageHelper.startPage(page,rows);
        //过滤
        Example example=new Example(Brand.class);
        if(StringUtils.isNoneBlank(key)){
            //过滤条件
            example.createCriteria().orLike("name","%"+key+"%").orEqualTo("letter",key.toUpperCase());

        }
        //排序
        if(StringUtils.isNoneBlank(sortby)){
            String orderByCaulse=sortby+(desc?"DESC":"ASC");
            example.setOrderByClause(orderByCaulse);
        }

        //查询
        List<Brand> list = brandMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){

        }
        //解析分页结果
        PageInfo<Brand> info=new PageInfo<>(list);
        return new PageResult<>(info.getTotal(),list);

    }
}
