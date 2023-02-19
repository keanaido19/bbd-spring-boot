package za.co.bbd.atc.propertymanagement.service;

import za.co.bbd.atc.propertymanagement.dto.property.HouseDTO;

import java.util.List;

public interface PropertyService {
    List<HouseDTO> getAll();
}
