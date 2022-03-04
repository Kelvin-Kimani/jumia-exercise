package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import com.jumiaexercise.customer.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EthiopiaValidator {

    private final CustomerDetailsService customerDetailsService;
    private final Pattern pattern;

    private final static String ETHIOPIA_VALIDATOR = "\\(251\\) ?[1-59]\\d{8}$";
    public final static String ETHIOPIA_PREFIX = "(251)";
    public final static String ETHIOPIA_CODE = "+251";

    public EthiopiaValidator() {
        pattern = Pattern.compile(ETHIOPIA_VALIDATOR);
        customerDetailsService = new CustomerDetailsService();
    }

    public String getCountry(){
        return "Ethiopia";
    }

    public String getCountryPrefix(){
        return ETHIOPIA_PREFIX;
    }

    public String getCountryCode(){
        return ETHIOPIA_CODE;
    }

    public boolean validateNumber(final String phone){
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public void validateAndUpdateCustomer(Customer customer) {
        customerDetailsService.updateCustomer(customer,
                getCountry(),
                getCountryCode(),
                getCountryPrefix(),
                validateNumber(customer.getPhone()));
    }
}
