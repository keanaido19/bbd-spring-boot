package za.co.bbd.atc.propertymanagement.converter;

import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.entity.PhoneNumberEntity;
import za.co.bbd.atc.propertymanagement.model.dto.PhoneNumberDTO;

import java.util.List;

@Component
public class PhoneNumberConverter {
    public PhoneNumberDTO convertEntityToDTO(PhoneNumberEntity phoneNumberEntity) {
        PhoneNumberDTO dto = new PhoneNumberDTO();
        dto.setCountryCode(phoneNumberEntity.getCountryCode());
        dto.setPhoneNumber(phoneNumberEntity.getPhoneNumber());
        return dto;
    }

    public List<PhoneNumberDTO> convertEntityListToDTOlist(List<PhoneNumberEntity> phoneNumberEntityList) {
        return phoneNumberEntityList.stream().map(this::convertEntityToDTO).toList();
    }
}
