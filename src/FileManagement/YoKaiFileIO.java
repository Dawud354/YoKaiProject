package FileManagement;

import java.io.IOException;
import java.io.PrintWriter;

import YoKaiCode.YoKai;
import com.google.gson.Gson;


public class YoKaiFileIO {


    public static void saveYoKai(YoKai yoKai, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            Gson gson = new Gson();
            String json = gson.toJson(yoKai);
            writer.println(json);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    }

