package com.alura.projeto.Biblioteca_Inteligente2.Controller;

import com.alura.projeto.Biblioteca_Inteligente2.API.DTO.BookApiExternaDTO;
import com.alura.projeto.Biblioteca_Inteligente2.DTOs.BookDTO;
import com.alura.projeto.Biblioteca_Inteligente2.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/autor/{autor}")
    public List<BookDTO> searchByAuthor(@PathVariable String autor){
        return bookService.searchByAuthor(autor);
    }

    @GetMapping("/editora/{editora}")
    public List<BookDTO> searchByPublisher(@PathVariable String editora){
        return bookService.serachByPublisher(editora);
    }

    @GetMapping("/disponiveis")
    public List<BookDTO> checkAvailableBooks(){
        return bookService.checkAvaliableBooks();
    }

    @GetMapping("/importar/{title}")
    public BookApiExternaDTO searchForBookExternalAPIs(@PathVariable String title){
        return bookService.searchForBookExternalAPIs(title);
    }

    // POST
    @PostMapping
    public BookDTO registerABook(@RequestBody BookDTO bookDTO){
        return bookService.registerABook(bookDTO);
    }

}
