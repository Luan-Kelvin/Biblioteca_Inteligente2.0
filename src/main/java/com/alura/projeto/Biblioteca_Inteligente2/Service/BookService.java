package com.alura.projeto.Biblioteca_Inteligente2.Service;

import com.alura.projeto.Biblioteca_Inteligente2.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
}
