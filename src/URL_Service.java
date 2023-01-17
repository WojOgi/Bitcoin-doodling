
import java.io.IOException;
import java.net.*;
import java.io.*;

public class URL_Service {

    private final URL url = new URL("https://www.binance.com/en/price/bitcoin");

    public URL_Service() throws IOException {
    }
    public String getUrlAsString() {
        return url.toString();
    }
}
