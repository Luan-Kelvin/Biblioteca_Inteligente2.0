package com.alura.projeto.Biblioteca_Inteligente2.HandlingExceptions;

import com.alura.projeto.Biblioteca_Inteligente2.Request.AutorNaoEncontradoException;
import com.alura.projeto.Biblioteca_Inteligente2.Request.LivroNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class HandlingException {

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> HandleBookNotFound(LivroNaoEncontradoException e, HttpServletRequest request){
        ErrorResponse erro  = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                "Livro não encontrado",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(AutorNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> HandleAuthorNotFound(AutorNaoEncontradoException e, HttpServletRequest request){

        ErrorResponse erro = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                "Autor não encontrado",
                e.getMessage(),
                request.getRequestURI()

        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
