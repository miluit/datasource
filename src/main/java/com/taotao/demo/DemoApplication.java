package com.taotao.demo;

import com.taotao.demo.config.datasource.multiple.DataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableCaching
@EnableAspectJAutoProxy
@Import(DataSourceConfig.class)
@ComponentScan({"com.taotao.config","com.taotao.demo"})
@MapperScan({"com.taotao.demo.mapper"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
