package com.devcoin.application.usecases;

// src/main/java/com/devcoin/service/TestService.java

import com.devcoin.infraestructure.persistence.Cotacao;
import com.devcoin.infraestructure.persistence.CotacaoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SaveStockUseCase {

    private final CotacaoRepository cotacaoRepository;

    public SaveStockUseCase(CotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
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
}