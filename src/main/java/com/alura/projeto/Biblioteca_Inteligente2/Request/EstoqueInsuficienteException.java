package com.alura.projeto.Biblioteca_Inteligente2.Request;

public class EstoqueInsuficienteException extends RuntimeException {
    public EstoqueInsuficienteException(String message) {
        super(message);
    }
}
