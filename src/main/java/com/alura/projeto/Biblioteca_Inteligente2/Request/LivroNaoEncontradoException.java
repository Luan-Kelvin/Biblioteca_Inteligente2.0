package com.alura.projeto.Biblioteca_Inteligente2.Request;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String message) {
        super(message);
    }
}
