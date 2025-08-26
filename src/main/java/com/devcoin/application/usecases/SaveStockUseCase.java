package com.devcoin.application.usecases;

// src/main/java/com/devcoin/service/TestService.java

import com.devcoin.domain.client.BrapiClient;
import com.devcoin.domain.repository.CotacaoRepository;
import com.devcoin.infraestructure.persistence.Cotacao;
import com.devcoin.infraestructure.persistence.SpringCotacaoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SaveStockUseCase {

    private final CotacaoRepository cotacaoRepository;
    private final BrapiClient brapiClient;

    public SaveStockUseCase(CotacaoRepository cotacaoRepository, BrapiClient brapiClient) {
        this.cotacaoRepository = cotacaoRepository;
        this.brapiClient = brapiClient;
    }

    @Async
    public void salvarAsync(Cotacao cotacao) {
        try {
            Thread.sleep(4000);
            cotacaoRepository.save(cotacao);
            System.out.println("Pausa finalizada na thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "*/1 * * * *")
    @Async
    public void atualizarStock(){
        var moedas = cotacaoRepository.findAll();
        moedas.forEach(moeda -> {
            var novaCotacao = new Cotacao(brapiClient.getQuote(moeda.getSymbol()));
            moeda.setMarketCap(novaCotacao.getMarketCap());
            moeda.setPrice(novaCotacao.getPrice());
            cotacaoRepository.save(moeda);
        });

    }
}