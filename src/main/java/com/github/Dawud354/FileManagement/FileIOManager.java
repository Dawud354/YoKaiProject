package com.github.Dawud354.FileManagement;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

/**
 * Manages file input/output operations for the game.
 * 
 * @author dawud
 * @version 1.0
 * @since 24/11/2024
 */
public class FileIOManager {

    // Base directory for all game files
    private static final String BASE_DIRECTORY = "data";

    /**
     * Saves an object to a specified file path in JSON format.
     * Creates parent directories if they do not exist.
     * 
     * @param <T> The type of the object to save.
     * @param filePath The file path where the object will be saved.
     * @param object The object to save.
     */
    public <T> void save(String filePath, T object) {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        JsonUtil.saveToJsonFile(filePath, object);
    }


    /**
     * Loads an object from a specified file path in JSON format.
     * 
     * @param <T> The type of the object to load.
     * @param filePath The file path from which the object will be loaded.
     * @param objectClass The class of the object to load.
     * @return The loaded object.
     */
    public <T> T load(String filePath, Class<T> objectClass) {
        System.out.println("Loading from file: " + filePath);
        return JsonUtil.loadFromJsonFile(filePath, objectClass);
    }

    /**
     * Retrieves all file names from a specified directory.
     * The file path is relative to the base directory.
     * No need to pass in "data/folder1/folder2"
     * Can just pass in "folder1/folder2"
     * 
     * @param filePath The directory from which to retrieve file names.
     * @return An array of file names in the specified directory.
     */
    public static String[] getAllFileNames(String filePath) {
        String directoryPath = BASE_DIRECTORY + File.separator + filePath; 
        System.out.println("Getting all file names from directory: " + directoryPath); 
        File directory = new File(directoryPath); 
        return directory.list();
    }
}
