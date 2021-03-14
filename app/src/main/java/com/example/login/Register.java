package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private UserDatabase users; //this will be initialized through onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Grab UserDatabase object from intent that was passed from Splash.java
        users = (UserDatabase) getIntent().getSerializableExtra("userDatabase");
    }

    public void goToLogin(View v)
    {
        Intent i = new Intent(Register.this, Login.class);

        // Pass UserDatabase along
        i.putExtra("userDatabase", users);

        //Start new activity
        startActivity(i);
        finish();
    }

    public void register(View v) {
        EditText firstNameInput, lastNameInput, birthdayInput,
                emailInput, passwordInput, confirmPasswordInput;

        String firstName, lastName, birthday, email, password, confirmPassword;

        boolean invalidField = false;

        //Get all input fields' text
        firstNameInput = (EditText)findViewById(R.id.editTextRegisterFirstName);
        lastNameInput = (EditText)findViewById(R.id.editTextRegisterLastName);
        birthdayInput = (EditText)findViewById(R.id.editTextRegisterDateOfBirth);
        emailInput = (EditText)findViewById(R.id.editTextRegisterEmail);
        passwordInput = (EditText)findViewById(R.id.editTextRegisterPassword);
        confirmPasswordInput = (EditText)findViewById(R.id.editTextRegisterPasswordConfirm);

        firstName = firstNameInput.getText().toString();
        lastName = lastNameInput.getText().toString();
        birthday = birthdayInput.getText().toString();
        email = emailInput.getText().toString();
        password = passwordInput.getText().toString();
        confirmPassword = confirmPasswordInput.getText().toString();

        //check for empty strings
        if (firstName.equals("") || lastName.equals("") || birthday.equals("")
            || email.equals("") || password.equals("") || confirmPassword.equals(""))
        {
            //Display Toast informing of empty fields
            Toast toast = Toast.makeText(getApplicationContext(),
                    "All fields must be filled.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            /* Validate fields: firstName, lastName, email, and birthdate
            *  if invalid, set invalidField flag to true and mark field with .setError */
            if (!ValidateField.isValidName(firstName)) {
                //firstName is NOT valid
                invalidField = true;
                firstNameInput.setError("Invalid name format. Try again.");
            }
            if (!ValidateField.isValidName(lastName)) {
                //lastName is NOT valid
                invalidField = true;
                lastNameInput.setError("Invalid name format. Try again.");
            }
            if (!ValidateField.isValidEmail(email)) {
                //email is NOT valid
                invalidField = true;
                emailInput.setError("Invalid email format. Try again.");
            }
            if (!ValidateField.isValidDate(birthday)) {
                //birthday is NOT valid
                invalidField = true;
                birthdayInput.setError("Invalid birthday format. Try again. MUST be MM/DD/YYYY");
            }
            //check if passwords match. If they don't set both fields' error message
            if (!password.equals(confirmPassword)) {
                invalidField = true;
                passwordInput.setError("Passwords do not match.");
                confirmPasswordInput.setError("Passwords do not match");
            }

            /* if invalidField flag == false at this point then all fields are cleared and
             *  new User can be created and inserted  */
            if (!invalidField) {
                User newUser = new User(email, password, firstName, lastName, birthday);
                users.addUser(newUser);

                /* After successful registration redirect to MainActivity and
                 *  pass UserDatabase object along  */
                Intent i = new Intent(Register.this, MainActivity.class);
                i.putExtra("userDatabase", users);
                startActivity(i);
                finish();
            }
        }
    }
}