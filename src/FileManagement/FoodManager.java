package FileManagement;
import Items.Food;

/**
 * FileManagement.YoKaiManager class is responsible for saving and loading YoKaiCode.YoKai objects to and from JSON files.
 * It uses the FileManagement.JsonUtil class to serialize and deserialize the YoKaiCode.YoKai objects.
 * The FileManagement.FileIOManager class is used to get the file path for saving and loading the YoKaiCode.YoKai objects.
 * @author dawud
 * @version 1.0
 * @since 24/11/2024
 */
public class FoodManager {

    /**
     * @since 1.0
     * Load a food object from a JSON file.
     * @param foodName the name of the food to load
     * @return the loaded food object
     * @throws IllegalArgumentException if the filename is invalid
     */
    public static Food loadFood(String foodName) {
        foodName = foodName + ".json";
        String filePath = FileIOManager.getFilePath("food", foodName);
        Food food = JsonUtil.loadFromJsonFile(filePath, Food.class);
        return food;
    } // END loadYoKai
}
