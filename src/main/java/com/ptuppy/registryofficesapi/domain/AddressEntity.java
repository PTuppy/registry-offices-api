package com.ptuppy.registryofficesapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "registry_address")
public class AddressEntity extends AbstractEntity<Long>{

    @NotBlank
    @Size(min = 4, max = 255)
    @Column(nullable = false)
    private String address;

    @NotNull(message = "{NotNull.address.number}")
    @Digits(integer = 8, fraction = 0)
    @Column(nullable = false, length = 8)
    private Integer number;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String district;

    @Size(max = 255)
    @Column
    private String additionalInfo;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Size(min = 9, max = 9, message = "{Size.address.zipCode}")
    @Column(nullable = false, length = 9)
    private String zipCode;

    @NotNull(message = "{NotNull.endereco.uf}")
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private UfEnum uf;

    @Size(max = 255)
    @Column
    private String reference;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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
