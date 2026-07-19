package com.alura.projeto.Biblioteca_Inteligente2.Request;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}
