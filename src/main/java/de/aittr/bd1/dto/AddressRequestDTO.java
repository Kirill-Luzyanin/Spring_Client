package de.aittr.bd1.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressRequestDTO {

    private String country;

    private String city;

    private int building;

}
