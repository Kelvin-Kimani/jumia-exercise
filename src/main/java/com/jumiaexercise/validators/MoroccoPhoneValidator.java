package com.jumiaexercise.validators;

import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class MoroccoPhoneValidator {
    private Pattern pattern;
    private Matcher matcher;

    private final static String MOROCCO_VALIDATOR = "\\(212\\) ?[5-9]\\d{8}$";
    public final static String MOROCCO_PREFIX = "(212)";
    public final static String MOROCCO_CODE = "+212";

    public MoroccoPhoneValidator() {
        pattern = Pattern.compile(MOROCCO_VALIDATOR);
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

    public boolean validate(final String phone){
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}
