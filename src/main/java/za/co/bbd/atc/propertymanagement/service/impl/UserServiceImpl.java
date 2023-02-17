package za.co.bbd.atc.propertymanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.converter.user.PhoneNumberConverter;
import za.co.bbd.atc.propertymanagement.converter.user.UserConverter;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;
import za.co.bbd.atc.propertymanagement.dto.user.PhoneNumberDTO;
import za.co.bbd.atc.propertymanagement.dto.user.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.dto.user.UserDTO;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;
import za.co.bbd.atc.propertymanagement.entity.user.PhoneNumberEntity;
import za.co.bbd.atc.propertymanagement.entity.user.UserEntity;
import za.co.bbd.atc.propertymanagement.exception.UserNotFoundException;
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
    public UserDTO getUser(Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        return userConverter.convertEntityToDTO(optionalUserEntity.get());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userConverter::convertEntityToDTO).toList();
    }

    private void updatePhoneNumbers(UserDTO userDTO, UserEntity userEntity) {
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
    }

    private void updateAddress(UserDTO userDTO, UserEntity userEntity) {
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
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            userEntity.setFirstName(userDTO.getFirstName());
            userEntity.setLastName(userDTO.getLastName());

            userEntity.getEmailAddressEntity().setEmailAddress(userDTO.getEmailAddress());

            updatePhoneNumbers(userDTO, userEntity);

            updateAddress(userDTO, userEntity);

            userRepository.save(userEntity);
            return userConverter.convertEntityToDTO(userEntity);
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public UserDTO updateNames(UserDTO userDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            userEntity.setFirstName(userDTO.getFirstName());
            userEntity.setLastName(userDTO.getLastName());

            userRepository.save(userEntity);
            return userConverter.convertEntityToDTO(userEntity);
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public UserDTO updateEmailAddress(UserDTO userDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            userEntity.getEmailAddressEntity().setEmailAddress(userDTO.getEmailAddress());

            userRepository.save(userEntity);
            return userConverter.convertEntityToDTO(userEntity);
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public UserDTO updatePhoneNumbers(UserDTO userDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            updatePhoneNumbers(userDTO, userEntity);

            userRepository.save(userEntity);
            return userConverter.convertEntityToDTO(userEntity);
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public UserDTO updateAddress(UserDTO userDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            updateAddress(userDTO, userEntity);

            userRepository.save(userEntity);
            return userConverter.convertEntityToDTO(userEntity);
        }
        throw new UserNotFoundException(id);
    }
}
