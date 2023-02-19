package za.co.bbd.atc.propertymanagement.converter.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.dto.user.PhoneNumberDTO;
import za.co.bbd.atc.propertymanagement.entity.user.PhoneNumberEntity;
import za.co.bbd.atc.propertymanagement.repository.PhoneNumberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PhoneNumberConverter {

    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberEntity convertDTOtoEntity (PhoneNumberDTO phoneNumberDTO) {
        PhoneNumberEntity entity = phoneNumberRepository
                .findPhoneNumberEntityByCountryCodeAndPhoneNumber(
                        phoneNumberDTO.getCountryCode(), phoneNumberDTO.getPhoneNumber()
                );
        if (null == entity) {
            entity = new PhoneNumberEntity();
            entity.setCountryCode(phoneNumberDTO.getCountryCode());
            entity.setPhoneNumber(phoneNumberDTO.getPhoneNumber());
        }

        return entity;
    }

    public List<PhoneNumberEntity> convertDTOlistToEntityList(List<PhoneNumberDTO> phoneNumberDTOList) {
        return phoneNumberDTOList.stream().map(this::convertDTOtoEntity).collect(Collectors.toList());
    }

    public PhoneNumberDTO convertEntityToDTO(PhoneNumberEntity phoneNumberEntity) {
        PhoneNumberDTO dto = new PhoneNumberDTO();
        dto.setCountryCode(phoneNumberEntity.getCountryCode());
        dto.setPhoneNumber(phoneNumberEntity.getPhoneNumber());
        return dto;
    }

    public List<PhoneNumberDTO> convertEntityListToDTOlist(List<PhoneNumberEntity> phoneNumberEntityList) {
         return Optional
                 .ofNullable(phoneNumberEntityList)
                 .orElse(new ArrayList<>())
                 .stream()
                 .map(this::convertEntityToDTO)
                 .collect(Collectors.toList());
    }
}
