package com.alura.projeto.Biblioteca_Inteligente2.API.ApiService;

import com.alura.projeto.Biblioteca_Inteligente2.API.DTO.DocsBook;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumeApi {
    private ObjectMapper mapper = new ObjectMapper();
    private static final String adress = "https://openlibrary.org/search.json?title=";

    public DocsBook consumeApi(String title){
        HttpClient client = HttpClient.newHttpClient();

        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(adress+title.replace(" ", "+").trim().toLowerCase()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200){
                throw new RuntimeException("Erro ao consumir API: "+response.statusCode());
            }

            return mapper.readValue(response.body(), DocsBook.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
