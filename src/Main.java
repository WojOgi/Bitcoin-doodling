import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //creates instances of my classes
        TextFileService textFileService = new TextFileService(); //textFileService is responsible for writing stuff to a text file on my Dropbox
        URL_Service urlService = new URL_Service(); //urlService is responsible for extracting URL

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlService.getUrlAsString()))
                .GET() // GET is default
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String responseBodyString = response.body();

        String sequenceToBeFound = "The live price of BTC is ";

        Pattern word = Pattern.compile(sequenceToBeFound);
        Matcher match = word.matcher(responseBodyString);

        while (match.find()) {

            //System.out.print(match.start()-1);
            //System.out.print(" " + sequenceToBeFound + " ");
            //System.out.println(match.end());
            printExtractedBTCPriceAndSaveToDropbox(responseBodyString, match);
        }

    }
    private static void printExtractedBTCPriceAndSaveToDropbox(String responseBodyString, Matcher match) throws IOException {
        String extractedBTCPrice = responseBodyString.substring(match.end() + 0, match.end() + 11);
        System.out.println("BTC price is currently: "+ extractedBTCPrice);
        TextFileService textFileService= new TextFileService();
        textFileService.writeTextToFile("BTC price is currently: "+extractedBTCPrice);

    }
}