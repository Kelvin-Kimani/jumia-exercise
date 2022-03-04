package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import com.jumiaexercise.customer.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MoroccoValidator {

    private final CustomerDetailsService customerDetailsService;
    private final Pattern pattern;

    private final static String MOROCCO_VALIDATOR = "\\(212\\) ?[5-9]\\d{8}$";
    public final static String MOROCCO_PREFIX = "(212)";
    public final static String MOROCCO_CODE = "+212";

    public MoroccoValidator() {
        pattern = Pattern.compile(MOROCCO_VALIDATOR);
        customerDetailsService = new CustomerDetailsService();
    }

    public String getCountry(){
        return "Morocco";
    }

    public String getCountryPrefix(){
        return MOROCCO_PREFIX;
    }

    public String getCountryCode(){
        return MOROCCO_CODE;
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
