package com.alura.projeto.Biblioteca_Inteligente2.Excepetion;

public class AutorSemLivrosException extends RuntimeException {
    public AutorSemLivrosException(String message) {
        super(message);
    }
}
