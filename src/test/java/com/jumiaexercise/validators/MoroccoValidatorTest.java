package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoroccoValidatorTest {

    private MoroccoValidator moroccoValidator;
    private String phoneNumber;

    @BeforeEach
    void setUp() {
        moroccoValidator = new MoroccoValidator();
    }

    @Test
    void getCountry() {
        //given
        String country = moroccoValidator.getCountry();

        //then
        assertThat(country).isEqualTo("Morocco");

    }

    @Test
    void getCountryPrefix() {

        //given
        String countryPrefix = moroccoValidator.getCountryPrefix();

        //then
        assertThat(countryPrefix).isEqualTo("(212)");
    }

    @Test
    void getCountryCode() {
        //given
        String countryCode = moroccoValidator.getCountryCode();

        //then
        assertThat(countryCode).isEqualTo("+212");

    }

    @Test
    void validateNumberValid() {
        phoneNumber = "(212) 698054317";
        boolean valid = moroccoValidator.validateNumber(phoneNumber);

        assertThat(valid).isTrue();
    }


    @Test
    void validateNumberInvalid() {
        phoneNumber = "(212) X698054317";
        boolean valid = moroccoValidator.validateNumber(phoneNumber);

        assertThat(valid).isFalse();
    }



    @Test
    void validateAndUpdateCustomer(){
        //given
        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(212) X698054317",
                null,
                null,
                null,
                null
        );


        moroccoValidator.validateAndUpdateCustomer(customer);

        assertThat(customer.getCountry()).isNotNull();
        assertThat(customer.getCountryPrefix()).isNotNull();
        assertThat(customer.getCountryCode()).isNotNull();
        assertThat(customer.getState()).isNotNull();

    }
}