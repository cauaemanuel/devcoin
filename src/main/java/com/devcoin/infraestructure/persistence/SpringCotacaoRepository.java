package com.devcoin.infraestructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCotacaoRepository extends MongoRepository<Cotacao, String> {
    Cotacao findBySymbol(String symbol);
}
