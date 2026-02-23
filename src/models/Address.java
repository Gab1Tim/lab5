package models;

public class Address {

    private String zipCode;

    public Address(String zipCode) {

        if (zipCode != null && zipCode.length() > 19) {
            throw new IllegalArgumentException("zipCode cannot be longer than 19 characters");
        }
        this.zipCode = zipCode;

    }
}
