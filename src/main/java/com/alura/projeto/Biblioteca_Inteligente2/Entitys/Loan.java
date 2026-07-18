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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private LocalDate loanDate = LocalDate.now();

    @Column(nullable = false)
    private LocalDate shceduledDate;

    private LocalDate returnDate;

    private String status = "EMPRESTADO";

    @ManyToOne()
    @JoinColumn(name = "id_book")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Loan(LocalDate loanDate, LocalDate shceduledDate, LocalDate returnDate, String status, Book book, User user) {
        this.loanDate = loanDate;
        this.shceduledDate = shceduledDate;
        this.status = status;
        this.returnDate = returnDate;
        this.book = book;
        this.user = user;

        book.addLoan(this);
        user.addLoan(this);
    }
}
