package com.dmgt.context;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource(value="classpath:config.properties")
public class Env {
    @Value("${prod.url}")
    private String prodUrl;
    @Value("${browser}")
    private String browser;
    @Value("${timeout}")
    private Long timeout;
}
