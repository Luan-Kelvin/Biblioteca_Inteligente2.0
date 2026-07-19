package com.alura.projeto.Biblioteca_Inteligente2.Controller;

import com.alura.projeto.Biblioteca_Inteligente2.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class BookController {

    private BookService bookService;


}
