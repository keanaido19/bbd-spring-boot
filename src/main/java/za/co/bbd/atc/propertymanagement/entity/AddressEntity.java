package za.co.bbd.atc.propertymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;
import za.co.bbd.atc.propertymanagement.entity.user.UserEntity;

import java.util.List;

@Entity
@Table(name = "Location")
@NoArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "Street", nullable = false, length = 30)
    private String street;

    @Column(name = "City", nullable = false, length = 20)
    private String city;

    @Column(name = "Province", nullable = false, length = 20)
    private String province;

    @Column(name = "Zip", nullable = false, length = 10)
    private String zip;

    @Column(name = "Country", nullable = false, length = 20)
    private String country;

    @Column(name = "GeoLocation")
    private String geoLocation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "addressEntity")
    private List<UserEntity> userEntityList;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "addressEntity")
    private PropertyEntity propertyEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    @JsonIgnore
    public PropertyEntity getPropertyEntity() {
        return propertyEntity;
    }

    public void setPropertyEntity(PropertyEntity propertyEntity) {
        this.propertyEntity = propertyEntity;
    }
}
