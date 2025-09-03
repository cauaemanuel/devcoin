package com.devcoin.domain.repository;

import com.devcoin.infraestructure.persistence.Cotacao;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface CotacaoRepository {

    Cotacao save(Cotacao cotacao);

    Iterable<Cotacao> findAll();

    Cotacao findBySymbol(String symbol);

    List<Cotacao> findByRequestAtBefore(Instant limite);
}
