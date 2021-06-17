package com.taotao.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taotao.demo.config.datasource.multiple.DataSource;
import com.taotao.demo.config.datasource.multiple.DataSourceName;
import com.taotao.demo.model.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper extends BaseMapper<Brand> {

    @DataSource(value = DataSourceName.SLAVE)
    @Select("SELECT * FROM brand")
    List<Brand> selectBrand();

    @DataSource
    @Select("SELECT * FROM brand")
    List<Brand> selectBrand2();

}
