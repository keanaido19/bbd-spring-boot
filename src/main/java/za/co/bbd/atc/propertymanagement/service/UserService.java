package za.co.bbd.atc.propertymanagement.service;

import za.co.bbd.atc.propertymanagement.dto.user.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserCreationDTO userCreationDTO);

    UserDTO getUser(Integer id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO userDTO, Integer id);

    UserDTO updateNames(UserDTO userDTO, Integer id);

    UserDTO updateEmailAddress(UserDTO userDTO, Integer id);

    UserDTO updatePhoneNumbers(UserDTO userDTO, Integer id);

    UserDTO updateAddress(UserDTO userDTO, Integer id);
}
