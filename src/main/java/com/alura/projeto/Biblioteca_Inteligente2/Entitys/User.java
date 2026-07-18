package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import com.alura.projeto.Biblioteca_Inteligente2.Classes_Abstratas.Pessoa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "smartlibrary")
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
}
