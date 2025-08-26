package com.devcoin.infraestructure.config;

import com.devcoin.domain.client.BrapiClient;
import com.devcoin.domain.repository.CotacaoRepository;
import com.devcoin.infraestructure.client.BrapiClientImplements;
import com.devcoin.infraestructure.client.SpringBrapiClient;
import com.devcoin.infraestructure.persistence.CotacaoRepositoryImplements;
import com.devcoin.infraestructure.persistence.SpringCotacaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BrapiClient brapiClient(SpringBrapiClient springBrapiClient){
        return new BrapiClientImplements(springBrapiClient);
    }

    @Bean
    public CotacaoRepository cotacaoRepository(SpringCotacaoRepository springCotacaoRepository){
        return new CotacaoRepositoryImplements(springCotacaoRepository);
    }

}
