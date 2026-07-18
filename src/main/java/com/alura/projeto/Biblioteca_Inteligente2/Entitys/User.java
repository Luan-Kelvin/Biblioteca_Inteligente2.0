package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import com.alura.projeto.Biblioteca_Inteligente2.Classes_Abstratas.Pessoa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users", schema = "smartlibrary")
@EqualsAndHashCode
public class User extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    public User(String name, String email) {
        super(name, email);
    }
}
