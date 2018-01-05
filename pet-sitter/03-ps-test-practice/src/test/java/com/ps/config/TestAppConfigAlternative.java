package com.ps.config;

import com.ps.repo.stub.StubPetRepo;
import com.ps.repos.PetRepo;
import com.ps.services.impl.SimplePetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by iuliana.cosmina on 4/17/16.
 */
@Configuration
@ComponentScan(basePackages = "com.ps.repo.stub")
public class TestAppConfigAlternative {

    @Bean
    public PetRepo petRepo(){
        return new StubPetRepo();
    }

    @Bean
    public SimplePetService simplePetService(){
        SimplePetService simplePetService = new SimplePetService();
        simplePetService.setRepo(petRepo());
        return simplePetService;
    }
}
