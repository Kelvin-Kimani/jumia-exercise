package com.jumiaexercise.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/welcome")
    public String welcomePage(){
        return "The app is up and running";
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/country")
    public List<Customer> getCustomersByCountry(@RequestParam(name = "countryPrefix") String countryPrefix){
        return customerService.getCustomersWithCountry(countryPrefix);
    }


    @GetMapping("/customers/validity")
    public ResponseEntity< List<Customer>> getCustomersWithValidity(@RequestParam(name = "validity") String validity){
        List<Customer> customersWithValidityPhoneNumbers = customerService.getCustomersWithValidityPhoneNumbers(validity);
        return ResponseEntity.ok(customersWithValidityPhoneNumbers);
    }


    @GetMapping("/customers/country-validity")
    public ResponseEntity<List<Customer>> getCustomersByCountryAndValidity(@RequestParam String countryPrefix, @RequestParam String validity){
        List<Customer> customersByCountryAndValidity = customerService.getCustomersByCountryAndValidity(countryPrefix, validity);
        return ResponseEntity.ok(customersByCountryAndValidity);
    }

    //Pagination
    @GetMapping("/customers/paginated/{offset}/{pageSize}")
    public Page<Customer> getPaginatedCustomers(@PathVariable int offset, @PathVariable int pageSize){
        return customerService.getCustomersWithPagination(offset, pageSize);
    }
}
