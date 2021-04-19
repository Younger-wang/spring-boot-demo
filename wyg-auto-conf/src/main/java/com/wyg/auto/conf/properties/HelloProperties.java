package com.wyg.auto.conf.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义starter的properties
 */
@Data
@ConfigurationProperties(prefix = "com.wyg.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;
}
