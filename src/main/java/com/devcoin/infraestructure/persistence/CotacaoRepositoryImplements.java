package com.devcoin.infraestructure.persistence;

import com.devcoin.domain.repository.CotacaoRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Component
public class CotacaoRepositoryImplements implements CotacaoRepository {

    private final SpringCotacaoRepository springCotacaoRepository;

    public CotacaoRepositoryImplements(SpringCotacaoRepository springCotacaoRepository) {
        this.springCotacaoRepository = springCotacaoRepository;
    }

    @Override
    public Cotacao save(Cotacao cotacao) {
        return springCotacaoRepository.save(cotacao);
    }

    @Override
    public Iterable<Cotacao> findAll() {
        return springCotacaoRepository.findAll();
    }

    @Override
    public Cotacao findBySymbol(String symbol) {
        return springCotacaoRepository.findBySymbol(symbol);
    }

    @Override
    public List<Cotacao> findByRequestAtBefore(Instant limite) {
        return springCotacaoRepository.findByRequestAtBefore(limite);
    }
}
