package za.co.bbd.atc.propertymanagement.service.user;

import za.co.bbd.atc.propertymanagement.model.dto.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    public UserDTO saveUser(UserCreationDTO userCreationDTO);

    public List<UserDTO> getAllUsers();
}
