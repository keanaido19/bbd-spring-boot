package za.co.bbd.atc.propertymanagement.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.entity.UserEntity;
import za.co.bbd.atc.propertymanagement.model.dto.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.model.dto.UserDTO;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final PhoneNumberConverter phoneNumberConverter;
    private final AddressConverter addressConverter;

    public UserEntity convertDTOtoEntity(UserCreationDTO userCreationDTO) {
        UserEntity ue = new UserEntity();
        ue.setFirstName(userCreationDTO.getFirstName());
        ue.setLastName(userCreationDTO.getLastName());
        return ue;
    }

    public UserDTO convertEntityToDTO(UserEntity userEntity) {
        UserDTO dto = new UserDTO();
        dto.setId(userEntity.getId());
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setEmailAddress(userEntity.getEmailAddressEntity().getEmailAddress());
        dto.setPhoneNumberList(phoneNumberConverter.convertEntityListToDTOlist(userEntity.getPhoneNumberEntityList()));
        dto.setAddress(addressConverter.convertEntityToDTO(userEntity.getAddressEntity()));
        return dto;
    }
}
