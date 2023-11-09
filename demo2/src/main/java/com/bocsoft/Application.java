package com.bocsoft;

import com.bocsoft.controller.DemoController;
import com.bocsoft.controller.NotInController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.bocsoft"},     //启动类（限制范围）
    exclude = {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    @Bean(value = "abc", initMethod = "init", destroyMethod = "des", autowireCandidate = false)
    public NotInController notInController(){
        return new NotInController();
    }
}
