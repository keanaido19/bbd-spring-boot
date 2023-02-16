package za.co.bbd.atc.propertymanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.atc.propertymanagement.model.dto.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.model.dto.UserDTO;
import za.co.bbd.atc.propertymanagement.service.PersonLookupService;
import za.co.bbd.atc.propertymanagement.service.UserService;
import za.co.bbd.atc.propertymanagement.service.user.UserServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserServiceImpl us;
    private final PersonLookupService personLookupService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> registerUser(@RequestBody UserCreationDTO userCreationDTO) {
        try {
            personLookupService.save(userCreationDTO);
            return new ResponseEntity<>(Map.of("message", "User has been registered"), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(Map.of("StackTrace", e.getCause().getMessage(), "message", e.getMessage()), HttpStatus.FORBIDDEN);
        }
    }

//    @GetMapping(
//            value = "/",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public List<UserDTO> getUser() {
//        return personLookupService.getAll().stream().map(UserDTO::new).collect(Collectors.toList());
//    }

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<UserDTO>> getUser() {
        List<UserDTO> users = us.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping(
//            value = "/{id}",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public UserDTO getUser(@PathVariable Integer id) {
//        return personLookupService.get(id)
//                .map(UserDTO::new)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {

    }

    @PatchMapping(
            value = "/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> updateEmail(
            @PathVariable String email,
            @RequestParam("emailAddress") String emailRequestParam
    ) {
        userService.UpdateEmail(email, emailRequestParam);
        return new ResponseEntity<>(Map.of("message", "User Email Address has been updated"), HttpStatus.OK);
    }

    @PostMapping(
            value = "/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addPhoneNumber(
            @PathVariable String email,
            @RequestParam("Country Code") String countryCode,
            @RequestParam("Phone Number") String phoneNumber
    ) {
        userService.AddPhoneNumber(email, countryCode, phoneNumber);
        return new ResponseEntity<>(Map.of("message", "Added Phone Number To User"), HttpStatus.OK);
    }

    @PatchMapping(
            value = "/update/phone/user/{Email}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> updatePhoneNumber(
            @PathVariable String Email,
            @RequestParam("Old Country Code") String oldCountryCode,
            @RequestParam("Old Phone Number") String oldPhoneNumber,
            @RequestParam("New Country Code") String newCountryCode,
            @RequestParam("New Phone Number") String newPhoneNumber
    ) {
        userService.UpdatePhoneNumber(Email, oldCountryCode, oldPhoneNumber, newCountryCode, newPhoneNumber);
        return new ResponseEntity<>(Map.of("message", "Updated Phone Number"), HttpStatus.OK);
    }
}
