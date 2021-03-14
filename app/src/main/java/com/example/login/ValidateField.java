package com.example.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateField {
    private static Pattern regex;      /* Pattern to create regex patterns for validation */
    private static Matcher matcher;    /* Matcher to compare input to regex pattern */

    //email regex verification taken from emailregex.com
    private static final String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`"
            + "{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\"
            + "x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")"
            + "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
            + "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?"
            + "[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?"
            + "|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21"
            + "-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+"
            + ")\\])";

    private static final String dateRegex = "\\d{2}/\\d{2}/\\d{4}"; //Format: MM/DD/YYYY

    /* Name field regex follows these rules:
     * 1) name is between 3 and 30 characters
     * 2) starts with a letter and ends with a letter
     * 3) may contain a hyphen '-' character
     */
    private static final String nameRegex = "(?i)[a-z]([- ',.a-z]{1,28}[a-z])?";

    /* Returns true is String supplied to function had a valid email structure */
    public static boolean isValidEmail(String email) {
        regex = Pattern.compile(emailRegex);
        matcher = regex.matcher(email);

        return matcher.matches();
    }
    /* Returns true is String supplied to function had a valid date structure */
    public static boolean isValidDate(String date) {
        regex = Pattern.compile(dateRegex);
        matcher = regex.matcher(date);

        return matcher.matches();
    }
    /* Returns true is String supplied to function had a valid name structure */
    public static boolean isValidName(String name) {
        regex = Pattern.compile(nameRegex);
        matcher = regex.matcher(name);

        return matcher.matches();
    }
}
