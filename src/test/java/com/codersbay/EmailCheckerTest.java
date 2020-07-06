package com.codersbay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailCheckerTest {


    @Test
    @DisplayName("Test that email input with Null throws exception")
    public void testValidateEmailWithNullInput() {
        String enteredEmail = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkForEmptyString(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that email input with empty String throws exception")
    public void testValidateEmailWithEmptyString() {
        String enteredEmail = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkForEmptyString(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that email with @-sign returns true")
    public void testCheckForAtSign1() {
        String enteredEmail = "captainlisa@pirate.com";

        Assertions.assertEquals(true, Main.checkForAtSign(enteredEmail));
    }

    @Test
    @DisplayName("Test that email without @-sign throws exception")
    public void testCheckForAtSign2() {
        String enteredEmail = "captainlisapirate.com";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkForAtSign(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that invalid local part throws exception")
    public void testCheckForLengthOfLocalPartTooShort1() {
        String enteredEmail = "ar@pirate.com";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkIfLengthOfLocalPartTooShort(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that valid local part returns true")
    public void testCheckForLengthOfLocalPartTooShort2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkIfLengthOfLocalPartTooShort(enteredEmail));
    }

    @Test
    @DisplayName("Test that an exception is thrown if local part is longer than 64 chars")
    public void testCheckForLengthOfLocalPartTooLong1() {
        String enteredEmail = "captainscaptainscaptainscaptainscaptainscaptainscaptainscaptainscaptains@pirate.com";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkIfLengthOfLocalPartTooLong(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that valid local part returns true")
    public void testCheckForLengthOfLocalPartTooLong2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkIfLengthOfLocalPartTooLong(enteredEmail));
    }

    @Test
    @DisplayName("Test that a domain that is too short throws exception")
    public void testCheckForDomain1() {
        String enteredEmail = "captain@pirate";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkForDomain(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that a domain that is too long throws exception")
    public void testCheckForDomain2() {
        String enteredEmail = "captain@pirate.ccom";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkForDomain(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that a valid domain returns true")
    public void testCheckForDomain3() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForDomain(enteredEmail));
    }

    @Test
    @DisplayName("Test that email that starts with '.' throws exception")
    public void testCheckForFirstChar1() {
        String enteredEmail = ".captain@pirate.com";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkForFirstChar(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that valid email returns true when checked for first char")
    public void testCheckForFirstChar2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForFirstChar(enteredEmail));
    }

    @Test
    @DisplayName("Test that empty space in the email throws exception")
    public void testCheckForEmptySpace1() {
        String enteredEmail = "captain @pirate.com";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           Main.checkForEmptySpace(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that valid email checked for empty space returns true")
    public void testCheckForEmptySpace2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForEmptySpace(enteredEmail));
    }

    @Test
    @DisplayName("Test that email with more than one @-signs throws exception")
    public void testCheckForMoreThanOneAtSign1() {
        String enteredEmail = "captain@boss@pirate.com";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.checkForMoreThanOneAtSign(enteredEmail);
        });
    }

    @Test
    @DisplayName("Test that email with one @-signs returns true")
    public void testCheckForMoreThanOneAtSign2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForMoreThanOneAtSign(enteredEmail));
    }

}
