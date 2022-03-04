package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MozambiqueValidatorTest {

    private MozambiqueValidator mozambiqueValidator;
    private String phoneNumber;


    @BeforeEach
    void setUp() {
        mozambiqueValidator = new MozambiqueValidator();
    }

    @Test
    void getCountry() {
        //given
        String country = mozambiqueValidator.getCountry();

        //then
        assertThat(country).isEqualTo("Mozambique");
    }

    @Test
    void getCountryPrefix() {
        //given
        String countryPrefix = mozambiqueValidator.getCountryPrefix();

        //then
        assertThat(countryPrefix).isEqualTo("(258)");

    }

    @Test
    void getCountryCode() {
        //given
        String countryCode = mozambiqueValidator.getCountryCode();

        //then
        assertThat(countryCode).isEqualTo("+258");
    }

    @Test
    void validateNumberValid() {
        phoneNumber = "(258) 847651504";
        boolean valid = mozambiqueValidator.validateNumber(phoneNumber);

        assertThat(valid).isTrue();
    }


    @Test
    void validateNumberInvalid() {
        phoneNumber = "(258) Z847651504";
        boolean valid = mozambiqueValidator.validateNumber(phoneNumber);

        assertThat(valid).isFalse();
    }


    @Test
    void validateAndUpdateCustomer(){
        //given
        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(258) Z847651504",
                null,
                null,
                null,
                null
        );


        mozambiqueValidator.validateAndUpdateCustomer(customer);

        assertThat(customer.getCountry()).isNotNull();
        assertThat(customer.getCountryPrefix()).isNotNull();
        assertThat(customer.getCountryCode()).isNotNull();
        assertThat(customer.getState()).isNotNull();

    }
}