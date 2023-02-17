//package za.co.bbd.atc.propertymanagement.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;
//import za.co.bbd.atc.propertymanagement.service.impl.PropertyServiceImpl;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/properties")
//@RequiredArgsConstructor
//public class PropertyController {
//    private final PropertyServiceImpl propertyService;
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<PropertyEntity>> getUsers() {
//        List<PropertyEntity> propertyEntityList = propertyService.getAll();
//        return new ResponseEntity<>(propertyEntityList, HttpStatus.OK);
//    }
//}
