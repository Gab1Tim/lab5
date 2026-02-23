package models;

import java.util.Date;

public class Organization {

    private Long id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private int annualTurnover;
    private OrganizationType type;
    private Address officialAddress;

    public Organization(
            String name,
            Coordinates coordinates,
            int annualTurnover,
            OrganizationType type,
            Address officialAddress) {

        this.id = generateId();
        this.creationDate = new Date();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if  (coordinates == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        if (annualTurnover <= 0) {
            throw new IllegalArgumentException("Annual turnover must be greater than 0");
        }

        if (officialAddress == null) {
            throw new IllegalArgumentException("Official address cannot be null");
        }

        this.name = name;
        this.coordinates = coordinates;
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.officialAddress = officialAddress;
    }

    private static long nextId = 1;

    private static long generateId() {
        return nextId++;

    }
}
