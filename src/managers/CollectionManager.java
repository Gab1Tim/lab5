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

    }
}
