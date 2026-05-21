package models;

import com.github.javafaker.Faker;

public class User {

    private final String firstname;
    private final String lastname;
    private final String zipcode;

    public User(){
        final var faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        zipcode = faker.address().zipCode();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getZipcode() {
        return zipcode;
    }
}
