package ru.innopolis.utils.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiscreteValidatorPasswordTest {
    @Test
    public void validate() throws Exception {

        DiscreteValidatorPassword discreteValidatorPassword = new DiscreteValidatorPassword("1234567890", "1234567890");
        assertTrue(discreteValidatorPassword.validate());

        DiscreteValidatorPassword discreteValidatorPassword1 = new DiscreteValidatorPassword(null, null);
        assertFalse(discreteValidatorPassword1.validate());

        DiscreteValidatorPassword discreteValidatorPassword2 = new DiscreteValidatorPassword("1234567890", "0987654321");
        assertFalse(discreteValidatorPassword2.validate());

        DiscreteValidatorPassword discreteValidatorPassword3 = new DiscreteValidatorPassword("", "");
        assertFalse(discreteValidatorPassword3.validate());

        DiscreteValidatorPassword discreteValidatorPassword4 = new DiscreteValidatorPassword("1234567890", "");
        assertFalse(discreteValidatorPassword4.validate());

        DiscreteValidatorPassword discreteValidatorPassword5 = new DiscreteValidatorPassword("", "123312");
        assertFalse(discreteValidatorPassword5.validate());

    }

}