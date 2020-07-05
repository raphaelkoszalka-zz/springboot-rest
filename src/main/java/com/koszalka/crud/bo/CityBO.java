package com.koszalka.crud.bo;

import com.koszalka.crud.constants.AppConstants;
import com.koszalka.crud.persistence.dto.CityDTO;
import com.koszalka.crud.persistence.entities.CityEntity;
import com.koszalka.crud.utils.UrlShortenerUtil;
import com.koszalka.crud.utils.UrlShortenerValidationUtil;
import com.koszalka.crud.persistence.repositories.CityRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityBO {

    private final CityRepository cityRepository;

    @Autowired
    public CityBO(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityEntity getCityByName(String city) {
        return cityRepository.getCityByName(city);
    }

    public List<CityEntity> getCitiesByState(String state) {
        return cityRepository.getCitiesByState(state);
    }

    public String saveOne(CityEntity entity) {
        if (checkForCityExistence(entity.getName(), entity.getState()) > 0) {
            return AppConstants.CONFLICT.getValue();
        }
        cityRepository.save(entity);
        return AppConstants.SAVED.getValue();
    }

    private Long checkForCityExistence(String city, String state) {
        return cityRepository.checkForCityExistence(city, state);
    }

}
