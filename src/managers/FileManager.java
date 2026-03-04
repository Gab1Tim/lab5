package managers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Organization;
import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FileManager {

    private final String fileName;
    private final Gson gson = new Gson();

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public LinkedHashMap<Integer, Organization> load() {
        LinkedHashMap<Integer, Organization> map = new LinkedHashMap<>();

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return map;
            }

            Scanner scanner = new Scanner(file);
            StringBuilder json = new StringBuilder();

            while (scanner.hasNextLine()) {
                json.append(scanner.nextLine());
            }
            scanner.close();

            Type type = new TypeToken<LinkedHashMap<Integer, Organization>>(){}.getType();
            map = gson.fromJson(json.toString(), type);

            if (map == null) {
                map = new LinkedHashMap<>();
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return map;
    }

    public void save(LinkedHashMap<Integer, Organization> map) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName));

            writer.write(gson.toJson(map));
            writer.flush();
            writer.close();

            System.out.println("Collection saved.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}