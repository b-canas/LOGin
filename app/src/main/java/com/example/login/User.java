package com.example.login;

import java.io.Serializable;

/*Serializable will be implemented to allow this instances of this class to
 * be passed through intents  */
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class User implements Serializable {
    private String email;
    private String password;
    private String firstName; //must be at least 3 characters and no more than 30
    private String lastName;
    private String birthday; //format: MM/DD/YYYY

    public User(String email, String password, String firstName, String lastName, String birthday) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }
}