package za.co.bbd.atc.propertymanagement.converter.property;

import lombok.RequiredArgsConstructor;
import za.co.bbd.atc.propertymanagement.converter.AddressConverter;
import za.co.bbd.atc.propertymanagement.dto.property.ApartmentDTO;
import za.co.bbd.atc.propertymanagement.dto.property.LotDTO;
import za.co.bbd.atc.propertymanagement.entity.property.ApartmentEntity;
import za.co.bbd.atc.propertymanagement.entity.property.LotEntity;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

import java.util.List;

@RequiredArgsConstructor
public class ApartmentConverter {
    private final AddressConverter addressConverter;
    private final LotConverter lotConverter;
    public ApartmentDTO convertEntityToDTO(ApartmentEntity apartmentEntity) {
        ApartmentDTO dto = new ApartmentDTO();
        dto.setApartmentID(apartmentEntity.getId());
        dto.setName(apartmentEntity.getName());
        dto.setApartmentLots(lotConverter.convertEntityListToDTOlist(apartmentEntity.getApartmentLots()));

        PropertyEntity propertyEntity = apartmentEntity.getPropertyEntity();
        dto.setAddress(addressConverter.convertEntityToDTO(propertyEntity.getAddressEntity()));
        dto.setPropertyID(propertyEntity.getId());

        return dto;
    }

    public List<ApartmentDTO> convertEntityListToDTOlist(List<ApartmentEntity> apartmentEntityList) {
        return apartmentEntityList.stream().map(this::convertEntityToDTO).toList();
    }
}
