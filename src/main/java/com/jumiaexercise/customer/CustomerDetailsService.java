package com.jumiaexercise.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService {

    public void updateCustomer(Customer customer,
                                          String country,
                                          String countryCode,
                                          String countryPrefix,
                                          boolean validNumber){
        customer.setCountry(country);
        customer.setCountryCode(countryCode);
        customer.setCountryPrefix(countryPrefix);

        if(validNumber){
            customer.setState("Valid");
        } else customer.setState("Invalid");

    }
}

