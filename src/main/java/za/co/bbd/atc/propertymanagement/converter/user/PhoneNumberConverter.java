package za.co.bbd.atc.propertymanagement.converter.user;

import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.entity.user.PhoneNumberEntity;
import za.co.bbd.atc.propertymanagement.dto.user.PhoneNumberDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneNumberConverter {
    public PhoneNumberEntity convertDTOtoEntity (PhoneNumberDTO phoneNumberDTO) {
        PhoneNumberEntity entity = new PhoneNumberEntity();
        entity.setCountryCode(phoneNumberDTO.getCountryCode());
        entity.setPhoneNumber(phoneNumberDTO.getPhoneNumber());
        return entity;
    }

    public List<PhoneNumberEntity> convertDTOlistToEntityList(List<PhoneNumberDTO> phoneNumberDTOList) {
        return phoneNumberDTOList.stream().map(this::convertDTOtoEntity).toList();
    }

    public PhoneNumberDTO convertEntityToDTO(PhoneNumberEntity phoneNumberEntity) {
        PhoneNumberDTO dto = new PhoneNumberDTO();
        dto.setCountryCode(phoneNumberEntity.getCountryCode());
        dto.setPhoneNumber(phoneNumberEntity.getPhoneNumber());
        return dto;
    }

    public List<PhoneNumberDTO> convertEntityListToDTOlist(List<PhoneNumberEntity> phoneNumberEntityList) {
        if (null == phoneNumberEntityList) return new ArrayList<>();
        return phoneNumberEntityList.stream().map(this::convertEntityToDTO).toList();
    }
}
