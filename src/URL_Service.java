
import java.io.IOException;
import java.net.*;
import java.io.*;

public class URL_Service {


    private final double bitcoinPrice = 0;
    private final URL url = new URL("https://www.binance.com/en/price/bitcoin");


    public String getBitcoinPrice() throws IOException {
        return null;
    }

    public URL_Service() throws IOException {

    }

    public String getUrlAsString() {
        return url.toString();
    }
}
