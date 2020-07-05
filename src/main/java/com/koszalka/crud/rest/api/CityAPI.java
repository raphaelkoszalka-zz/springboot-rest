package com.koszalka.crud.rest.api;

import com.koszalka.crud.persistence.dto.CityDTO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path = "/v1/city")
public interface CityAPI {

    @RequestMapping(path = "/search/{cityName}", method = RequestMethod.GET)
    ResponseEntity<CityDTO> getCityByName(HttpServletResponse response, @PathVariable("cityName") String cityName);

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    ResponseEntity<CityDTO> postNewCity(@RequestBody CityDTO data);

}

