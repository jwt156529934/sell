package com.jwt.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author wuli涛涛
 * @Title: SellApplication
 * @ProjectName sell
 * @date 2020/3/1516:58
 */
@SpringBootApplication
@MapperScan(basePackages = "com.jwt.sell.repository.mapper")
@EnableCaching
public class SellApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class,args);
        System.out.println("项目启动成功");
    }
}
