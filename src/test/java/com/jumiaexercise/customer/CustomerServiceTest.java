package com.jumiaexercise.customer;

import com.jumiaexercise.validators.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository repository;
    private CustomerService customerService;
    private final String validity = "valid";

    @BeforeEach
    void setUp(){
        customerService = new CustomerService(
                repository,
                new CameroonValidator(),
                new EthiopiaValidator(),
                new MoroccoValidator(),
                new MozambiqueValidator(),
                new UgandaValidator());

    }

    @Test
    void getAllCustomers() {
        //given
        List<Customer> allCustomers = customerService.getAllCustomers();

        //then
        verify(repository).findAll();

        assertThat(allCustomers).isNotNull();
    }

    @Test
    void getCustomersWithCountry() {
        //given
        String countryPrefix = "(212)";
        List<Customer> customersWithCountry = customerService.getCustomersWithCountry(countryPrefix);

        //then
        verify(repository).findAllByPhoneStartsWith(countryPrefix);

        assertThat(customersWithCountry).isNotNull();
        assertThat(customerService.getAllCustomers()).isNotSameAs(customersWithCountry);

    }

    @Test
    void getCustomersWithValidityPhoneNumbers() {
        //given
        List<Customer> customersWithValidityPhoneNumbers = customerService.getCustomersWithValidityPhoneNumbers(validity);

        //then
        verify(repository).findAll();

        assertThat(customersWithValidityPhoneNumbers).isNotNull();
        assertThat(customerService.getAllCustomers()).isNotSameAs(customersWithValidityPhoneNumbers);
    }

    @Test
    void getCustomersByCountryAndValidity() {

        //given
        String countryPrefix="(212)";
        List<Customer> customersByCountryAndValidity = customerService.getCustomersByCountryAndValidity(countryPrefix, validity);

        //then
        verify(repository).findAll();

        assertThat(customersByCountryAndValidity).isNotNull();
        assertThat(customerService.getAllCustomers()).isNotSameAs(customersByCountryAndValidity);

    }
}