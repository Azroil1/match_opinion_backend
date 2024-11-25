package ru.amirmanyanov.matchopinion.mapping;

import ru.amirmanyanov.matchopinion.models.dto.CountryDto;
import ru.amirmanyanov.matchopinion.models.entity.Country;

public class CountryMappers {
    public static CountryDto toDto(Country country) {
        if(country == null || country.getCountry() == null) return null;
        try{
            return CountryDto.valueOf(country.getCountry().toUpperCase());
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException("Unknown genre" + country.getCountry());
        }
    }
}
