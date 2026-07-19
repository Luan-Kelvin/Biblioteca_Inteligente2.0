package com.alura.projeto.Biblioteca_Inteligente2.Request;

public class CategoriaNaoEncontradaException extends RuntimeException {
    public CategoriaNaoEncontradaException(String message) {
        super(message);
    }
}
