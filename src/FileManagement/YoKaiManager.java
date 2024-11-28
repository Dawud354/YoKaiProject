package FileManagement;

import YoKaiCode.YoKai;

/**
 * YoKaiManager class is responsible for saving and loading YoKaiCode.YoKai objects to and from JSON files.
 * It uses the FileManagement.JsonUtil class to serialize and deserialize the YoKaiCode.YoKai objects.
 * The FileManagement.FileIOManager class is used to get the file path for saving and loading the YoKaiCode.YoKai objects.
 * @author dawud
 * @version 1.0
 * @since 24/11/2024
 */
public class YoKaiManager {

    /**
     * @since 1.0
     * Save a YoKaiCode.YoKai object to a JSON file.
     * @param filename the name of the file to save to
     * @param yoKai the YoKaiCode.YoKai object to save
     * @throws IllegalArgumentException if the filename is invalid
     */
    public static void saveYoKai(String filename, YoKai yoKai) {
        if (!JsonUtil.isValidJsonFileName(filename)) {
            throw new IllegalArgumentException("Invalid filename.");
        }
        String filePath = FileIOManager.getFilePath("YoKaiCode.YoKai", filename);
        JsonUtil.saveToJsonFile(filePath, yoKai);
    } // END saveYoKai


    /**
     * @since 1.0
     * Load a YoKaiCode.YoKai object from a JSON file.
     * @param yoKaiName the name of the yo kai to load
     * @return the loaded YoKaiCode.YoKai object
     * @throws IllegalArgumentException if the filename is invalid
     */
    public static YoKai loadYoKai(String yoKaiName) {
        String filename = yoKaiName + ".json";
        String filePath = FileIOManager.getFilePath("YoKai", filename);
        YoKai yoKai = JsonUtil.loadFromJsonFile(filePath, YoKai.class);
        return yoKai;
    } // END loadYoKai
}
