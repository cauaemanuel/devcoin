package com.devcoin.infraestructure.config;

import com.devcoin.infraestructure.persistence.Cotacao;
import com.devcoin.infraestructure.persistence.CotacaoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuntimeTest {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @PostConstruct
    public void insert(){
        var cotacao = new Cotacao();
        cotacao.setName("Petróleo Brasileiro S.A. - Petrobras");
        cotacao.setSymbol("PTR4");
        cotacao.setMarketCap("R$ 500B");
        cotacao.setPrice(28.50);
        cotacaoRepository.save(cotacao);
    }
}
