package com.alura.projeto.Biblioteca_Inteligente2.Repository;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LonaRepository extends JpaRepository<Loan, Long> {
}
