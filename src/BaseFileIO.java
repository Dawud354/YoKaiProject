import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BaseFileIO{
    // Counts how much rows are in a csv
    //
    public static int rowsInCSV(String filePath) throws IOException {
        int rows = 0;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        while (line != null) {
            rows++;
            line = br.readLine();
        }
        br.close();
        return rows;
    }
}
