import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {
    public static String extractResponseFromURL(UrlService urlService) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        //zastanowic sie czy jako parameter czy w polu - TO DO na potem
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlService.getUrlAsString()))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
