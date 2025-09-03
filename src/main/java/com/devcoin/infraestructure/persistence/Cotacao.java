package com.devcoin.infraestructure.persistence;

import com.devcoin.application.dto.BrapiResponse;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;


@Data
@Document(collection = "cotacoes")
public class Cotacao {

    @Id
    private String id;
    //PTR4
    private String symbol;
    //Petróleo Brasileiro S.A. - Petrobras
    private String name;
    private String marketCap;
    private Double price;
    private Instant requestedAt;

    public Cotacao(BrapiResponse response) {
        var brapiResponse = response.results().get(0);
        this.symbol = brapiResponse.symbol();
        this.name = brapiResponse.longName();
        this.marketCap = brapiResponse.marketCap();
        this.price = brapiResponse.regularMarketPrice();
        this.requestedAt = response.requestedAt();
    }

    public Cotacao() {
    }

}
