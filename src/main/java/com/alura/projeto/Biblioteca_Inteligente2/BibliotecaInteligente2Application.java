package com.alura.projeto.Biblioteca_Inteligente2;

import com.alura.projeto.Biblioteca_Inteligente2.API.ApiService.ConsumeApi;
import com.alura.projeto.Biblioteca_Inteligente2.API.DTO.APISeacrhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@SpringBootApplication
public class BibliotecaInteligente2Application{

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaInteligente2Application.class, args);
	}

}
