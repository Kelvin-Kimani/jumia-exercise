package com.jumiaexercise.country;

import com.jumiaexercise.validators.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CountryService(CameroonValidator cameroonPhoneValidator,
                             EthiopiaValidator ethiopiaValidator,
                             MoroccoValidator moroccoValidator,
                             MozambiqueValidator mozambiqueValidator,
                             UgandaValidator ugandaValidator) {

    /* Retrieve the list of countries given */
    public List<Country> getCountries() {
        return List.of(
                new Country(cameroonPhoneValidator.getCountry(), cameroonPhoneValidator.getCountryCode(), cameroonPhoneValidator.getCountryPrefix()),
                new Country(ethiopiaValidator.getCountry(), ethiopiaValidator.getCountryCode(), ethiopiaValidator.getCountryPrefix()),
                new Country(moroccoValidator.getCountry(), moroccoValidator.getCountryCode(), moroccoValidator.getCountryPrefix()),
                new Country(mozambiqueValidator.getCountry(), mozambiqueValidator.getCountryCode(), mozambiqueValidator.getCountryPrefix()),
                new Country(ugandaValidator.getCountry(), ugandaValidator.getCountryCode(), ugandaValidator.getCountryPrefix())
        );
    }
}
