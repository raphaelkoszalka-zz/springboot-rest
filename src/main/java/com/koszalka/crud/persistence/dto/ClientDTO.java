package com.koszalka.crud.persistence.dto;

import com.koszalka.crud.persistence.entities.CityEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    private String name;
    private String gender;
    private CityEntity city;
    private String birthdate;
    private Long id;

    public ClientDTO(String name, String gender, CityEntity city, String birthdate, Long id) {
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.birthdate = birthdate;
        this.id = id;
    }

}
