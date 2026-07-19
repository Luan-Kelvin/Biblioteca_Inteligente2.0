package com.alura.projeto.Biblioteca_Inteligente2.Excepetion;

public class LivroJaEmprestadoException extends RuntimeException {
    public LivroJaEmprestadoException(String message) {
        super(message);
    }
}
