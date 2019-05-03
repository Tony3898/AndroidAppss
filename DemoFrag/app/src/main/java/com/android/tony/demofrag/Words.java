package com.android.tony.demofrag;

public class Words {

    private String firstName,lastName;
    int registarionnumber;

    Words(String firstName,String lastName, int registarionnumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registarionnumber = registarionnumber;
    }

    public int getRegistarionnumber() {
        return registarionnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}

