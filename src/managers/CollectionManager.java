package managers;

import models.Organization;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class CollectionManager {

    private LinkedHashMap<Integer, Organization> collections;
    private LocalDateTime creationDate;

    public CollectionManager() {
        collections = new LinkedHashMap<>();
        creationDate = LocalDateTime.now();
    }

    public void insert(Integer key, Organization organization) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (organization == null) {
            throw new IllegalArgumentException("Organization cannot be null");
        }
        if (collections.containsKey(key)) {
            throw new IllegalArgumentException("Key already exists");
        }
        collections.put(key, organization);
    }
    public void remove(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (!collections.containsKey(key)) {
            throw new IllegalArgumentException("Key does not exist");
        }
        collections.remove(key);
    }
    public void clear() {
        collections.clear();
    }
    public void info() {
        System.out.println("Collection type: " + collections.getClass().getSimpleName());
        System.out.println("Creation date: " + creationDate);
        System.out.println("Number of elements: " + collections.size());
    }

    public void show() {
        if  (collections.isEmpty()) {
            System.out.println("Collection is empty");
            return;
        }
        for (Organization organization : collections.values()) {
            System.out.println(organization);
        }
    }
}
