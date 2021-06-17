package com.taotao.demo.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taotao.demo.config.datasource.multiple.DataSource;
import com.taotao.demo.config.datasource.multiple.DataSourceName;
import com.taotao.demo.mapper.BrandMapper;
import com.taotao.demo.model.Brand;
import com.taotao.demo.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper,Brand> implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<Brand> selectBrand() {
        return brandMapper.selectBrand();
    }

    @Override
    public List<Brand> selectBrand2() {
        return brandMapper.selectBrand2();
    }

    @DataSource(value = DataSourceName.SLAVE)
    @Override
    public List<Brand> queryList(Brand brand) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",brand.getName());
        queryWrapper.eq("initial",brand.getInitial());
        return brandMapper.selectList(queryWrapper);
    }

}
