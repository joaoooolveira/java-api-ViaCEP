package br.com.alura.modulos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarCEP {

    public CEP ConsultarEndereco(String cep) {
        URI linkURL = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(linkURL)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CEP.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse br.com.alura.modulos.CEP.");
        }
    }
}