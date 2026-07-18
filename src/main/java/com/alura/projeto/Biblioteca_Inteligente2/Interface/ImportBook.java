package com.alura.projeto.Biblioteca_Inteligente2.Interface;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Book;

@FunctionalInterface
public interface ImportBook {
    Book importBook(String isbn);
}
