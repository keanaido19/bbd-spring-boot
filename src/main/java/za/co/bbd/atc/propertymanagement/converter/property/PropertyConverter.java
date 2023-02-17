package za.co.bbd.atc.propertymanagement.converter.property;

import lombok.RequiredArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.property.PropertiesDTO;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

@RequiredArgsConstructor
public class PropertyConverter {
    private final HouseConverter houseConverter;
    private final ApartmentConverter apartmentConverter;
    private final EstateConverter estateConverter;

    public PropertiesDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertiesDTO dto = new PropertiesDTO();
//        dto.setHouses(houseConverter.(propertyEntity.getHouseEntity()));


        return dto;
    }
}
