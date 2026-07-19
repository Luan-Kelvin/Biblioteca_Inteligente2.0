package com.alura.projeto.Biblioteca_Inteligente2.Excepetion;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String message) {
        super(message);
    }
}
