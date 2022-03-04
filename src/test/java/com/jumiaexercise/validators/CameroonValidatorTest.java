package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import com.jumiaexercise.customer.CustomerDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CameroonValidatorTest {

    private CameroonValidator cameroonValidator;
    private String phoneNumber;

    @BeforeEach
    void setUp() {
        cameroonValidator = new CameroonValidator();
    }

    @Test
    void getCountry() {
        //given
        String country = cameroonValidator.getCountry();

        //then
        assertThat(country).isEqualTo("Cameroon");
    }

    @Test
    void getCountryPrefix() {
        //given
        String countryPrefix = cameroonValidator.getCountryPrefix();

        //then
        assertThat(countryPrefix).isEqualTo("(237)");
    }

    @Test
    void getCountryCode() {
        //given
        String countryCode = cameroonValidator.getCountryCode();

        //then
        assertThat(countryCode).isEqualTo("+237");
    }

    @Test
    void validateNumberValid() {
        //given
        phoneNumber = "(237) 697151594";
        boolean valid = cameroonValidator.validateNumber(phoneNumber);

        //then
        assertThat(valid).isTrue();
    }

    @Test
    void validateNumberInvalid() {
        phoneNumber = "(237) 6A0311634";
        boolean invalid = cameroonValidator.validateNumber(phoneNumber);

        //then
        assertThat(invalid).isFalse();
    }

    @Test
    void validateAndUpdateCustomer(){
        //given
        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(237) 6A0311634",
                null,
                null,
                null,
                null
        );


        cameroonValidator.validateAndUpdateCustomer(customer);

        assertThat(customer.getCountry()).isNotNull();
        assertThat(customer.getCountryPrefix()).isNotNull();
        assertThat(customer.getCountryCode()).isNotNull();
        assertThat(customer.getState()).isNotNull();

    }
}