package com.koszalka.crud.rest.controllers;

import com.koszalka.crud.bo.CityBO;
import com.koszalka.crud.constants.AppConstants;
import com.koszalka.crud.persistence.dto.CityDTO;
import com.koszalka.crud.persistence.entities.CityEntity;
import com.koszalka.crud.persistence.repositories.CityRepository;
import com.koszalka.crud.rest.api.CityAPI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController implements CityAPI {

    private CityBO cityBO;

    @Autowired
    public CityController(CityBO cityBO) {
        this.cityBO = cityBO;
    }


    @Override
    public ResponseEntity<CityDTO> getCityByName(HttpServletResponse response, String cityName) {
        CityEntity entity = cityBO.getCityByName(cityName);

        CityDTO dto = new CityDTO();
        dto.setName(entity.getName());
        dto.setState(entity.getState());

        return new ResponseEntity<CityDTO>(dto, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<CityDTO> postNewCity(CityDTO data) {
        CityEntity entity = new CityEntity();

        entity.setName(data.getName());
        entity.setState(data.getState());

        CityDTO response = new CityDTO(entity.getName(), entity.getState());

        if (cityBO.saveOne(entity).equals(AppConstants.CONFLICT.getValue())) {
            return new ResponseEntity<CityDTO>(HttpStatus.CONFLICT); // malformed url
        }

        return new ResponseEntity<CityDTO>(response, HttpStatus.CREATED);
    }

}
