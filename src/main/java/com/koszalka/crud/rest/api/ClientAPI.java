package com.koszalka.crud.rest.api;

import com.koszalka.crud.persistence.dto.CityDTO;
import javax.servlet.http.HttpServletResponse;


import java.util.List;
import java.util.Optional;

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


    @RequestMapping(path = "/name/{clientName}", method = RequestMethod.GET)
    ResponseEntity<ClientDTO> getClientByName(HttpServletResponse response, @PathVariable("clientName") String clientName);

    @RequestMapping(path = "/id/{clientId}", method = RequestMethod.GET)
    ResponseEntity<ClientEntity> getClientById(HttpServletResponse response, @PathVariable("clientId") Long clientId);

    @RequestMapping(path = "/id/{clientId}", method = RequestMethod.DELETE)
    ResponseEntity<ClientEntity> deleteClientById(HttpServletResponse response, @PathVariable("clientId") Long clientId);

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    ResponseEntity<ClientDTO> postNewClient(@RequestBody ClientDTO data);

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    ResponseEntity<ClientDTO> updateClientName(@RequestBody ClientDTO data);

}

