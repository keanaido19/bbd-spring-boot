package za.co.bbd.atc.propertymanagement.converter.property;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.converter.AddressConverter;
import za.co.bbd.atc.propertymanagement.dto.property.ApartmentDTO;
import za.co.bbd.atc.propertymanagement.dto.property.LotDTO;
import za.co.bbd.atc.propertymanagement.entity.property.ApartmentEntity;
import za.co.bbd.atc.propertymanagement.entity.property.LotEntity;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ApartmentConverter {
    private final AddressConverter addressConverter;
    private final LotConverter lotConverter;
    public ApartmentDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        ApartmentEntity apartmentEntity = propertyEntity.getApartmentEntity();
        ApartmentDTO dto = new ApartmentDTO();
        dto.setApartmentID(apartmentEntity.getId());
        dto.setName(apartmentEntity.getName());
        System.out.println(apartmentEntity.getLots());
        dto.setApartmentLots(lotConverter.convertEntityListToDTOlist(apartmentEntity.getLots()));

        propertyEntity = apartmentEntity.getPropertyEntity();
        dto.setAddress(addressConverter.convertEntityToDTO(propertyEntity.getAddressEntity()));
        dto.setPropertyID(propertyEntity.getId());

        return dto;
    }
}
