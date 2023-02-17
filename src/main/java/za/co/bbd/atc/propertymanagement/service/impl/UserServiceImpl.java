package za.co.bbd.atc.propertymanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.converter.PhoneNumberConverter;
import za.co.bbd.atc.propertymanagement.converter.UserConverter;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;
import za.co.bbd.atc.propertymanagement.dto.PhoneNumberDTO;
import za.co.bbd.atc.propertymanagement.dto.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.dto.UserDTO;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;
import za.co.bbd.atc.propertymanagement.entity.EmailAddressEntity;
import za.co.bbd.atc.propertymanagement.entity.PhoneNumberEntity;
import za.co.bbd.atc.propertymanagement.entity.UserEntity;
import za.co.bbd.atc.propertymanagement.repository.PhoneNumberRepository;
import za.co.bbd.atc.propertymanagement.repository.UserRepository;
import za.co.bbd.atc.propertymanagement.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final UserConverter userConverter;
    private final PhoneNumberConverter phoneNumberConverter;

    @Override
    public UserDTO saveUser(UserCreationDTO userCreationDTO) {
        UserEntity userEntity = userRepository.save(userConverter.convertDTOtoEntity(userCreationDTO));
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public Optional<UserDTO> getUser(Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        return optionalUserEntity.map(userConverter::convertEntityToDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userRepository.findAll().stream().map(userConverter::convertEntityToDTO).toList();
        return users;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        UserDTO dto = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            userEntity.setFirstName(userDTO.getFirstName());
            userEntity.setLastName(userDTO.getLastName());

            userEntity.getEmailAddressEntity().setEmailAddress(userDTO.getEmailAddress());

            List<PhoneNumberEntity> phoneNumberEntityList = new ArrayList<>();
            List<PhoneNumberDTO> phoneNumberDTOList = userDTO.getPhoneNumberList();

            userEntity.removePhoneNumbers();

            if (null != phoneNumberDTOList) {
                for (PhoneNumberDTO phoneNumberDTO : phoneNumberDTOList) {
                    PhoneNumberEntity phoneNumberEntity = phoneNumberRepository
                            .findPhoneNumberEntityByCountryCodeAndPhoneNumber(
                                    phoneNumberDTO.getCountryCode(), phoneNumberDTO.getPhoneNumber()
                            );
                    if (null == phoneNumberEntity)
                        phoneNumberEntity = phoneNumberConverter.convertDTOtoEntity(phoneNumberDTO);
                    phoneNumberEntity.getUserEntityList().add(userEntity);
                    phoneNumberEntityList.add(phoneNumberEntity);
                }
            }
            userEntity.setPhoneNumberEntityList(phoneNumberEntityList);

            AddressEntity addressEntity = new AddressEntity();
            AddressDTO addressDTO = userDTO.getAddress();

            if (null == addressDTO) userEntity.setAddressEntity(null);
            else {
                addressEntity.setStreet(addressDTO.getStreet());
                addressEntity.setCity(addressDTO.getCity());
                addressEntity.setProvince(addressDTO.getProvince());
                addressEntity.setZip(addressDTO.getZip());
                addressEntity.setCountry(addressDTO.getCountry());
                userEntity.setAddressEntity(addressEntity);
            }

            userRepository.save(userEntity);
            dto = userConverter.convertEntityToDTO(userEntity);
        }
        return dto;
    }
}
