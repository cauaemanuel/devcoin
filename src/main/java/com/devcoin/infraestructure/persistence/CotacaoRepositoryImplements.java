package com.devcoin.infraestructure.persistence;

import com.devcoin.domain.repository.CotacaoRepository;
import org.springframework.stereotype.Component;

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
}
