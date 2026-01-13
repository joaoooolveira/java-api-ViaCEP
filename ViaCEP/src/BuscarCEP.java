import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarCEP {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String siglaEstado;

    public BuscarCEP(String cep){
        this.cep = cep;
    }

    public CEP ConsultarEndereco(String cep){
        Gson gson = new Gson();

        URI linkURL = URI.create("https://viacep.com.br/ws/" +  cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(linkURL)
                .build();
        HttpResponse<String> response = null;

        try {
        response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }

        return new Gson().fromJson(response.body(), CEP.class);

    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }
}
