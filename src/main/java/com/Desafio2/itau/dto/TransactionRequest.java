package com.Desafio2.itau.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;


import java.time.OffsetDateTime;


@Getter
public class TransactionRequest {

    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

}
