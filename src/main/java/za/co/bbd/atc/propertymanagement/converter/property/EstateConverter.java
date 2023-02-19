//package za.co.bbd.atc.propertymanagement.converter.property;
//
//import lombok.RequiredArgsConstructor;
//import za.co.bbd.atc.propertymanagement.converter.AddressConverter;
//import za.co.bbd.atc.propertymanagement.dto.property.EstateDTO;
//import za.co.bbd.atc.propertymanagement.dto.property.LotDTO;
//import za.co.bbd.atc.propertymanagement.entity.property.EstateEntity;
//import za.co.bbd.atc.propertymanagement.entity.property.LotEntity;
//import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//public class EstateConverter {
//    private final AddressConverter addressConverter;
//    private final LotConverter lotConverter;
//    public EstateDTO convertEntityToDTO(EstateEntity estateEntity) {
//        EstateDTO dto = new EstateDTO();
//        dto.setEstateID(estateEntity.getId());
//        dto.setName(estateEntity.getName());
//        dto.setEstateLots(lotConverter.convertEntityListToDTOlist(estateEntity.getEstateLots()));
//
//        PropertyEntity propertyEntity = estateEntity.getPropertyEntity();
//        dto.setAddress(addressConverter.convertEntityToDTO(propertyEntity.getAddressEntity()));
//        dto.setPropertyID(propertyEntity.getId());
//
//        return dto;
//    }
//
//    public List<EstateDTO> convertEntityListToDTOlist(List<EstateEntity> estateEntityList) {
//        return estateEntityList.stream().map(this::convertEntityToDTO).toList();
//    }
//}
