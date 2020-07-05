package com.koszalka.crud.persistence.repositories;

import com.koszalka.crud.persistence.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    @Query("SELECT COUNT(city.id)"
            + " FROM CityEntity as city"
            + " WHERE city.name = :name"
            + " AND city.state = :state")
    Long checkForCityExistence(@Param("name") String name, @Param("state") String state);

    @Query("SELECT city FROM CityEntity as city WHERE city.name = :name")
    CityEntity getCityByName(@Param("name") String name);

    @Query("SELECT city FROM CityEntity as city WHERE city.state = :state")
    List<CityEntity> getCitiesByState(@Param("state") String state);

}
