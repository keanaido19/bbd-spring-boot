package za.co.bbd.atc.propertymanagement.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;
import za.co.bbd.atc.propertymanagement.dto.user.PhoneNumberDTO;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;
import za.co.bbd.atc.propertymanagement.entity.user.EmailAddressEntity;
import za.co.bbd.atc.propertymanagement.entity.user.UserEntity;
import za.co.bbd.atc.propertymanagement.dto.user.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.dto.user.UserDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final PhoneNumberConverter phoneNumberConverter;
    private final AddressConverter addressConverter;

    public UserEntity convertDTOtoEntity(UserCreationDTO userCreationDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userCreationDTO.getFirstName());
        userEntity.setLastName(userCreationDTO.getLastName());

        EmailAddressEntity emailAddressEntity = new EmailAddressEntity();
        emailAddressEntity.setEmailAddress(userCreationDTO.getEmailAddress());
        emailAddressEntity.setUserEntity(userEntity);
        userEntity.setEmailAddressEntity(emailAddressEntity);

        List<PhoneNumberDTO> phoneNumberDTOList = userCreationDTO.getPhoneNumberList();
        if (null != phoneNumberDTOList)
            userEntity.setPhoneNumberEntityList(phoneNumberConverter.convertDTOlistToEntityList(phoneNumberDTOList));

        AddressDTO addressDTO = userCreationDTO.getAddress();
        if (null != addressDTO) {
            AddressEntity addressEntity = addressConverter.convertDTOtoEntity(addressDTO);
            userEntity.setAddressEntity(addressEntity);
        }

        return userEntity;
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
