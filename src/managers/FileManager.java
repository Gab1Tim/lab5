package managers;

import models.Organization;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class FileManager {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // --- SAVE ---
    public void save(String fileName, LinkedHashMap<Integer, Organization> collections) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName))) {
            writer.write(gson.toJson(collections));
            System.out.println("Collection saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // --- LOAD ---
    public LinkedHashMap<Integer, Organization> load(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            StringBuilder jsonBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonBuilder.append(scanner.nextLine());
            }
            scanner.close();

            Type type = new TypeToken<LinkedHashMap<Integer, Organization>>(){}.getType();
            LinkedHashMap<Integer, Organization> loaded = gson.fromJson(jsonBuilder.toString(), type);

            if (loaded != null) {
                System.out.println("Collection loaded from " + fileName);
                return loaded;
            } else {
                System.out.println("File is empty or invalid, starting with empty collection");
                return new LinkedHashMap<>();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return new LinkedHashMap<>();
        }
    }
}