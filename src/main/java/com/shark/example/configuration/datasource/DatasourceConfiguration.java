package com.shark.example.configuration.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration("DatasourceConfiguration")
@EnableJpaRepositories(basePackages = "com.shark.example.dao.repository")
@MapperScan(basePackages = "com.shark.example.dao.mapper")
public class DatasourceConfiguration {

}
