package com.jwt.sell.config;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wuli涛涛
 * @Title: MVCConfiguration
 * @ProjectName sell
 * @Description: TODO
 * @date 2020/3/2821:02
 */
public class MVCConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("forward:/index.html");
        //设置ViewController的优先级,将此处的优先级设为最高,当存在相同映射时依然优先执行
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        super.addViewControllers(registry);
    }
}
