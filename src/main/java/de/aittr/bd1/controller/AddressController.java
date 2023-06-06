package de.aittr.bd1.controller;

import de.aittr.bd1.dto.AccountRequestDTO;
import de.aittr.bd1.dto.AccountResponseDTO;
import de.aittr.bd1.dto.AddressRequestDTO;
import de.aittr.bd1.dto.AddressResponseDTO;
import de.aittr.bd1.service.AccountService;
import de.aittr.bd1.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("address")
public class AddressController {
    private final AddressService service;

    @GetMapping(value="")
    public List<AddressResponseDTO> getList(){
        return service.getList();
    }

    @GetMapping(value = "/{id}")
    public AddressResponseDTO getAddress(@PathVariable(name = "id") Long id){
        return service.getAddress(id);
    }

    @PostMapping(value="")
    @ResponseStatus(code= HttpStatus.CREATED)
    public AddressResponseDTO addAddress(@RequestBody AddressRequestDTO address){
        return service.addAddress(address);
    }

    @PutMapping(value="/{id}")
    public AddressResponseDTO updateAddress(@PathVariable(name="id") Long id, @RequestBody AddressRequestDTO address){
        return service.updateAddress(id,address);
    }

    @DeleteMapping(value="/{id}")
    public void addAddress(@PathVariable(name="id") Long id){
        service.deleteAddress(id);
    }

}
