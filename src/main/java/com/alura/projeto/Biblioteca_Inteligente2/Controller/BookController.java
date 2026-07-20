package com.alura.projeto.Biblioteca_Inteligente2.Controller;

import com.alura.projeto.Biblioteca_Inteligente2.DTOs.BookDTO;
import com.alura.projeto.Biblioteca_Inteligente2.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO> listBooks(){
        return bookService.listBooks();
    }

    @GetMapping("/id/{id}")
    public BookDTO searchById(@PathVariable Long id){
        return bookService.searchById(id);
    }

    @GetMapping("/titulo/{titulo}")
    public List<BookDTO> searchByTitle(@PathVariable String titulo){
        return bookService.searchByTitle(titulo);
    }

    @GetMapping("categoria/{categoria}")
    public List<BookDTO> searchByCategory(@PathVariable String categoria){
        return bookService.searchByCategory(categoria);
    }

}
