package com.alura.projeto.Biblioteca_Inteligente2.HandlingExceptions;

import java.time.LocalDate;

public record ErrorResponse(
        LocalDate horaDoErro,
        int status,
        String erro,
        String mensage,
        String caminho
) {
}
