package com.koszalka.crud.persistence.dto;

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
    private String city;
    private String birthdate;

    public ClientDTO(String name, String gender, String city, String birthdate) {
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.birthdate = birthdate;
    }

}
