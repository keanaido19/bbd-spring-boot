package za.co.bbd.atc.propertymanagement.service;

import za.co.bbd.atc.propertymanagement.dto.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserDTO saveUser(UserCreationDTO userCreationDTO);

    public Optional<UserDTO> getUser(Integer id);

    public List<UserDTO> getAllUsers();

    public UserDTO updateUser(UserDTO userDTO, Integer id);
}
