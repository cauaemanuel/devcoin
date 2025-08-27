package com.devcoin.domain.repository;

import com.devcoin.infraestructure.persistence.Cotacao;

public interface CotacaoRepository {

    Cotacao save(Cotacao cotacao);

    Iterable<Cotacao> findAll();

    Cotacao findBySymbol(String symbol);
}
