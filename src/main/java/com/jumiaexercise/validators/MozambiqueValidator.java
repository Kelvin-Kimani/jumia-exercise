package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import com.jumiaexercise.customer.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MozambiqueValidator {

    private final CustomerDetailsService customerDetailsService;
    private final Pattern pattern;

    private final static String MOZAMBIQUE_VALIDATOR = "\\(258\\) ?[28]\\d{7,8}$";
    public final static String MOZAMBIQUE_PREFIX = "(258)";
    public final static String MOZAMBIQUE_CODE = "+258";

    public MozambiqueValidator() {
        pattern = Pattern.compile(MOZAMBIQUE_VALIDATOR);
        customerDetailsService = new CustomerDetailsService();
    }

    public String getCountry(){
        return "Mozambique";
    }

    public String getCountryPrefix(){
        return MOZAMBIQUE_PREFIX;
    }

    public String getCountryCode(){
        return MOZAMBIQUE_CODE;
    }

    public boolean validateNumber(final String phone){
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /* Updates the transient fields on the specific customer */
    public void validateAndUpdateCustomer(Customer customer) {
        customerDetailsService.updateCustomer(customer,
                getCountry(),
                getCountryCode(),
                getCountryPrefix(),
                validateNumber(customer.getPhone()));
    }
}
