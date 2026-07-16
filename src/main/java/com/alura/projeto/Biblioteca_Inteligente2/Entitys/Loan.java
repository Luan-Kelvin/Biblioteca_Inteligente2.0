package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "loans", schema = "smartlibrary")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate loanDate = LocalDate.now();

    @Column(nullable = false)
    private LocalDate shceduledDate;

    private String status = "EMPRESTADO";

    public Loan(LocalDate loanDate, LocalDate shceduledDate, String status) {
        this.loanDate = loanDate;
        this.shceduledDate = shceduledDate;
        this.status = status;
    }
}
