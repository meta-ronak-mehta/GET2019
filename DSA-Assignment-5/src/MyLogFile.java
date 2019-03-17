
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyLogFile {

    /**
     * method to write message in Log file
     * 
     * @param message of Exception
     */
    public static void writeToFile(String message) {
        try {
            Files.write(Paths.get("MyLogs.txt"), message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}