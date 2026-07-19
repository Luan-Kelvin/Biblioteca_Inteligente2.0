package com.alura.projeto.Biblioteca_Inteligente2.Repository;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
