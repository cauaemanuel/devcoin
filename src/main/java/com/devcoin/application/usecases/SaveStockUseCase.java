package com.devcoin.application.usecases;

import com.devcoin.domain.client.BrapiClient;
import com.devcoin.domain.repository.CotacaoRepository;
import com.devcoin.infraestructure.persistence.Cotacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@Slf4j
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
            var cotacaoExistente = cotacaoRepository.findBySymbol(cotacao.getSymbol());
            if (cotacaoExistente != null) {
                log.info("Cotação para o símbolo " + cotacao.getSymbol() );
                return;
            }
            cotacaoRepository.save(cotacao);
            log.info("Cotação salva para o símbolo: " + cotacao.getSymbol() + " - Cotação: " + cotacao.getPrice());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(fixedRate = 60000)
    public void atualizarStock(){
        log.info("Iniciando atualização das cotações em: " + LocalDateTime.now());

        var limite = Instant.now().minusSeconds(300);
        log.info("Buscando cotações desatualizadas antes de: " + limite);

        var desatualizadas = cotacaoRepository.findByRequestAtBefore(limite);
        log.info("Cotações desatualizadas encontradas: " + desatualizadas.size());

        desatualizadas.forEach(moeda -> {
            log.info("Atualizando cotação de: " + moeda.getSymbol() + " - Cotação atual: " + moeda.getPrice() + " - RequestedAt: " + moeda.getRequestedAt());
            var novaCotacao = new Cotacao(brapiClient.getQuote(moeda.getSymbol()));
            moeda.setMarketCap(novaCotacao.getMarketCap());
            moeda.setPrice(novaCotacao.getPrice());
            moeda.setRequestedAt(novaCotacao.getRequestedAt());
            cotacaoRepository.save(moeda);
        });
    }
}