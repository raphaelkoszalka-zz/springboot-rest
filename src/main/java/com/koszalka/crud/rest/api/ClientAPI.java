package com.koszalka.crud.rest.api;

import com.koszalka.crud.persistence.dto.CityDTO;
import javax.servlet.http.HttpServletResponse;


import java.util.List;

import com.koszalka.crud.persistence.dto.ClientDTO;
import com.koszalka.crud.persistence.entities.CityEntity;
import com.koszalka.crud.persistence.entities.ClientEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(path = "/v1/client")
public interface ClientAPI {

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    ResponseEntity<ClientDTO> postNewClient(@RequestBody ClientDTO data);

}

