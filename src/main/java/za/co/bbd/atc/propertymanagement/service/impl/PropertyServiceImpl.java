package za.co.bbd.atc.propertymanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.converter.property.HouseConverter;
import za.co.bbd.atc.propertymanagement.converter.property.PropertyConverter;
import za.co.bbd.atc.propertymanagement.dto.property.HouseDTO;
import za.co.bbd.atc.propertymanagement.dto.property.PropertyDTO;
import za.co.bbd.atc.propertymanagement.entity.property.HouseEntity;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;
import za.co.bbd.atc.propertymanagement.repository.HouseRepository;
import za.co.bbd.atc.propertymanagement.repository.PropertyRepository;
import za.co.bbd.atc.propertymanagement.service.PropertyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final HouseRepository houseRepository;
    private final PropertyConverter propertyConverter;
    private final HouseConverter houseConverter;

    @Override
    public List<HouseDTO> getAll() {
        List<HouseEntity> properties = houseRepository.findAll();
        return houseConverter.convertEntityListToDTOlist(properties);
    }
}
