package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UgandaValidatorTest {

    private UgandaValidator ugandaValidator;
    private String phoneNumber;

    @BeforeEach
    void setUp() {
        ugandaValidator = new UgandaValidator();
    }

    @Test
    void getCountry() {
        //given
        String country = ugandaValidator.getCountry();

        //then
        assertThat(country).isEqualTo("Uganda");
    }

    @Test
    void getCountryPrefix() {
        //given
        String countryPrefix = ugandaValidator.getCountryPrefix();

        //then
        assertThat(countryPrefix).isEqualTo("(256)");
    }

    @Test
    void getCountryCode() {
        //given
        String countryCode = ugandaValidator.getCountryCode();

        //then
        assertThat(countryCode).isEqualTo("+256");
    }

    @Test
    void validateNumberValid() {
        //given
        phoneNumber = "(256) 775069443";

        boolean valid = ugandaValidator.validateNumber(phoneNumber);

        //then
        assertThat(valid).isTrue();
    }

    @Test
    void validateNumberInvalid() {
        //given
        phoneNumber = "(256) E775069443";

        boolean valid = ugandaValidator.validateNumber(phoneNumber);

        //then
        assertThat(valid).isFalse();

    }

    @Test
    void validateAndUpdateCustomer(){
        //given
        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(256) 775069443",
                null,
                null,
                null,
                null
        );


        ugandaValidator.validateAndUpdateCustomer(customer);

        assertThat(customer.getCountry()).isNotNull();
        assertThat(customer.getCountryPrefix()).isNotNull();
        assertThat(customer.getCountryCode()).isNotNull();
        assertThat(customer.getState()).isNotNull();

    }
}