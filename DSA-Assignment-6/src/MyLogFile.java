
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class MyLogFile {

    public static void writeToFile(String message) {
        try {
            message += " at "+new Date();
            Files.write(Paths.get("MyLogs.txt"), message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}