import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        DateAndTimeService dateAndTimeService = new DateAndTimeService();

        for (int i = 0; i < 5; ) {
            extractLiveBTCPrice();
            DateAndTimeService.displayLocalDateAndTime();
            System.out.println("next reading in " + dateAndTimeService.getTimeIntervalInMiliseconds() / (60 * 1000) + " minutes");
            Thread.sleep(dateAndTimeService.getTimeIntervalInMiliseconds());
            i++;
        }
    }

    private static void extractLiveBTCPrice() throws IOException, InterruptedException {
        //creates instances of my classes
        TextFileService textFileService = new TextFileService(); //textFileService is responsible for writing stuff to a text file on my Dropbox
        UrlService urlService = new UrlService(); //urlService is responsible for extracting URL

        String responseBodyString = HttpService.extractResponseFromURL(urlService);

        String sequenceToBeFound = "The live price of BTC is ";

        Pattern word = Pattern.compile(sequenceToBeFound);
        Matcher match = word.matcher(responseBodyString);

        while (match.find()) {
            printExtractedBTCPriceAndSaveToDropbox(responseBodyString, match);
        }
    }

    private static void printExtractedBTCPriceAndSaveToDropbox(String responseBodyString, Matcher match) throws IOException {
        String extractedBTCPrice = responseBodyString.substring(match.end(), match.end() + 11);
        System.out.println("BTC price is currently: " + extractedBTCPrice);
        TextFileService textFileService = new TextFileService();
        textFileService.writeTextToFile("BTC price is currently: " + extractedBTCPrice);

    }
}