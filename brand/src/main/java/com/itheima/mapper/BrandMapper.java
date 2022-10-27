package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    //查询所有
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    //添加数据
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //批量删除
    //复杂sql不建议使用注解
    //数组类型的参数 要使用注解映射名字 @Param("ids)
    void deleteByIds(@Param("ids") int[] ids);

    //分页查询
    //两个参数 一个以上的参数 需要用到注解
    @Select("select * from tb_brand limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    //查询总记录数
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    //分页条件查询
    //两个参数 一个以上的参数 需要用到注解
    //动态 SQL 配置文件编写
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    //查询条件查询完成后的总记录数
    int selectTotalCountByCondition(Brand brand);

    //删除

}
