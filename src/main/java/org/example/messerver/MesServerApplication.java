package org.example.messerver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.messerver.mapper")
public class MesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesServerApplication.class, args);
    }

}
