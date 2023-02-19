package za.co.bbd.atc.propertymanagement.converter.property;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.dto.property.PropertyDTO;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PropertyConverter {
    private final HouseConverter houseConverter;
    private final ApartmentConverter apartmentConverter;

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        if (null != propertyEntity.getHouseEntity()) {
            return houseConverter.convertEntityToDTO(propertyEntity);
        }

        if (null != propertyEntity.getApartmentEntity()) {
            return apartmentConverter.convertEntityToDTO(propertyEntity);
        }


        return null;
    }

    public List<PropertyDTO> convertEntityListToDTOlist(List<PropertyEntity> propertyEntities) {
        return Optional
                .ofNullable(propertyEntities)
                .orElse(new ArrayList<>())
                .stream()
                .map(this::convertEntityToDTO)
                .toList();
    }
}
