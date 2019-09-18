package com.linkaixin.study.controller;

import com.linkaixin.study.service.DynamicRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@PropertySource({"classpath:application.yml"})
@ConfigurationProperties
public class PageController {
//	@Autowired
//	AsyNcComponent asyNcComponent;
    @Autowired
	DynamicRouteService dynamicRouteService;

/**
 *    通过restfull接口动态添加路由
 */
    @RequestMapping("/addRoute")
    public String dynamicAddRoute(@RequestParam("id") String id, @RequestParam("path")String path, @RequestParam("pattern")String pattern, @RequestParam("pathPattern")String pathPattern, @RequestParam("url")String url) {

        return dynamicRouteService.save(id,path,pattern,pathPattern,url);
    }

}
