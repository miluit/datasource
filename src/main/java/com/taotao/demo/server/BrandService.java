package com.taotao.demo.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taotao.demo.model.Brand;

import java.util.List;

public interface BrandService extends IService<Brand> {

    List<Brand> queryList(Brand brand);

    List<Brand> selectBrand();

    List<Brand> selectBrand2();

}
