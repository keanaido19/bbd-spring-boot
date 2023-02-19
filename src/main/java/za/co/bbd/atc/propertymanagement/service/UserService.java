package za.co.bbd.atc.propertymanagement.service;

import za.co.bbd.atc.propertymanagement.dto.AddressDTO;
import za.co.bbd.atc.propertymanagement.dto.user.*;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserCreationDTO userCreationDTO);

    UserDTO getUser(Integer id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserCreationDTO userCreationDTO, Integer id);

    UserDTO updateNames(NamesDTO namesDTO, Integer id);

    UserDTO updateEmailAddress(EmailAddressDTO emailAddressDTO, Integer id);

    UserDTO updateContactDetails(List<PhoneNumberDTO> contactDetails, Integer id);

    UserDTO updateAddress(AddressDTO addressDTO, Integer id);
}
