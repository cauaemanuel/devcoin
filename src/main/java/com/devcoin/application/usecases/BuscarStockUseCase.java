package com.devcoin.application.usecases;

import com.devcoin.infraestructure.client.BrapiClient;
import com.devcoin.infraestructure.persistence.Cotacao;
import com.devcoin.infraestructure.persistence.CotacaoRepository;
import org.springframework.stereotype.Component;

@Component
public class BuscarStockUseCase {

    private final BrapiClient brapiClient;
    private final CotacaoRepository cotacaoRepository;

    public BuscarStockUseCase(BrapiClient brapiClient, CotacaoRepository cotacaoRepository) {
        this.brapiClient = brapiClient;
        this.cotacaoRepository = cotacaoRepository;
    }

    public void buscarCotacoes(String symbol) {
        var cotacao = new Cotacao(brapiClient.getQuote(symbol));
        cotacaoRepository.save(cotacao);
    }
}
