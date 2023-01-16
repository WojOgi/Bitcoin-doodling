import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileService {

    // po co to pole 'textToWriteToFile' ?
    private String textToWriteToFile;
    
    // to "C:\\Users..." wyrzuciłbym do pola private statif final PATH_TO_COS_TAM
    // i tak btw - u mnie na linuxie to nie zadziała :( :( :( :(  Bo ja nie mam C:\\.,,,,
    Path path = Paths.get("C:\\Users\\ogieglw\\Dropbox\\! temp stuff\\doodle.txt");

    public TextFileService() {
    }

    public void writeTextToFile(String textToWriteToFile) throws IOException {

        try {
            Files.writeString(path, textToWriteToFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
