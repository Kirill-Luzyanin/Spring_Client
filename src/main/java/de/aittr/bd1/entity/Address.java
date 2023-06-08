package de.aittr.bd1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="address")
@NoArgsConstructor
@Getter
@Setter

public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)
    private Long id;

    @Column (name="country")
    private String country;

    @Column (name="city")
    private String city;

    @Column (name="building")
    private int building;

    //@OneToOne(mappedBy = "address")
    //private Client client;


}
