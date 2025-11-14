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
public class FileIOManager<T> {

    // Base directory for all game files
    private static final String BASE_DIRECTORY = "data";

    // Ensure base directory exists
    static {
        File baseDir = new File(BASE_DIRECTORY);
        if (!baseDir.exists()) {
            baseDir.mkdirs(); // Create base directory if it doesn't exist
        }
    }

    /**
     * Get the full file path for a given category and filename.
     *
     * @param category The category (e.g., "Yo Kai", "food", "items").
     * @param fileName The name of the file (e.g., "pizza.json").
     * @return The full file path.
     */
    public static String getFilePath(String category, String fileName) {
        if (category == null || fileName == null) {
            throw new IllegalArgumentException("Category and filename cannot be null.");
        }
        String directoryPath = BASE_DIRECTORY + File.separator + category;
        File directory = new File(directoryPath);

        // Create category-specific directory if it doesn't exist
        if (!directory.exists()) {
            directory.mkdirs();
        }

        return directoryPath + File.separator + fileName;
    } // END getFilePath

    public void save(String name, T object) {
        String filePath = getFilePath(object.getClass().getSimpleName().toLowerCase(), name);
        JsonUtil.saveToJsonFile(filePath, object);
    }

    public T load(String name, Class<T> objectClass) {
        String filePath = getFilePath(objectClass.getSimpleName().toLowerCase(), name);
        System.out.println("Loading from file: " + filePath);
        return JsonUtil.loadFromJsonFile(filePath, objectClass);
    }

    public static String[] getAllFileNames(String category) {
        String directoryPath = BASE_DIRECTORY + File.separator + category; 
        System.out.println("Getting all file names from directory: " + directoryPath); 
        File directory = new File(directoryPath); 
        return directory.list();
        /*
        try {
            ClassLoader loader = FileIOManager.class.getClassLoader();
            URL url = loader.getResource(path);

            if (url != null && url.getProtocol().equals("file")) {
                // Running in IDE
                return new File(url.toURI()).list();
            } else {
                // Running from a JAR
                String jarPath = path + "/";
                List<String> fileNames = new ArrayList<>();

                JarFile jar = new JarFile(
                        new File(FileIOManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()));

                jar.stream()
                        .filter(e -> e.getName().startsWith(jarPath) && !e.isDirectory())
                        .forEach(e -> fileNames.add(
                                e.getName().substring(jarPath.length())));

                jar.close();
                return fileNames.toArray(new String[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
    */
    }
}