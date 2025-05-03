import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Database_Connection {

    public void search (String cepSearch) throws IOException, InterruptedException {

        String cepSearch1 = "http://viacep.com.br/ws/" + cepSearch + "/json/";
        System.out.println(cepSearch1);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(cepSearch1))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        ViaCEP endereco = gson.fromJson(json, ViaCEP.class);

        System.out.println("Endereço:");
        System.out.println("Rua: " + endereco.logradouro());
        System.out.println("Bairro: " + endereco.bairro());
        System.out.println("Cidade: " + endereco.localidade());
        System.out.println("Estado: " + endereco.uf());

    }
}
