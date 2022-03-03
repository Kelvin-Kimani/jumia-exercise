package com.jumiaexercise.validators;

import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class UgandaPhoneValidator {

    private Pattern pattern;
    private Matcher matcher;

    private final static String UGANDA_VALIDATOR = "\\(256\\) ?\\d{9}$";
    public final static String UGANDA_PREFIX = "(256)";
    public final static String UGANDA_CODE = "+256";

    public UgandaPhoneValidator() {
        pattern = Pattern.compile(UGANDA_VALIDATOR);
    }

    public String getCountry(){
        return "Uganda";
    }

    public String getCountryPrefix(){
        return UGANDA_PREFIX;
    }

    public String getCountryCode(){
        return UGANDA_CODE;
    }

    public boolean validate(final String phone){
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}
