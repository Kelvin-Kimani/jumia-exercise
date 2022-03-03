package com.jumiaexercise.validators;

import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class MozambiquePhoneValidator {
    private Pattern pattern;
    private Matcher matcher;

    private final static String MOZAMBIQUE_VALIDATOR = "\\(258\\) ?[28]\\d{7,8}$";
    public final static String MOZAMBIQUE_PREFIX = "(258)";
    public final static String MOZAMBIQUE_CODE = "+258";

    public MozambiquePhoneValidator() {
        pattern = Pattern.compile(MOZAMBIQUE_VALIDATOR);
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

    public boolean validate(final String phone){
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
