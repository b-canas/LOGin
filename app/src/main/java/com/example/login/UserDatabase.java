package com.example.login;

import java.io.Serializable;
import java.util.ArrayList;

/*Serializable will be implemented to allow this instances of this class to
 * be passed through intents  */
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class UserDatabase implements Serializable {
    private ArrayList<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    /*
     * This function will search for a user in userList with a matching
     *  (email, password) combination. If one is NOT found, NULL will be returned
    */
    public User getUser(String email, String password) {
        User searchedUser = null;
        User tempUser;

        for (int i=0; i < userList.size(); i++) {
            tempUser = userList.get(i);

            if (email.equals(tempUser.getEmail()) && password.equals(tempUser.getPassword())) {
                searchedUser = tempUser;
            }
        }

        return searchedUser;
    }
}
