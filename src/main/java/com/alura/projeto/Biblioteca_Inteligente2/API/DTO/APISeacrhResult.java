package com.alura.projeto.Biblioteca_Inteligente2.API.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record APISeacrhResult(
        @JsonAlias("author_name") List<String> nameAuthors,
        @JsonAlias("first_publish_year") Integer yearOfPublication,
        @JsonAlias("title") String title
        )
{}
