package za.co.bbd.atc.propertymanagement.service;

import za.co.bbd.atc.propertymanagement.dto.property.PropertyDTO;

import java.util.List;

public interface PropertyService {
    List<PropertyDTO> getAll();
}
