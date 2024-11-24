/**
 * YoKaiManager class is responsible for saving and loading YoKai objects to and from JSON files.
 * It uses the JsonUtil class to serialize and deserialize the YoKai objects.
 * The FileIOManager class is used to get the file path for saving and loading the YoKai objects.
 * @author dawud
 * @version 1.0
 * @since 24/11/2024
 */
public class YoKaiManager {

    /**
     * @since 1.0
     * Save a YoKai object to a JSON file.
     * @param filename the name of the file to save to
     * @param yoKai the YoKai object to save
     * @throws IllegalArgumentException if the filename is invalid
     */
    public static void saveYoKai(String filename, YoKai yoKai) {
        if (!JsonUtil.isValidJsonFileName(filename)) {
            throw new IllegalArgumentException("Invalid filename.");
        }
        String filePath = FileIOManager.getFilePath("YoKai", filename);
        JsonUtil.saveToJsonFile(filePath, yoKai);
        BaseTextProgram.print("Saved to " + filePath);
    } // END saveYoKai


    /**
     * @since 1.0
     * Load a YoKai object from a JSON file.
     * @param filename the name of the file to load from
     * @return the loaded YoKai object
     * @throws IllegalArgumentException if the filename is invalid
     */
    public static YoKai loadYoKai(String filename) {
        String filePath = FileIOManager.getFilePath("YoKai", filename);
        YoKai yoKai = JsonUtil.loadFromJsonFile(filePath, YoKai.class);
        BaseTextProgram.print("Loaded from " + filePath);
        return yoKai;
    } // END loadYoKai
}
