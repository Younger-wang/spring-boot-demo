package com.wyg.webmvc.config.myException;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义错误属性
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    /**
     * 重写getErrorAttributes方法
     *
     * @param webRequest
     * @param options
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.remove("trace");
        map.put("company","atguigu");
        return map;
    }
}
