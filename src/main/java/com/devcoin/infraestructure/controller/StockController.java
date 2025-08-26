package com.devcoin.infraestructure.controller;

import com.devcoin.application.dto.BrapiResponse;
import com.devcoin.application.usecases.BuscarStockUseCase;
import com.devcoin.infraestructure.persistence.Cotacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final BuscarStockUseCase buscarStockUseCase;

    public StockController(BuscarStockUseCase buscarStockUseCase) {
        this.buscarStockUseCase = buscarStockUseCase;
    }

    @GetMapping("/{symbol}")
    public Cotacao getStock(@PathVariable String symbol) {
        return buscarStockUseCase.buscarCotacoes(symbol);
    }

}
