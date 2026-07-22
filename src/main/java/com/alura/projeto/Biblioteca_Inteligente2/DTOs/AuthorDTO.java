package com.alura.projeto.Biblioteca_Inteligente2.DTOs;

import java.time.LocalDate;
import java.util.List;

public record AuthorDTO(
         String name,

         String country,

         LocalDate dateOfBirth,

         List<String> books
) {
}
