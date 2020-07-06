package com.codersbay;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter your e-mail address:");
        System.out.println("(We will not violate your privacy or send you spam emails.)");

        Scanner scan = new Scanner(System.in);
        String enteredEmail = toLowerCase(scan.nextLine());
        validateEmailInput(enteredEmail);

    }

    public static boolean validateEmailInput(String enteredEmail) {
        if (checkForEmptySpace(enteredEmail) && checkForAtSign(enteredEmail) && checkIfLengthOfLocalPartTooShort(enteredEmail) && checkIfLengthOfLocalPartTooLong(enteredEmail) &&
                checkForDomain(enteredEmail) && checkForFirstChar(enteredEmail) && checkForEmptySpace(enteredEmail) && checkForMoreThanOneAtSign(enteredEmail)) {
            System.out.printf("The email you entered is: %s\n", enteredEmail);
            return true;
        } else {
            return false;
        }

    }

    public static void checkForEmptyString(String enteredEmail) {
        if (enteredEmail == null || enteredEmail.equals("")) {
            throw new IllegalArgumentException("Email cannot be null. Please enter a valid email.");
        }
    }

    public static boolean checkForAtSign(String enteredEmail) {
        //check if email contains "@"
        if (enteredEmail.contains("@")) {
            return true;
        } else {
            throw new IllegalArgumentException("Email has to contain one '@'. Please enter a valid email.");
        }
    }

    public static boolean checkIfLengthOfLocalPartTooShort(String enteredEmail) {
        //check that there is at least 1 char before @
        int indexOfAtSign = enteredEmail.indexOf("@");
        if (indexOfAtSign < 3) {
            throw new IllegalArgumentException("The local part of the email must be at least 3 characters long.");
        } else {
            return true;
        }
    }

    public static boolean checkIfLengthOfLocalPartTooLong(String enteredEmail) {
        //check that the local part is not longer than 64 characters
        int indexOfAtSign = enteredEmail.indexOf("@");
        if (indexOfAtSign >= 64) {
            throw new IllegalArgumentException("the local part of the email cannot be longer than 64 characters.");
        } else {
            return true;
        }
    }

    public static boolean checkForDomain(String enteredEmail) {
        //check that email ends with a domain
        if (enteredEmail.contains(".")) {
            int indexOfDot = enteredEmail.lastIndexOf(".");
            if (indexOfDot > (enteredEmail.length() - 2) || indexOfDot < (enteredEmail.length() - 4)) {
                throw new IllegalArgumentException("Email needs a valid domain. Please enter a valid email.");
            } else {
                return true;
            }
        } else {
            throw new IllegalArgumentException("Email needs a valid domain. Please enter a valid email.");
        }
    }

    public static boolean checkForFirstChar(String enteredEmail) {
        //check that email does not start with "."

        if (enteredEmail.charAt(0) == '.') {
            throw new IllegalArgumentException("Email cannot start with a dot.");
        } else {
            return true;
        }

    }

    public static boolean checkForEmptySpace(String enteredEmail) {
        //check that email does not contain " "
        if(enteredEmail.contains(" ")) {
            throw new IllegalArgumentException("Email cannot contain blank spaces.");
        } else {
            return true;
        }
    }

    public static boolean checkForMoreThanOneAtSign(String enteredEmail) {
        //check that email does not contain more than one @-sign
        char[] emailArray = enteredEmail.toCharArray();
        Map<Character, Integer> mapOfCharacters = new HashMap<Character, Integer>();
        int counter;

        for (int i = 0; i < emailArray.length; i++) {
            char currentCharacter = emailArray[i];
            if(mapOfCharacters.containsKey(currentCharacter)) {
                counter = mapOfCharacters.get(currentCharacter);
                counter++;
                mapOfCharacters.put(currentCharacter, counter);
            } else {
                mapOfCharacters.put(currentCharacter, 1);
            }
        }

        counter = mapOfCharacters.get('@');
        if (counter > 1) {
            throw new IllegalArgumentException("Email cannot contain more than one @-sign!");
        }  else {
            return true;
        }

    }

}
