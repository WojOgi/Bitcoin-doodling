import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        DateAndTimeService dateAndTimeService = new DateAndTimeService();
        Scanner scanner = new Scanner(System.in);
        int nrOfReadouts;

        System.out.println("Set time interval for the readout in minutes: ");
        dateAndTimeService.setTimeIntervalInMinutes(scanner.nextDouble());
        System.out.println("Set number of readouts: ");
        nrOfReadouts = scanner.nextInt();


        for (int i = 0; i < nrOfReadouts; ) {
            extractLiveBTCPrice();
            DateAndTimeService.displayLocalDateAndTime();
            System.out.println("next reading in " + dateAndTimeService.getTimeIntervalInMinutes() + " minutes. " + (i+1) + " readings out of " + nrOfReadouts + " remaining.");
            Thread.sleep((long) (1000L *60*dateAndTimeService.getTimeIntervalInMinutes()));
            i++;
            if(i == nrOfReadouts){
                System.out.println("End of the program.");
            }
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