package com.koszalka.crud.bo;

import com.koszalka.crud.constants.AppConstants;
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

    @Autowired
    public ClientBO(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<ClientEntity> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public ClientEntity findClientByName(String name) {
        return clientRepository.findClientByName(name);
    }

    public String saveOne(ClientEntity entity) {
        clientRepository.save(entity);
        return AppConstants.SAVED.getValue();
    }

}
