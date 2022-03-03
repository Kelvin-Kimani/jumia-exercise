package com.jumiaexercise.customer;

import com.jumiaexercise.validators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              CameroonPhoneValidator cameroonPhoneValidator,
                              EthiopiaPhoneValidator ethiopiaPhoneValidator,
                              MoroccoPhoneValidator moroccoPhoneValidator,
                              MozambiquePhoneValidator mozambiquePhoneValidator,
                              UgandaPhoneValidator ugandaPhoneValidator) {

    @Autowired
    public CustomerService {
    }

    /* Validator
     *   - Used in stream to map data to our transient fields.
     *   - Uses phone number prefix in a switch case to select the country validator to use.
     *  */
    private Customer validateCustomer(Customer customer) {

        switch (customer.getPhone().substring(0, 5)) {

            case CameroonPhoneValidator.CAMEROON_PREFIX:
                //Implementation
                customer.setCountry(cameroonPhoneValidator.getCountry());
                customer.setCountryCode(cameroonPhoneValidator.getCountryCode());
                customer.setCountryPrefix(cameroonPhoneValidator.getCountryPrefix());

                //check phone number validity
                if (cameroonPhoneValidator.validate(customer.getPhone())) {
                    customer.setState("Valid");
                } else customer.setState("Invalid");

                break;


            case EthiopiaPhoneValidator.ETHIOPIA_PREFIX:
                //Implementation
                customer.setCountry(ethiopiaPhoneValidator.getCountry());
                customer.setCountryCode(ethiopiaPhoneValidator.getCountryCode());
                customer.setCountryPrefix(ethiopiaPhoneValidator.getCountryPrefix());

                //check phone number validity
                if (ethiopiaPhoneValidator.validate(customer.getPhone())) {
                    customer.setState("Valid");
                } else customer.setState("Invalid");

                break;


            case MoroccoPhoneValidator.MOROCCO_PREFIX:

                //Implementation
                customer.setCountry(moroccoPhoneValidator.getCountry());
                customer.setCountryCode(moroccoPhoneValidator.getCountryCode());
                customer.setCountryPrefix(moroccoPhoneValidator.getCountryPrefix());

                //check phone number validity
                if (moroccoPhoneValidator.validate(customer.getPhone())) {
                    customer.setState("Valid");
                } else customer.setState("Invalid");

                break;


            case MozambiquePhoneValidator.MOZAMBIQUE_PREFIX:

                //Implementation
                customer.setCountry(mozambiquePhoneValidator.getCountry());
                customer.setCountryCode(mozambiquePhoneValidator.getCountryCode());
                customer.setCountryPrefix(mozambiquePhoneValidator.getCountryPrefix());

                //check phone number validity
                if (mozambiquePhoneValidator.validate(customer.getPhone())) {
                    customer.setState("Valid");
                } else customer.setState("Invalid");

                break;


            case UgandaPhoneValidator.UGANDA_PREFIX:

                //Implementation
                customer.setCountry(ugandaPhoneValidator.getCountry());
                customer.setCountryCode(ugandaPhoneValidator.getCountryCode());
                customer.setCountryPrefix(ugandaPhoneValidator.getCountryPrefix());

                //check phone number validity
                if (ugandaPhoneValidator.validate(customer.getPhone())) {
                    customer.setState("Valid");
                } else customer.setState("Invalid");

                break;

        }

        return customer;
    }

    /* READ */

    /* Gets all customers from the database */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::validateCustomer)
                .collect(Collectors.toList());
    }

    /* Gets customers by country */
    public List<Customer> getCustomersWithCountry(String countryPrefix) {
        return customerRepository.findAllByPhoneStartsWith(countryPrefix)
                .stream()
                .map(this::validateCustomer)
                .collect(Collectors.toList());
    }

    /* Gets customers according to the validity of their phone numbers */
    public List<Customer> getCustomersWithValidityPhoneNumbers(String validity) {
        return getAllCustomers()
                .stream()
                .filter(customer -> customer.getState().toLowerCase().equals(validity))
                .collect(Collectors.toList());
    }

    /* Gets customers by country and validity of their phone numbers */
    public List<Customer> getCustomersByCountryAndValidity(String countryPrefix, String validity) {
        return getAllCustomers()
                .stream()
                .filter(customer -> customer.getCountryPrefix().equals(countryPrefix))
                .filter(customer -> customer.getState().toLowerCase().equals(validity))
                .collect(Collectors.toList());
    }


    /* Gets all users with pagination */
    public Page<Customer> getCustomersWithPagination(int offset, int pageSize) {
        List<Customer> paginatedCustomers = customerRepository.findAll(PageRequest.of(offset, pageSize))
                .stream()
                .map(this::validateCustomer)
                .collect(Collectors.toList());

        return new PageImpl<>(paginatedCustomers);
    }

}
