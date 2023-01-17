import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileService {

    private final Path path = Paths.get("C:\\Users\\ogieglw\\Dropbox\\! temp stuff\\doodle.txt");

    public void writeTextToFile(String textToWriteToFile) {
        try {
            Files.writeString(path, textToWriteToFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
