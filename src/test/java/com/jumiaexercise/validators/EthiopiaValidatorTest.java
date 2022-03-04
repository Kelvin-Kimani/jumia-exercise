package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import com.jumiaexercise.customer.CustomerDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class EthiopiaValidatorTest {

    private EthiopiaValidator ethiopiaValidator;
    private String phoneNumber;

    @BeforeEach
    void setUp() {
        ethiopiaValidator = new EthiopiaValidator();
    }

    @Test
    void getCountry() {
        //given
        String country = ethiopiaValidator.getCountry();

        //then
        assertThat(country).isEqualTo("Ethiopia");
    }

    @Test
    void getCountryPrefix() {

        //given
        String countryPrefix = ethiopiaValidator.getCountryPrefix();

        //then
        assertThat(countryPrefix).isEqualTo("(251)");
    }

    @Test
    void getCountryCode() {

        //given
        String countryCode = ethiopiaValidator.getCountryCode();

        //then
        assertThat(countryCode).isEqualTo("+251");

    }

    @Test
    void validateNumberValid() {
        //given
        phoneNumber = "(251) 914701723";
        boolean valid = ethiopiaValidator.validateNumber(phoneNumber);

        //then
        assertThat(valid).isTrue();
    }


    @Test
    void validateNumberInvalid() {
        //given
        phoneNumber = "(251) R914701723";
        boolean invalid = ethiopiaValidator.validateNumber(phoneNumber);

        //then
        assertThat(invalid).isFalse();
    }


    @Test
    void validateAndUpdateCustomer(){
        //given
        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(251) R914701723",
                null,
                null,
                null,
                null
        );


        ethiopiaValidator.validateAndUpdateCustomer(customer);

        assertThat(customer.getCountry()).isNotNull();
        assertThat(customer.getCountryPrefix()).isNotNull();
        assertThat(customer.getCountryCode()).isNotNull();
        assertThat(customer.getState()).isNotNull();

    }
}