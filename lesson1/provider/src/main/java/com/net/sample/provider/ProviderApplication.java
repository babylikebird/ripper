package com.net.sample.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
    @GetMapping("provider")
    public String provider(){
//        try {
//            Thread.sleep(20 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("..................................");
        return "i am provider2";
    }
}
