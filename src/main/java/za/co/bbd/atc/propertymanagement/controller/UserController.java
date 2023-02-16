package za.co.bbd.atc.propertymanagement.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.co.bbd.atc.propertymanagement.model.db.PersonLookup;
import za.co.bbd.atc.propertymanagement.service.UserService;

import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> register(
            @RequestParam("First Name") String firstName,
            @RequestParam("Last Name") String lastName,
            @RequestParam("Email Address") String email
    ) {
//        register a user...
        return new ResponseEntity<>(Map.of("message", "User has been registered"), HttpStatus.CREATED);
    }

    @GetMapping(
            value = "/user/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonLookup getUser(@PathVariable String email) {
        return userService
                .getUser(email)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @PatchMapping(
            value = "/user/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> updateEmail(
            @PathVariable String email,
            @RequestParam("Email Address") String emailRequestParam
    ) {
        userService.UpdateEmail(email, emailRequestParam);
        return new ResponseEntity<>(Map.of("message", "User Email Address has been updated"), HttpStatus.OK);
    }

    @PostMapping(
            value = "/user/{email}",
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
