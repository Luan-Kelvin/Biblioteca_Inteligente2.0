package com.alura.projeto.Biblioteca_Inteligente2.DTOs;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Loan;
import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Profile;

import java.util.List;

public record UserDTO(
         Long id,

         String email,

         List<Loan> loans,

          Profile profile,

         List<BookDTO> livrosFavoritos
) {
}
