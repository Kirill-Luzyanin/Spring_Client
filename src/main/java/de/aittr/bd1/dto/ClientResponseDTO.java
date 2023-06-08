package de.aittr.bd1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientResponseDTO {
    private Long id;
    private String name;
    //private AccountResponseDTO account;
    private List<AccountResponseDTO> accounts;
    private AddressResponseDTO address;
}
