package com.koszalka.crud.rest.controllers;

import com.koszalka.crud.bo.CityBO;
import com.koszalka.crud.bo.ClientBO;
import com.koszalka.crud.constants.AppConstants;
import com.koszalka.crud.persistence.dto.CityDTO;
import com.koszalka.crud.persistence.dto.ClientDTO;
import com.koszalka.crud.persistence.entities.CityEntity;
import com.koszalka.crud.persistence.entities.ClientEntity;
import com.koszalka.crud.persistence.repositories.CityRepository;
import com.koszalka.crud.rest.api.CityAPI;

import javax.servlet.http.HttpServletResponse;


import java.util.List;

import com.koszalka.crud.rest.api.ClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController implements ClientAPI {

    private ClientBO clientBO;

    @Autowired
    public ClientController(ClientBO clientBO) {
        this.clientBO = clientBO;
    }

    @Override
    public ResponseEntity<ClientDTO> postNewClient(ClientDTO data) {
        ClientEntity entity = new ClientEntity();

        entity.setName(data.getName());
        entity.setBirthdate(data.getBirthdate());
        entity.setGender(data.getGender());
        entity.setCity(data.getCity());

        ClientDTO response = new ClientDTO(entity.getName(), entity.getBirthdate(), entity.getGender(), entity.getCity());

        return new ResponseEntity<ClientDTO>(response, HttpStatus.CREATED);
    }

}
