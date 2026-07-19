package com.alura.projeto.Biblioteca_Inteligente2.Repository;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
