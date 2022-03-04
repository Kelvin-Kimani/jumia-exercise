package com.jumiaexercise.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDetailsServiceTest {

    private CustomerDetailsService customerDetailsService;

    @BeforeEach
    void setUp() {
        customerDetailsService = new CustomerDetailsService();
    }

    @Test
    public void testUpdateCustomerValidPhone(){
        //given
        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(212) 790838747",
                null,
                null,
                null,
                null
        );

        //when
        customerDetailsService.updateCustomer(customer, "Cameroon", "(237)", "+237", true);

        //then
        assertThat(customer.getCountry()).isNotNull();
        assertThat(customer.getCountryCode()).isNotNull();
        assertThat(customer.getCountryPrefix()).isNotNull();
        assertThat(customer.getState()).isNotNull();

        assertThat(customer.getState()).isEqualTo("Valid");
    }



    @Test
    public void testUpdateCustomerInvalidPhone(){
        //given
        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(212) 790838747",
                null,
                null,
                null,
                null
        );

        //when
        customerDetailsService.updateCustomer(customer, "Cameroon", "(237)", "+237", false);

        //then
        assertThat(customer.getCountry()).isNotNull();
        assertThat(customer.getCountryCode()).isNotNull();
        assertThat(customer.getCountryPrefix()).isNotNull();
        assertThat(customer.getState()).isNotNull();

        assertThat(customer.getState()).isEqualTo("Invalid");
    }
}