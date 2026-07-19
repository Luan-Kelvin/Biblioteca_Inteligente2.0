package com.alura.projeto.Biblioteca_Inteligente2.Request;

public class LivroJaEmprestadoException extends RuntimeException {
    public LivroJaEmprestadoException(String message) {
        super(message);
    }
}
