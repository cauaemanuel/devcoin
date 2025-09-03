package com.devcoin.application.usecases;

import com.devcoin.domain.client.BrapiClient;
import com.devcoin.infraestructure.client.SpringBrapiClient;
import com.devcoin.infraestructure.persistence.Cotacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
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
        log.info("Buscando cotação para o símbolo: " + symbol + " - Cotação: " + cotacao.getPrice());
        saveStockUseCase.salvarAsync(cotacao);
        log.info("Cotação retornada para o símbolo: " + symbol + " - Cotação: " + cotacao.getPrice());
        return cotacao;
    }
}
