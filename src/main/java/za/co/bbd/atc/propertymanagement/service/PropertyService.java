package za.co.bbd.atc.propertymanagement.service;

import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

import java.util.List;

public interface PropertyService {
    List<PropertyEntity> getAll();
}
