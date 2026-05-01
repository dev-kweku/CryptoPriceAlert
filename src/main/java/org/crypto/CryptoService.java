package org.crypto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CryptoService {
    private final String apiKey;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public CryptoService(){
        Dotenv dotenv= Dotenv.load();
        this.apiKey=dotenv.get("COINGECKO_API_KEY");
        this.client=HttpClient.newHttpClient();
        this.mapper=new ObjectMapper();
    }

    public double fetchDataPrice(String coinId,String currency) throws Exception{
        String url=String.format("https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=%s",coinId,currency);

        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-cg-demo-api-key",apiKey)
                .GET()
                .build();

        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
        if(response.statusCode()!= 200){
            throw new RuntimeException("API Error :" + response.statusCode());
        }
        JsonNode root=mapper.readTree(response.body());
        return root.path(coinId).path(currency).asDouble();
    }
}
