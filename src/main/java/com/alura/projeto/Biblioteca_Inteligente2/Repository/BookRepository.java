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

    @Query("""
            SELECT b
            FROM Book b
            JOIN b.authors a
            WHERE LOWER(a.name) ILIKE LOWER(:author)
            """)
    List<Book> searchByAuthor(@Param("author") String author);

    @Query("""
            SELECT b
            FROM Publisher p
            JOIN p.books b
            WHERE LOWER(p.name) ILIKE LOWER(:namePublisher)
            """)
    List<Book> serachByPublisher(@Param("namePublisher") String namePublisher);

    @Query("""
            SELECT b
            FROM Book b
            WHERE b.estoque > 0
            """)
    List<Book> checkAvaliableBooks();
}
