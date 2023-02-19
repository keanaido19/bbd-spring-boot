package za.co.bbd.atc.propertymanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.converter.property.PropertyConverter;
import za.co.bbd.atc.propertymanagement.dto.property.PropertyDTO;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;
import za.co.bbd.atc.propertymanagement.repository.PropertyRepository;
import za.co.bbd.atc.propertymanagement.service.PropertyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final PropertyConverter propertyConverter;

    @Override
    public List<PropertyDTO> getAll() {
        List<PropertyEntity> properties = propertyRepository.findAll();
        return propertyConverter.convertEntityListToDTOlist(properties);
    }
}
