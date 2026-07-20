package com.alura.projeto.Biblioteca_Inteligente2.Repository;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findById(Long id);

    @Query("""
            SELECT b
            FROM Book b
            WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title,'%'))
            """)
    List<Book> searchBookByTitle(@Param("title") String title);

    @Query("""
            SELECT b FROM Book b
            JOIN b.categories c
            WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :category, '%'))
            """)
    List<Book> searchBookByCategory(@Param("category") String category);
}
