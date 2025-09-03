package com.devcoin.infraestructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface SpringCotacaoRepository extends MongoRepository<Cotacao, String> {
    Cotacao findBySymbol(String symbol);

    @Query("{ 'requestedAt': { $lt: ?0 } }")
    List<Cotacao> findByRequestAtBefore(Instant limite);

}
