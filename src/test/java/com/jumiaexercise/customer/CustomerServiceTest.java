package com.jumiaexercise.customer;

import com.jumiaexercise.validators.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository repository;

    private CameroonPhoneValidator cameroonPhoneValidator;
    private EthiopiaPhoneValidator ethiopiaPhoneValidator;
    private MoroccoPhoneValidator moroccoPhoneValidator;
    private MozambiquePhoneValidator mozambiquePhoneValidator;
    private UgandaPhoneValidator ugandaPhoneValidator;

    private CustomerService customerService;

    @BeforeEach
    void setUp(){
        customerService = new CustomerService(repository, cameroonPhoneValidator, ethiopiaPhoneValidator, moroccoPhoneValidator, mozambiquePhoneValidator,ugandaPhoneValidator);
    }
    @Test
    void getAllCustomers() {

        Customer customer = new Customer(
                1,
                "Kimani Kelvin",
                "(212) 790838747",
                "Morocco",
                "invalid",
                "+212",
                "(212)"
        );

        //given
        customerService.getAllCustomers();

        //then
        verify(repository).findAll();
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
        String validity = "valid";
        List<Customer> customersWithValidityPhoneNumbers = customerService.getCustomersWithValidityPhoneNumbers(validity);

        //then
        verify(repository).findAll();

        assertThat(customersWithValidityPhoneNumbers).isNotNull();
        assertThat(customerService.getAllCustomers()).isNotSameAs(customersWithValidityPhoneNumbers);
    }

    @Test
    @Disabled
    void getCustomersByCountryAndValidity() {
    }

    @Test
    @Disabled
    void getCustomersWithPagination() {
    }
}