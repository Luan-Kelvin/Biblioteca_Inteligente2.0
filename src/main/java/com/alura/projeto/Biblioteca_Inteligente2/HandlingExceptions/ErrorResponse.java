package com.alura.projeto.Biblioteca_Inteligente2.HandlingExceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime momentoDoErro,
        int status,
        String erro,
        String mensage,
        String caminho
) {
}
