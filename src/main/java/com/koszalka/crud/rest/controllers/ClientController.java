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
import java.util.Optional;

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
    public ResponseEntity<ClientEntity> getClientByName(HttpServletResponse response, String clientName) {
        ClientEntity entity = clientBO.findClientByName(clientName);
        ClientDTO res = new ClientDTO();

        res.setBirthdate(entity.getBirthdate());
        res.setCity(entity.getCity());
        res.setGender(entity.getGender());
        res.setName(entity.getName());

        return new ResponseEntity<ClientEntity>(entity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<ClientEntity>> getClientById(HttpServletResponse response, Long clientId) {
        Optional<ClientEntity> entity = clientBO.findClientById(clientId);

        return new ResponseEntity<Optional<ClientEntity>>(entity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDTO> postNewClient(ClientDTO data) {
        ClientEntity entity = new ClientEntity();

        entity.setName(data.getName());
        entity.setBirthdate(data.getBirthdate());
        entity.setGender(data.getGender());
        entity.setCity(data.getCity());

        clientBO.saveOne(entity);

        ClientDTO response = new ClientDTO(entity.getName(), entity.getBirthdate(), entity.getGender(), entity.getCity());
        return new ResponseEntity<ClientDTO>(response, HttpStatus.CREATED);
    }

}
