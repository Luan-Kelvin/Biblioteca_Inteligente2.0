package com.alura.projeto.Biblioteca_Inteligente2.Convertes;

import com.alura.projeto.Biblioteca_Inteligente2.DTOs.AuthorDTO;
import com.alura.projeto.Biblioteca_Inteligente2.DTOs.BookDTO;
import com.alura.projeto.Biblioteca_Inteligente2.DTOs.CategoryDTO;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Author;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Book;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Convertes {

    public BookDTO converterBook(Book book){
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        List<AuthorDTO> authorsDTO = new ArrayList<>();

        book.getCategories().forEach(c -> {
            categoriesDTO.add(converterCategory(c));
        });

        book.getAuthors().forEach(a -> {
            authorsDTO.add(converterAuthor(a));
        });

        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getDescricao(),
                book.getYearOfPublication(),
                book.getPrice(),
                book.getEstoque(),
                book.getPublisher(),
                categoriesDTO,
                authorsDTO
        );
    }

    public CategoryDTO converterCategory(Category category){
        return new CategoryDTO(category.getId(), category.getName());
    }

    public AuthorDTO converterAuthor(Author author){
        List<String> booksName = new ArrayList<>();

        author.getBooks().forEach(b -> {
            booksName.add(b.getTitle());
        });

        return new AuthorDTO(
                author.getId(),
                author.getName(),
                author.getCountry(),
                author.getDateOfBirth(),
                booksName
        );
    }
}
