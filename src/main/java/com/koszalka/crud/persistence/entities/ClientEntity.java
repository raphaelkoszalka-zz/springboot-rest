package com.koszalka.crud.persistence.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "client", schema = "public")
@Getter
@Setter
public class ClientEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "short_sequence")
    @SequenceGenerator(name = "short_sequence", sequenceName = "short_sequence", allocationSize = 1, initialValue = 1, schema = "public")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    // For test purposes, since we do not have an UI I'll be checking by city name, instead of it's ID
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city", referencedColumnName = "name")
    private CityEntity city;

    @Column(name = "birthdate", nullable = false)
    private String birthdate;


}
