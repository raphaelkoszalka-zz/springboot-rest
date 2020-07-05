package com.koszalka.crud.persistence.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    private String name;
    private String state;

    public CityDTO(String name, String state) {
        this.name = name;
        this.state = state;
    }

}
