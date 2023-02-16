package za.co.bbd.atc.propertymanagement.model.dto;

import za.co.bbd.atc.propertymanagement.model.db.PhoneLookup;

public class PhoneNumber {
    private String countryCode;
    private String number;

    public PhoneNumber(PhoneLookup phoneLookup) {
        this.countryCode = phoneLookup.getCode();
        this.number = phoneLookup.getNumber();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
