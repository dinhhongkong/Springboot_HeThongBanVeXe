package com.example.sevicedatve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeviceDatVeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeviceDatVeApplication.class, args);
    }

}
