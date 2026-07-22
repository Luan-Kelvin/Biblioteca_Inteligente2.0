package com.alura.projeto.Biblioteca_Inteligente2.Excepetion;

public class LivroJaExisteException extends RuntimeException {
    public LivroJaExisteException(String message) {
        super(message);
    }
}
