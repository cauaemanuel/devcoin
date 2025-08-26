package com.devcoin.infraestructure.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "cotacoes")
public class Cotacao {

    @Id
    private String id;
    //PTR4
    private String symbol;
    //Petróleo Brasileiro S.A. - Petrobras
    private String name;
    private String marketCap;
    private Double price;
}
