package com.jumiaexercise.country;

import com.jumiaexercise.validators.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    private CountryService countryService;

    @BeforeEach
    void setUp() {
        countryService = new CountryService
                (
                        new CameroonValidator(),
                        new EthiopiaValidator(),
                        new MoroccoValidator(),
                        new MozambiqueValidator(),
                        new UgandaValidator()
                );
    }

    @Test
    void getCountries() {
        //given
        List<Country> countries = countryService.getCountries();

        //then
        assertThat(countries).isNotNull();
        assertThat(countries.size()).isEqualTo(5);
    }
}