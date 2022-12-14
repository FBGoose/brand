package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {

    //查询所有
    List<Brand> selectAll();

    //添加数据
    void add(Brand brand);

    //批量删除
    void deleteByIds(int[] ids);

    //分页查询
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    //分页条件查询
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);

    //删除


}
