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
                              CameroonValidator cameroonValidator,
                              EthiopiaValidator ethiopiaValidator,
                              MoroccoValidator moroccoValidator,
                              MozambiqueValidator mozambiqueValidator,
                              UgandaValidator ugandaValidator) {

    @Autowired
    public CustomerService {
    }

    /* Validator
     *   - Used in stream to map data to our transient fields.
     *   - Uses country prefix, derived from the phone number, in a switch case to select the country validator to use.
     *  */
    Customer validateCustomer(Customer customer) {

        switch (customer.getPhone().substring(0, 5)) {
            case CameroonValidator.CAMEROON_PREFIX -> cameroonValidator.validateAndUpdateCustomer(customer);
            case EthiopiaValidator.ETHIOPIA_PREFIX -> ethiopiaValidator.validateAndUpdateCustomer(customer);
            case MoroccoValidator.MOROCCO_PREFIX -> moroccoValidator.validateAndUpdateCustomer(customer);
            case MozambiqueValidator.MOZAMBIQUE_PREFIX -> mozambiqueValidator.validateAndUpdateCustomer(customer);
            case UgandaValidator.UGANDA_PREFIX -> ugandaValidator.validateAndUpdateCustomer(customer);
        }

        return customer;
    }


    /* READ */
    /* Returns all customers from the database */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::validateCustomer)
                .collect(Collectors.toList());
    }

    /* Returns customers by country
    *  - Takes in countryPrefix as a parameter
    *  */
    public List<Customer> getCustomersWithCountry(String countryPrefix) {
        return customerRepository.findAllByPhoneStartsWith(countryPrefix)
                .stream()
                .map(this::validateCustomer)
                .collect(Collectors.toList());
    }

    /* Returns customers according to the validity of their phone numbers
    * - Takes in a state of either 'valid' or 'invalid' as a parameter.
    * */
    public List<Customer> getCustomersWithValidityPhoneNumbers(String validity) {
        return getAllCustomers()
                .stream()
                .filter(customer -> customer.getState().toLowerCase().equals(validity))
                .collect(Collectors.toList());
    }

    /* Returns customers by country and validity of their phone numbers
    * - Takes in both countryPrefix and validity state as parameters
    * */
    public List<Customer> getCustomersByCountryAndValidity(String countryPrefix, String validity) {
        return getAllCustomers()
                .stream()
                .filter(customer -> customer.getCountryPrefix().equals(countryPrefix))
                .filter(customer -> customer.getState().toLowerCase().equals(validity))
                .collect(Collectors.toList());
    }


    /* Returns all users with pagination */
    public Page<Customer> getCustomersWithPagination(int offset, int pageSize) {
        List<Customer> paginatedCustomers = customerRepository.findAll(PageRequest.of(offset, pageSize))
                .stream()
                .map(this::validateCustomer)
                .collect(Collectors.toList());

        return new PageImpl<>(paginatedCustomers);
    }

}
