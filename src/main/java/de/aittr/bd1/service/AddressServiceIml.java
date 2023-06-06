package de.aittr.bd1.service;

import de.aittr.bd1.dto.AccountRequestDTO;
import de.aittr.bd1.dto.AccountResponseDTO;
import de.aittr.bd1.dto.AddressRequestDTO;
import de.aittr.bd1.dto.AddressResponseDTO;
import de.aittr.bd1.entity.Account;
import de.aittr.bd1.entity.Address;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceIml implements AddressService{
    private final JpaRepository<Address, Long> addressRepository;
    private final ModelMapper mapper;

    @Override
    public List<AddressResponseDTO> getList() {
        List<Address> adresses = addressRepository.findAll();
        return adresses.stream()
                .map(a->mapper.map(a, AddressResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponseDTO getAddress(Long id) {
        return mapper.map(addressRepository.findById(id), AddressResponseDTO.class);
    }

    @Override
    public AddressResponseDTO addAddress(AddressRequestDTO address) {
        Address entity = mapper.map(address, Address.class);
        return mapper.map(addressRepository.save(entity),AddressResponseDTO.class);
    }

    @Override
    public AddressResponseDTO updateAddress(Long id, AddressRequestDTO address) {
        if (addressRepository.existsById(id)) {
            Address entity = mapper.map(address, Address.class);
            entity.setId(id);
            return mapper.map(addressRepository.save(entity), AddressResponseDTO.class);
        }
        return null;

    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
