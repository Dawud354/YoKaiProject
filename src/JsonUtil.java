import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class for serializing and deserializing objects to/from JSON files.
 * This class uses the Gson library for JSON processing.
 * @author dawud
 * @version 1.0
 * @since 24/11/2024
 */
public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * @since 1.0
     * Save an object to a JSON file.
     * @param filePath the path of the file to save to
     * @param object the object to save
     * @param <T> the type of the object
     */
    public static <T> void saveToJsonFile(String filePath, T object) {
        if(filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        filePath = normaliseFileName(filePath);
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(object, writer);
            System.out.println("Saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // END saveToJsonFile

    /**
     * @since 1.0
     * Load an object from a JSON file.
     * @param filePath the path of the file to load from
     * @param classType the type of the object
     * @return the loaded object
     * @param <T> the type of the object
     */
    public static <T> T loadFromJsonFile(String filePath, Class<T> classType) {
        if(filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        filePath = normaliseFileName(filePath);
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, classType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } // END loadFromJsonFile

    /**
     * @since 1.0
     * Check if a file name is valid for a JSON file.
     * @param fileName the file name to check
     * @return true if the file name is valid, false otherwise
     */
    public static boolean isValidJsonFileName(String fileName) {
        return fileName!=null && fileName.matches("^[a-zA-Z0-9_\\-]+\\.json$");
    } // END isValidJsonFileName

    /**
     * @since 1.0
     * Normalise a file name to lowercase.
     * @param fileName the file name to normalise
     * @return the normalised file name
     */
    public static String normaliseFileName(String fileName) {
        return fileName.toLowerCase();
    } // END normaliseFileName
}
