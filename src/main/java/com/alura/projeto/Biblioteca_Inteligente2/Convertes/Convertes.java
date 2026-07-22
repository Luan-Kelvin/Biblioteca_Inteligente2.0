package com.alura.projeto.Biblioteca_Inteligente2.Convertes;

import com.alura.projeto.Biblioteca_Inteligente2.DTOs.AuthorDTO;
import com.alura.projeto.Biblioteca_Inteligente2.DTOs.BookDTO;
import com.alura.projeto.Biblioteca_Inteligente2.DTOs.CategoryDTO;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Author;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Book;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Category;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                book.getTitle(),
                book.getDescricao(),
                book.getYearOfPublication(),
                book.getPrice(),
                book.getEstoque(),
                book.getPublisher().getName(),
                categoriesDTO,
                authorsDTO
        );
    }

    public CategoryDTO converterCategory(Category category){
        return new CategoryDTO(category.getName());
    }

    public AuthorDTO converterAuthor(Author author){
        List<String> booksName = new ArrayList<>();

        author.getBooks().forEach(b -> {
            booksName.add(b.getTitle());
        });

        return new AuthorDTO(
                author.getName(),
                author.getCountry(),
                author.getDateOfBirth(),
                booksName
        );
    }

    public Book converterBookDTO(BookDTO bookDTO, Publisher publisher){
        return new Book(
                bookDTO.title(),
                bookDTO.descricao(),
                bookDTO.yearOfPublication(),
                publisher,
                bookDTO.price(),
                bookDTO.estoque()
        );
    }

    public Author converterAuthorDTO(AuthorDTO authorDTO){

        return new Author(
                authorDTO.name(),
                authorDTO.country(),
                authorDTO.dateOfBirth()
        );
    }

    public Category converterCategoryDTO(CategoryDTO categoryDTO){
        return new Category(categoryDTO.name());
    }
}
