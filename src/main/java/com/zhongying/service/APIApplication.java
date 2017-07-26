package com.zhongying.service;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.container.filter.LoggingFilter;
import com.zhongying.pojo.Device;


public class APIApplication extends ResourceConfig{
	
//	 public APIApplication() {
//        //加载Model
//        register(Device.class);
//
//        //加载与OptionResult同一个packge的Model
//        //packages(OptionResult.class.getPackage().getName());
//
//        //加载Resource
////        register(UserResource.class);
//
//        //注册数据转换器
//        register(JacksonJsonProvider.class);
//
//        // Logging.
//        register(LoggingFilter.class);
//	  }
}
