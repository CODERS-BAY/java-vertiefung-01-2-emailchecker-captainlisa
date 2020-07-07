package com.codersbay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailCheckerTest {



    @Test
    @DisplayName("Test that email input with Null returns false")
    public void testValidateEmailWithNullInput() {
        String enteredEmail = null;
        Assertions.assertEquals(false, Main.checkForEmptyString(enteredEmail));
    }

    @Test
    @DisplayName("Test that email input with empty String returns false")
    public void testValidateEmailWithEmptyString() {
        String enteredEmail = "";
        Assertions.assertEquals(false, Main.checkForEmptyString(enteredEmail));
    }

    @Test
    @DisplayName("Test that email with @-sign returns true")
    public void testCheckForAtSign1() {
        String enteredEmail = "captainlisa@pirate.com";

        Assertions.assertEquals(true, Main.checkForAtSign(enteredEmail));
    }

    @Test
    @DisplayName("Test that email without @-sign returns false")
    public void testCheckForAtSign2() {
        String enteredEmail = "captainlisapirate.com";

        Assertions.assertEquals(false, Main.checkForAtSign(enteredEmail));
    }

    @Test
    @DisplayName("Test that invalid local part returns false")
    public void testCheckForLengthOfLocalPartTooShort1() {
        String enteredEmail = "ar@pirate.com";

        Assertions.assertEquals(false, Main.checkIfLengthOfLocalPartTooShort(enteredEmail));
    }

    @Test
    @DisplayName("Test that valid local part returns true")
    public void testCheckForLengthOfLocalPartTooShort2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkIfLengthOfLocalPartTooShort(enteredEmail));
    }

    @Test
    @DisplayName("Test that the return value is false if local part is longer than 64 chars")
    public void testCheckForLengthOfLocalPartTooLong1() {
        String enteredEmail = "captainscaptainscaptainscaptainscaptainscaptainscaptainscaptainscaptains@pirate.com";

        Assertions.assertEquals(false, Main.checkIfLengthOfLocalPartTooLong(enteredEmail));
    }

    @Test
    @DisplayName("Test that valid local part returns true")
    public void testCheckForLengthOfLocalPartTooLong2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkIfLengthOfLocalPartTooLong(enteredEmail));
    }

    @ParameterizedTest
    @ValueSource(strings = {"captain@pirate", "captain@pirate.ccom"})
    public void testCheckForDomainWithParameters(String input) {
        Assertions.assertEquals(false, Main.checkForDomain(input));
    }

    @Test
    @DisplayName("Test that a valid domain returns true")
    public void testCheckForDomain3() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForDomain(enteredEmail));
    }

    @Test
    @DisplayName("Test that email that starts with '.' returns false")
    public void testCheckForFirstChar1() {
        String enteredEmail = ".captain@pirate.com";

        Assertions.assertEquals(false, Main.checkForFirstChar(enteredEmail));
    }

    @Test
    @DisplayName("Test that valid email returns true when checked for first char")
    public void testCheckForFirstChar2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForFirstChar(enteredEmail));
    }

    @Test
    @DisplayName("Test that empty space in the email returns false")
    public void testCheckForEmptySpace1() {
        String enteredEmail = "captain @pirate.com";

        Assertions.assertEquals(false, Main.checkForEmptySpace(enteredEmail));
    }

    @Test
    @DisplayName("Test that valid email checked for empty space returns true")
    public void testCheckForEmptySpace2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForEmptySpace(enteredEmail));
    }

    @Test
    @DisplayName("Test that email with more than one @-signs returns false")
    public void testCheckForMoreThanOneAtSign1() {
        String enteredEmail = "captain@boss@pirate.com";

        Assertions.assertEquals(false, Main.checkForMoreThanOneAtSign(enteredEmail));
    }

    @Test
    @DisplayName("Test that email with one @-signs returns true")
    public void testCheckForMoreThanOneAtSign2() {
        String enteredEmail = "captain@pirate.com";

        Assertions.assertEquals(true, Main.checkForMoreThanOneAtSign(enteredEmail));
    }

}
