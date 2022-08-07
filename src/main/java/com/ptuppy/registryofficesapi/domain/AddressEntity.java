package com.ptuppy.registryofficesapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "registry_address")
public class AddressEntity extends AbstractEntity<Long>{

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 8)
    private String number;

    @Column(nullable = false)
    private String district;

    @Column
    private String additionalInfo;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 9)
    private String zipCode;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private UfEnum uf;

    @Column
    private String reference;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public UfEnum getUf() {
        return uf;
    }

    public void setUf(UfEnum uf) {
        this.uf = uf;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
