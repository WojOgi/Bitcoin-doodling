import java.io.IOException;
import java.net.URL;

public class UrlService {

    private final URL urlToBitcoinPriceSource = new URL("https://www.binance.com/en/price/bitcoin");

    public UrlService() throws IOException {
    }
    public String getUrlAsString() {
        return urlToBitcoinPriceSource.toString();
    }
}
