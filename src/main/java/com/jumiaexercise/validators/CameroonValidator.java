package com.jumiaexercise.validators;

import com.jumiaexercise.customer.Customer;
import com.jumiaexercise.customer.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CameroonValidator{

    private final CustomerDetailsService customerDetailsService;
    private final Pattern pattern;

    private final static String CAMEROON_VALIDATOR = "\\(237\\) ?[2368]\\d{7,8}$";
    public final static String CAMEROON_PREFIX = "(237)";
    public final static String CAMEROON_CODE = "+237";

    public CameroonValidator() {
        pattern = Pattern.compile(CAMEROON_VALIDATOR);
        customerDetailsService = new CustomerDetailsService();
    }

    public String getCountry(){
        return "Cameroon";
    }

    public String getCountryPrefix(){
        return CAMEROON_PREFIX;
    }

    public String getCountryCode(){
        return CAMEROON_CODE;
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
