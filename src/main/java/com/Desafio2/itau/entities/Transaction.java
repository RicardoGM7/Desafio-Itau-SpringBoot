package com.Desafio2.itau.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private Double valor;
    private OffsetDateTime dataHora;


}
