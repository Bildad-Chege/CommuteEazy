package com.bilchege.commuteazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.bilchege.commuteazy.Repositories")
@EntityScan("com.bilchege.commuteazy.Entities")
@SpringBootApplication
public class CommuteazyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommuteazyApplication.class, args);
    }

}

