package com.alura.projeto.Biblioteca_Inteligente2.Classes_Abstratas;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Pessoa {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    public Pessoa(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
