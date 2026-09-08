package com.Desafio2.itau.controller;


import com.Desafio2.itau.dto.TransactionRequest;
import com.Desafio2.itau.entities.Transaction;
import com.Desafio2.itau.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request){
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() < 0){
            return ResponseEntity.unprocessableContent().build();
        }

        transactionService.addTransaction(new Transaction(request.getValor(),request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clear(){
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();
    }
}
