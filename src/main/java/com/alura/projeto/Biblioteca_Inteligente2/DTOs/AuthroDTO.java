package com.alura.projeto.Biblioteca_Inteligente2.DTOs;

import java.time.LocalDate;
import java.util.List;

public record AuthroDTO(
         Long id,

         String name,

         String country,

         LocalDate dateOfBirth,

         List<BookDTO> books
) {
}
