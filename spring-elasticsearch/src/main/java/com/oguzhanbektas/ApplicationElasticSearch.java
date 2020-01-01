package com.oguzhanbektas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ApplicationElasticSearch {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationElasticSearch.class, args);
    }
}
