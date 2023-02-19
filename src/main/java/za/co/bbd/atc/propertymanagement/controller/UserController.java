package za.co.bbd.atc.propertymanagement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;
import za.co.bbd.atc.propertymanagement.dto.user.*;
import za.co.bbd.atc.propertymanagement.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> userDTOlist = userService.getAllUsers();
        return new ResponseEntity<>(userDTOlist, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUser(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserCreationDTO userCreationDTO) {
        UserDTO userDTO = userService.saveUser(userCreationDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserCreationDTO userCreationDTO, @PathVariable Integer id) {
        UserDTO userDTO = userService.updateUser(userCreationDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/{id}/names",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateNames(@Valid @RequestBody NamesDTO namesDTO, @PathVariable Integer id) {
        UserDTO userDTO = userService.updateNames(namesDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/{id}/email-address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateEmailAddress(@Valid @RequestBody EmailAddressDTO emailAddressDTO, @PathVariable Integer id) {
        UserDTO userDTO = userService.updateEmailAddress(emailAddressDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/{id}/contact-details",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateContactDetails(@Valid @RequestBody List<PhoneNumberDTO> contactDetails, @PathVariable Integer id) {
        UserDTO userDTO = userService.updateContactDetails(contactDetails, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/{id}/address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateAddress(@Valid @RequestBody AddressDTO addressDTO, @PathVariable Integer id) {
        UserDTO userDTO = userService.updateAddress(addressDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
