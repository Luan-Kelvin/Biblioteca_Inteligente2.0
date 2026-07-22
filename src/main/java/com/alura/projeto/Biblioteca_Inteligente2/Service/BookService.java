package com.alura.projeto.Biblioteca_Inteligente2.Service;

import com.alura.projeto.Biblioteca_Inteligente2.API.ApiService.ConsumeApi;
import com.alura.projeto.Biblioteca_Inteligente2.API.DTO.BookApiExternaDTO;
import com.alura.projeto.Biblioteca_Inteligente2.API.DTO.DocsBook;
import com.alura.projeto.Biblioteca_Inteligente2.Convertes.Convertes;
import com.alura.projeto.Biblioteca_Inteligente2.DTOs.BookDTO;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Author;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Book;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Publisher;
import com.alura.projeto.Biblioteca_Inteligente2.Excepetion.*;
import com.alura.projeto.Biblioteca_Inteligente2.Repository.AuthorRepository;
import com.alura.projeto.Biblioteca_Inteligente2.Repository.BookRepository;
import com.alura.projeto.Biblioteca_Inteligente2.Repository.PublisherReposirtory;
import jakarta.transaction.Transactional;
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
    private final AuthorRepository authorRepository;
    private final PublisherReposirtory publisherReposirtory;
    private final ConsumeApi consumeApi;
    private final Convertes convertes;

    public List<BookDTO> listBooks(){
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()){
            logger.info("Ainda não há nenhum livro cadastrado no banco.");
            return List.of();
        }

       return returnListDto(books);
    }

    @Transactional
    public BookDTO searchById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() ->  new LivroNaoEncontradoException("Erro! livro com id = "+id+" não foi encontrado."));

        return convertes.converterBook(book);
    }

    @Transactional
    public List<BookDTO> searchByTitle(String title){
        List<Book> book = bookRepository.searchBookByTitle(title);

        if (book.isEmpty()){
            logger.info("Nenhum livro com "+title+" foi encontrado.");
            throw new LivroNaoEncontradoException("Erro! Livro com titulo "+title+" não foi encontrado.");
        }

        return returnListDto(book);
    }

    @Transactional
    public List<BookDTO> searchByCategory(String categoria){
        List<Book> books = bookRepository.searchBookByCategory(categoria);

        if (books.isEmpty()){
            logger.info("Livros com categoria "+categoria+" não foram encontrados.");
            return List.of();
        }

        return  returnListDto(books);
    }

    @Transactional
    public List<BookDTO> searchByAuthor(String autor){
        Author author = authorRepository.findByNameIgnoreCase(autor)
                .orElseThrow(() -> new AutorNaoEncontradoException("Erro! author "+autor+" não existe no banco."));

        List<Book> books = bookRepository.searchByAuthor(author.getName());

        if (books.isEmpty()){
           logger.info("Author "+author.getName()+" não tem livros cadastrados.");
           return List.of();
        }

        return returnListDto(books);
    }

    public List<BookDTO> serachByPublisher(String publisher){
        Publisher publisherRep = publisherReposirtory.findByNameIgnoreCase(publisher)
                .orElseThrow(() -> new EditoraNaoEncontradaException("Erro! editora "+publisher+" não existe no banco."));

        List<Book> books = bookRepository.serachByPublisher(publisher);

        if (books.isEmpty()){
            logger.info("Erro! não existe nenhum livro publicado por "+publisherRep.getName()+" no banco.");
            return List.of();
        }

        return returnListDto(books);
    }

    public List<BookDTO> checkAvaliableBooks(){
        List<Book> books = bookRepository.checkAvaliableBooks();

        if (books.isEmpty()){
            logger.info("Não tem nenhum livro com estoque disponível no momento");
            return List.of();
        }

        return returnListDto(books);
    }

    public BookApiExternaDTO searchForBookExternalAPIs(String title){
        DocsBook docsBook = consumeApi.consumeApi(title);

        if (docsBook.docs().isEmpty()){
            throw new ApiExternaException("Erro! ocorreu um erro na Api Externa.");
        }

        BookApiExternaDTO result = docsBook.docs().get(0);

        return result;
    }


    public List<BookDTO> returnListDto(List<Book> books){
        List<BookDTO> dtos = new ArrayList<>();

        books.forEach(b -> {
            dtos.add(convertes.converterBook(b));
        });

        return dtos;
    }
}
