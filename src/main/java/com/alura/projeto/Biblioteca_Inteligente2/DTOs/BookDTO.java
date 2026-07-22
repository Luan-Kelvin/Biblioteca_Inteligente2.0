package com.alura.projeto.Biblioteca_Inteligente2.DTOs;

import java.util.List;

public record BookDTO(
         Long id,

         String title,

         String descricao,

         Integer yearOfPublication,

         Double price,

         Integer estoque,

         String publisher,

         List<CategoryDTO> categories,

         List<AuthorDTO> authors
) {
}
