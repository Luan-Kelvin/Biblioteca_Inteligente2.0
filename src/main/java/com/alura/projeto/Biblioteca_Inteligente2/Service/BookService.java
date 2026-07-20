package com.alura.projeto.Biblioteca_Inteligente2.Service;

import com.alura.projeto.Biblioteca_Inteligente2.Convertes.Convertes;
import com.alura.projeto.Biblioteca_Inteligente2.DTOs.BookDTO;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Book;
import com.alura.projeto.Biblioteca_Inteligente2.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;
    private final Convertes convertes;

    public List<BookDTO> listBooks(){
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()){
            logger.info("Ainda não há nenhum livro cadastrado no banco.");
            return List.of();
        }

        List<BookDTO> dtos = new ArrayList<>();

        books.forEach(b -> {
            dtos.add(convertes.converterBook(b));
        });

        return dtos;
    }
}
