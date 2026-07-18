package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import com.alura.projeto.Biblioteca_Inteligente2.Classes_Abstratas.Pessoa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "smartlibrary")
@Getter
@Setter
public class User extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans = new ArrayList<>();

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Profile profile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "favorite_books",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    private List<Book> favoritos = new ArrayList<>();

    public User(String name, String email) {
        super(name, email);
    }

    public void addLoan(Loan loan){
        if(!loans.contains(loan)){
            loans.add(loan);
        }
    }

    public void addFavorite(Book book){

        if(!favoritos.contains(book)){
            favoritos.add(book);
        }

        if(!book.getUserWhoFavorited().contains(this)){
            book.getUserWhoFavorited().add(this);
        }
    }
}
