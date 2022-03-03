package com.jumiaexercise.validators;

import org.aspectj.apache.bcel.generic.Type;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class CameroonPhoneValidator{
    private Pattern pattern;
    private Matcher matcher;

    private final static String CAMEROON_VALIDATOR = "\\(237\\) ?[2368]\\d{7,8}$";
    public final static String CAMEROON_PREFIX = "(237)";
    public final static String CAMEROON_CODE = "+237";

    public CameroonPhoneValidator() {
        pattern = Pattern.compile(CAMEROON_VALIDATOR);
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

    public boolean validate(final String phone){
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
