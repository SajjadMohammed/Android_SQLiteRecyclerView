package com.sajjad.sqliterecyclerview.PersonPackage;

public class PersonModel {
    private int personId, personAge;
    private String personName;
    private byte[] imageBytes;

    public PersonModel(int personId, String personName, int personAge, byte[] imageBytes) {
        this.personId = personId;
        this.personAge = personAge;
        this.personName = personName;
        this.imageBytes = imageBytes;
    }

    int getPersonId() {
        return personId;
    }

    int getPersonAge() {
        return personAge;
    }

    String getPersonName() {
        return personName;
    }

    byte[] getImageBytes() {
        return imageBytes;
    }
}
