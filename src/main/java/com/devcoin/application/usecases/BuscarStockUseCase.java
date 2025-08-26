package com.devcoin.application.usecases;

import com.devcoin.domain.client.BrapiClient;
import com.devcoin.infraestructure.client.SpringBrapiClient;
import com.devcoin.infraestructure.persistence.Cotacao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BuscarStockUseCase {

    private final BrapiClient brapiClient;
    private final SaveStockUseCase saveStockUseCase;

    public BuscarStockUseCase(BrapiClient brapiClient, SaveStockUseCase saveStockUseCase) {
        this.brapiClient = brapiClient;
        this.saveStockUseCase = saveStockUseCase;
    }

    @Cacheable("cotacoes")
    public Cotacao buscarCotacoes(String symbol) {
        var cotacao = new Cotacao(brapiClient.getQuote(symbol));
        saveStockUseCase.salvarAsync(cotacao);
        return cotacao;
    }
}
