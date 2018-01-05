package com.ps.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by iuliana.cosmina on 4/17/16.
 */
@Configuration
@ComponentScan(basePackages = "com.ps.repo.stub")
@ImportResource(value = {"classpath:spring/test-cfg.xml", "classpath:spring/pet-cfg.xml"})
public class TestAppConfig {
}
