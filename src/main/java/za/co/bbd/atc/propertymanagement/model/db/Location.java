package za.co.bbd.atc.propertymanagement.model.db;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LocationID", nullable = false)
    private Integer id;

    @Column(name = "Street", nullable = false)
    private String street;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "Province", nullable = false)
    private String province;

    @Column(name = "Zip", nullable = false)
    private String zip;

    @Column(name = "Country", nullable = false)
    private String country;

    @Column(name = "GeoLocation")
    private String geoLocation;

    @OneToMany(mappedBy = "location")
    private Set<PersonLookup> peopleLookup;

    protected Location() {}

    public Location(
            String street,
            String city,
            String province,
            String zip,
            String country,
            String geoLocation
    ) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.zip = zip;
        this.country = country;
        this.geoLocation = geoLocation;
    }

    public Location(
            String street,
            String city,
            String province,
            String zip,
            String country
    ) {
        this(street, city, province, zip, country, null);
    }

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
}
