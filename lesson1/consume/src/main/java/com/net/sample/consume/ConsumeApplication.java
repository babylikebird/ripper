package com.net.sample.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@RestController
public class ConsumeApplication {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Autowired
    RestTemplate restTemplate;
    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }
    @GetMapping("test")
    public String getContent(){
        log.info("发起请求");
        return restTemplate.getForObject("http://provider/provider",String.class);
    }

}
