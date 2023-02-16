package za.co.bbd.atc.propertymanagement.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.converter.UserConverter;
import za.co.bbd.atc.propertymanagement.entity.UserEntity;
import za.co.bbd.atc.propertymanagement.model.dto.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.model.dto.UserDTO;
import za.co.bbd.atc.propertymanagement.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserDTO saveUser(UserCreationDTO userCreationDTO) {
        UserEntity ue = userRepository.save(userConverter.convertDTOtoEntity(userCreationDTO));
        return userConverter.convertEntityToDTO(ue);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userRepository.findAll().stream().map(userConverter::convertEntityToDTO).toList();
        return users;
    }
}
