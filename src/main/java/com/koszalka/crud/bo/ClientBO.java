package com.koszalka.crud.bo;

import com.koszalka.crud.constants.AppConstants;
import com.koszalka.crud.persistence.dto.ClientDTO;
import com.koszalka.crud.persistence.entities.CityEntity;
import com.koszalka.crud.persistence.entities.ClientEntity;
import com.koszalka.crud.persistence.repositories.ClientRepository;
import com.koszalka.crud.persistence.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientBO {

    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;

    @Autowired
    public ClientBO(ClientRepository clientRepository, CityRepository cityRepository) {
        this.clientRepository = clientRepository;
        this.cityRepository = cityRepository;
    }

    public ClientEntity findClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    public void deleteClientById(Long id) {
        clientRepository.delete(findClientById(id));
    }

    public ClientEntity findClientByName(String name) {
        return clientRepository.findClientByName(name);
    }

    public String saveOne(ClientEntity entity) {
        if (checkForCityExistence(entity.getCity().getName(), entity.getCity().getState()) > 0) {
            return AppConstants.BAD_REQUEST.getValue();
        }
        clientRepository.save(entity);
        return AppConstants.SAVED.getValue();
    }

    public void updateClientName(String name, Long id) {
        clientRepository.updateClientName(name, id);
    }

    private Long checkForCityExistence(String city, String state) {
        return cityRepository.checkForCityExistence(city, state);
    }

}
