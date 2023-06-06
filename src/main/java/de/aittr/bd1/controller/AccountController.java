package de.aittr.bd1.controller;

import de.aittr.bd1.dto.AccountRequestDTO;
import de.aittr.bd1.dto.AccountResponseDTO;

import de.aittr.bd1.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController {
    private final AccountService service;

    @GetMapping(value="")
    public List<AccountResponseDTO> getList(){
        return service.getList();
    }

    @GetMapping(value = "/{id}")
    public AccountResponseDTO getAccount(@PathVariable(name = "id") Long id){
        return service.getAccount(id);
    }

    @PostMapping(value="")
    @ResponseStatus(code= HttpStatus.CREATED)
    public AccountResponseDTO addAccount(@RequestBody AccountRequestDTO account){
        return service.addAccount(account);
    }

    @PutMapping(value="/{id}")
    public AccountResponseDTO updateAccount(@PathVariable(name="id") Long id, @RequestBody AccountRequestDTO client){
        return service.updateAccount(id,client);
    }

    @DeleteMapping(value="/{id}")
    public void addAccount(@PathVariable(name="id") Long id){
        service.deleteAccount(id);
    }


}
