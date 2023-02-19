package za.co.bbd.atc.propertymanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.converter.user.PhoneNumberConverter;
import za.co.bbd.atc.propertymanagement.converter.user.UserConverter;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;
import za.co.bbd.atc.propertymanagement.dto.user.*;
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
import java.util.stream.Collectors;

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

    private void updateContactDetails(List<PhoneNumberDTO> phoneNumbers, UserEntity userEntity) {
        List<PhoneNumberEntity> addList = phoneNumberConverter.convertDTOlistToEntityList(phoneNumbers.stream().distinct().toList());

        List<PhoneNumberEntity> removeList =
                Optional.ofNullable(userEntity.getPhoneNumberEntityList()).orElse(new ArrayList<>());

        removeList.removeAll(addList);

        addList.removeAll(Optional.ofNullable(userEntity.getPhoneNumberEntityList()).orElse(new ArrayList<>()));

        userEntity.removeAllPhoneNumbers();

        userEntity.removePhoneNumbers(removeList);
        userEntity.addPhoneNumbers(addList);
    }

    private void updateAddress(AddressDTO addressDTO, UserEntity userEntity) {
        if (null == addressDTO) userEntity.setAddressEntity(null);
        else {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setStreet(addressDTO.getStreet());
            addressEntity.setCity(addressDTO.getCity());
            addressEntity.setProvince(addressDTO.getProvince());
            addressEntity.setZip(addressDTO.getZip());
            addressEntity.setCountry(addressDTO.getCountry());
            userEntity.setAddressEntity(addressEntity);
        }
    }

    @Override
    public UserDTO updateUser(UserCreationDTO userCreationDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isEmpty()) throw new UserNotFoundException(id);

        UserEntity userEntity = optionalUserEntity.get();

        userEntity.setFirstName(userCreationDTO.getFirstName());
        userEntity.setLastName(userCreationDTO.getLastName());

        userEntity.getEmailAddressEntity().setEmailAddress(userCreationDTO.getEmailAddress());

        updateContactDetails(userCreationDTO.getContactDetails(), userEntity);

        updateAddress(userCreationDTO.getAddress(), userEntity);

        userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO updateNames(NamesDTO namesDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isEmpty()) throw new UserNotFoundException(id);

        UserEntity userEntity = optionalUserEntity.get();

        userEntity.setFirstName(namesDTO.getFirstName());
        userEntity.setLastName(namesDTO.getLastName());

        userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);

    }

    @Override
    public UserDTO updateEmailAddress(EmailAddressDTO emailAddressDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isEmpty()) throw new UserNotFoundException(id);

        UserEntity userEntity = optionalUserEntity.get();

        userEntity.getEmailAddressEntity().setEmailAddress(emailAddressDTO.getEmailAddress());

        userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO updateContactDetails(List<PhoneNumberDTO> contactDetails, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isEmpty()) throw new UserNotFoundException(id);

        UserEntity userEntity = optionalUserEntity.get();

        updateContactDetails(contactDetails, userEntity);

        userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO updateAddress(AddressDTO addressDTO, Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isEmpty()) throw new UserNotFoundException(id);

        UserEntity userEntity = optionalUserEntity.get();

        updateAddress(addressDTO, userEntity);

        userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }
}
