package com.jumiaexercise.country;

import com.jumiaexercise.validators.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CountryService(CameroonPhoneValidator cameroonPhoneValidator,
                             EthiopiaPhoneValidator ethiopiaPhoneValidator,
                             MoroccoPhoneValidator moroccoPhoneValidator,
                             MozambiquePhoneValidator mozambiquePhoneValidator,
                             UgandaPhoneValidator ugandaPhoneValidator) {

    public List<Country> getCountries() {
        return List.of(
                new Country(cameroonPhoneValidator.getCountry(), cameroonPhoneValidator.getCountryCode(), cameroonPhoneValidator.getCountryPrefix()),
                new Country(ethiopiaPhoneValidator.getCountry(), ethiopiaPhoneValidator.getCountryCode(), ethiopiaPhoneValidator.getCountryPrefix()),
                new Country(moroccoPhoneValidator.getCountry(), moroccoPhoneValidator.getCountryCode(), moroccoPhoneValidator.getCountryPrefix()),
                new Country(mozambiquePhoneValidator.getCountry(), mozambiquePhoneValidator.getCountryCode(), mozambiquePhoneValidator.getCountryPrefix()),
                new Country(ugandaPhoneValidator.getCountry(), ugandaPhoneValidator.getCountryCode(), ugandaPhoneValidator.getCountryPrefix())
        );
    }
}
