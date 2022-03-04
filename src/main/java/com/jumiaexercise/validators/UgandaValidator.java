package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import com.jumiaexercise.customer.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UgandaValidator {

    private final CustomerDetailsService customerDetailsService;
    private final Pattern pattern;

    private final static String UGANDA_VALIDATOR = "\\(256\\) ?\\d{9}$";
    public final static String UGANDA_PREFIX = "(256)";
    public final static String UGANDA_CODE = "+256";

    public UgandaValidator() {
        pattern = Pattern.compile(UGANDA_VALIDATOR);
        customerDetailsService = new CustomerDetailsService();
    }

    public String getCountry(){
        return "Uganda";
    }

    public String getCountryPrefix(){ return UGANDA_PREFIX; }

    public String getCountryCode(){
        return UGANDA_CODE;
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
