package com.alura.projeto.Biblioteca_Inteligente2.DTOs;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Publisher;

import java.util.List;

public record BookDTO(
         Long id,

         String title,

         String descricao,

         Integer yearOfPublication,

         Double price,

         Integer estoque,

         Publisher publisher,

         List<CategoryDTO> categories,

         List<AuthorDTO> authors
) {
}
