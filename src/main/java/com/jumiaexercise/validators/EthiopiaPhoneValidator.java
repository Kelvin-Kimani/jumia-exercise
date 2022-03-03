package com.jumiaexercise.validators;

import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class EthiopiaPhoneValidator {

    private Pattern pattern;
    private Matcher matcher;

    private final static String ETHIOPIA_VALIDATOR = "\\(251\\) ?[1-59]\\d{8}$";
    public final static String ETHIOPIA_PREFIX = "(251)";
    public final static String ETHIOPIA_CODE = "+251";

    public EthiopiaPhoneValidator() {
        pattern = Pattern.compile(ETHIOPIA_VALIDATOR);
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

    public boolean validate(final String phone){
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
