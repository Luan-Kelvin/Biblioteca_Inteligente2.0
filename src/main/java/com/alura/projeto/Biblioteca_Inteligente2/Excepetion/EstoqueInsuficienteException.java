package com.alura.projeto.Biblioteca_Inteligente2.Excepetion;

public class EstoqueInsuficienteException extends RuntimeException {
    public EstoqueInsuficienteException(String message) {
        super(message);
    }
}
