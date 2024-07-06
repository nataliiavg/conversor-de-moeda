package br.com.natalia.challenge.modelos;

import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaExchangeRateAPI {
    public double pegaCotacao(String moedaInicial, String moedaConvertida) {

        String chaveAPI = "2aa7729dd2f29444823e008b";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + chaveAPI + "/latest/" + moedaInicial);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonParser jsonParser = new JsonParser();
            JsonElement elementoJson = jsonParser.parse(new InputStreamReader((InputStream)request.getContent()));
            JsonObject objetoJson = elementoJson.getAsJsonObject();

            JsonObject taxasDeConversao = objetoJson.getAsJsonObject("conversion_rates");


            return taxasDeConversao.get(moedaConvertida).getAsDouble();
        } catch (IOException | InterruptedException e){
            System.out.println("Houve um erro durante a consulta à API ExchangeRate ." + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}
