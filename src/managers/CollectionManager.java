package managers;

import models.Organization;
import models.OrganizationType;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionManager {

    private LinkedHashMap<Integer, Organization> collections;
    private LocalDateTime creationDate;
    private FileManager fileManager;


    public CollectionManager(String fileName) {
        fileManager = new FileManager(fileName);
        collections = fileManager.load();
        creationDate = LocalDateTime.now();

        if (collections == null) {
            collections = new LinkedHashMap<>();
        }
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

    public boolean containsKey(Integer key) {
        return collections.containsKey(key);
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
        if (collections.isEmpty()) {
            System.out.println("Collection is empty");
            return;
        }
        for (Map.Entry<Integer, Organization> entry : collections.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | " + entry.getValue());
        }
    }

    public void update(Long id, Organization newOrg) {
        boolean found = false;
        for (Map.Entry<Integer, Organization> entry : collections.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                collections.put(entry.getKey(), newOrg);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Organization with id " + id + " does not exist");
        }

    }
    public void removeGreaterKey(Integer referenceKey) {
        LinkedHashMap<Integer, Organization> toRemove = new LinkedHashMap<>();

        for (Map.Entry<Integer, Organization> entry : collections.entrySet()) {
            if (entry.getKey() > referenceKey) {
                toRemove.put(entry.getKey(), entry.getValue());
            }
        }

        for (Integer key : toRemove.keySet()) {
            collections.remove(key);
        }
    }

    public Organization getMinByName() {
        if (collections.isEmpty()) {
            return null;
        }

        Organization minOrg = null;
        for (Organization org : collections.values()) {
            if (minOrg == null || org.getName().compareTo(minOrg.getName()) < 0) {
                minOrg = org;
            }
        }
        return minOrg;
    }

    public void filterGreaterThanType(OrganizationType referenceType) {
        boolean found = false;
        for (Organization org : collections.values()) {
            if (org.getType() != null && org.getType().ordinal() > referenceType.ordinal()) {
                System.out.println(org);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No organizations found with type greater than " + referenceType);
        }
    }


    public void printUniqueAnnualTurnover() {
        if (collections.isEmpty()) {
            System.out.println("Collection is empty!");
            return;
        }

        HashSet<Integer> uniqueTurnovers = new HashSet<>();
        for (Organization org : collections.values()) {
            uniqueTurnovers.add(org.getAnnualTurnover());
        }

        System.out.println("Unique annual turnover values:");
        for (Integer turnover : uniqueTurnovers) {
            System.out.println(turnover);
        }
    }

    public LinkedHashMap<Integer, Organization> getCollection() {
        return collections;
    }


    public int removeLower(Organization reference) {
        Iterator<Map.Entry<Integer, Organization>> iterator =
                collections.entrySet().iterator();

        int removedCount = 0;

        while (iterator.hasNext()) {
            Organization current = iterator.next().getValue();
            if (current.compareTo(reference) < 0) {
                iterator.remove();
                removedCount++;
            }
        }
        return removedCount;
    }

    public void save() {
        fileManager.save(collections);
    }

}
