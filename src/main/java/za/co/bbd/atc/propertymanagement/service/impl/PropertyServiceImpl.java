package za.co.bbd.atc.propertymanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;
import za.co.bbd.atc.propertymanagement.repository.PropertyRepository;
import za.co.bbd.atc.propertymanagement.service.PropertyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;

    @Override
    public List<PropertyEntity> getAll() {
        List<PropertyEntity> propertyEntityList = propertyRepository.findAll();
        return propertyEntityList;
    }
}
