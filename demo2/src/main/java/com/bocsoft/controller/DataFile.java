package com.bocsoft.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("data")
public class DataFile {

    @Getter
    @Setter
    private String count;

    @Getter
    @Setter
    private String all;

    @Getter
    @Setter
    private String port;
}
