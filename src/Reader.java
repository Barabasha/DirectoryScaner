import java.io.FileNotFoundException;
import java.io.IOException;

public interface Reader {
    String read() throws FileNotFoundException, IOException, IOException;

}
