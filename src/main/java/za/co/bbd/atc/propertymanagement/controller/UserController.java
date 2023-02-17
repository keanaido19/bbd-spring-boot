package za.co.bbd.atc.propertymanagement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.atc.propertymanagement.dto.user.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.dto.user.UserDTO;
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
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer id) {
        userDTO = userService.updateUser(userDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/update-names/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateNames(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer id) {
        userDTO = userService.updateNames(userDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/update-email-address/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateEmailAddress(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer id) {
        userDTO = userService.updateEmailAddress(userDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/update-phone-numbers/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updatePhoneNumbers(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer id) {
        userDTO = userService.updatePhoneNumbers(userDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
            value = "/update-address/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> updateAddress(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer id) {
        userDTO = userService.updateAddress(userDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
