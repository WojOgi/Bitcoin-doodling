
import java.io.IOException;
import java.net.*;
import java.io.*;

// Podkreślenie w nazwie klasy? Aj - boli
public class URL_Service {
// niepotrzebna pusta linia

    // double jako default ma 0
    private final double bitcoinPrice = 0;
    // może to być zmienna statyczna. Jak tak, to winna się nazywa URL. A jak już jesteśmy przy nazwie - może bardziej opisująca? Bo URL nic nie mówi - muszę czytać wartość tego URL by się dowiedzieć co i jak :(
    private final URL url = new URL("https://www.binance.com/en/price/bitcoin");


    // na pewno chcesz zwracać null?
    // throws IOException? Czy aby na pewno?
    public String getBitcoinPrice() throws IOException {
        return null;
    }

    // throws?
    public URL_Service() throws IOException {

    }

    public String getUrlAsString() {
        return url.toString();
    }
}
