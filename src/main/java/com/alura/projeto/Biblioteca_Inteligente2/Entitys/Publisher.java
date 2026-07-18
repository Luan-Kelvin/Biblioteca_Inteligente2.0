package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers", schema = "smartlibrary")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Publisher(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addBook(Book book){
        if(book == null){
            return;
        }

        if(!books.contains(book)){
            books.add(book);
        }

        if(book.getPublisher() != this){
            book.setPublisher(this);
        }
    }
}
