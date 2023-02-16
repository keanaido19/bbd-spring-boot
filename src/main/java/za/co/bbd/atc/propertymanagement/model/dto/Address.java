package za.co.bbd.atc.propertymanagement.model.dto;

import za.co.bbd.atc.propertymanagement.model.db.Location;

public class Address {
    private String street;
    private String city;
    private String province;
    private String zip;
    private String country;

    public Address(Location location) {
        this.street = location.getStreet();
        this.city = location.getCity();
        this.province = location.getProvince();
        this.zip = location.getZip();
        this.country = location.getCountry();
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
}
