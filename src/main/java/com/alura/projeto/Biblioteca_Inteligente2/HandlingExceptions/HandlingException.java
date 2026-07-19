package com.alura.projeto.Biblioteca_Inteligente2.HandlingExceptions;

import com.alura.projeto.Biblioteca_Inteligente2.Excepetion.*;
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


    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> UserNotFound(UsuarioNaoEncontradoException e, HttpServletRequest request){

        ErrorResponse error = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                "Usúario não foi encontrado.",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(EstoqueInsuficienteException.class)
    public ResponseEntity<ErrorResponse> insuficcientStock(EstoqueInsuficienteException e, HttpServletRequest request){

        ErrorResponse error = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Saldo insuficiente.",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(LivroJaEmprestadoException.class)
    public ResponseEntity<ErrorResponse> BookAlreadyLentOut(LivroJaEmprestadoException e, HttpServletRequest request){

        ErrorResponse error = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.CONFLICT.value(),
                "Livro ja foi emprestado a esse usuário",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
     }


    @ExceptionHandler(ApiExternaException.class)
    public ResponseEntity<ErrorResponse> externalAPIError(ApiExternaException e, HttpServletRequest request){

        ErrorResponse error = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.BAD_GATEWAY.value(),
                "Erro na APi Externa",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
     }


    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<ErrorResponse> categoryNotFound(CategoriaNaoEncontradaException e, HttpServletRequest request){

        ErrorResponse error = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                "categoria não foi encontrada",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
     }
}
