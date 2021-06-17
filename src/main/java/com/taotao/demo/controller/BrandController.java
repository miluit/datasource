package com.taotao.demo.controller;

import com.taotao.config.RabbitSender;
import com.taotao.demo.model.Brand;
import com.taotao.demo.server.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    RabbitSender rabbitSender;

    @PostMapping("/create")
    public String create(@RequestBody Brand brand) {
        return  String.valueOf(brandService.save(brand));
    }

    @GetMapping("/get/{id}")
    public String create(@PathVariable("id") Long id) {
        log.debug("brandService对象为：" + brandService.toString());
        return brandService.getById(id).toString();
    }

    @GetMapping("/select")
    public List<Brand> selectBrand() {
        log.debug("brandService对象为：" + brandService.toString());
        return brandService.selectBrand();
    }

    @GetMapping("/select2")
    public List<Brand> selectBrand2() {
        return brandService.selectBrand2();
    }

    @GetMapping("/send")
    public String send() throws Exception{
        rabbitSender.send();
        return "123";
    }

    @GetMapping("/send2/{id}")
    public String send2(@PathVariable("id") Integer id) {
        return "send2" + id;
    }

}
