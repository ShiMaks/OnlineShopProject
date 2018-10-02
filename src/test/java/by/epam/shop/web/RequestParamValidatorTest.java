package by.epam.shop.web;

import org.junit.Test;

import static by.epam.shop.web.util.RequestParamValidator.validateLogin;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static org.junit.Assert.assertEquals;

public class RequestParamValidatorTest {

    @Test
    public void validatePositiveIntTest() throws Exception {
        String test = "11";
        assertEquals(true,validatePositiveInt(test));
    }

    @Test
    public void validateLoginTest() throws Exception {
        String invalidLogin = "Fat2#";
        assertEquals(false, validateLogin(invalidLogin));
    }
}
