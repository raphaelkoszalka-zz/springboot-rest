package com.koszalka.crud.persistence.repositories;

import com.koszalka.crud.persistence.entities.CityEntity;
import com.koszalka.crud.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT client FROM ClientEntity as client WHERE client.name = :name")
    ClientEntity findClientByName(@Param("name") String name);

    @Query("SELECT client FROM ClientEntity as client WHERE client.id = :id")
    ClientEntity findClientById(@Param("id") Long id);

}
