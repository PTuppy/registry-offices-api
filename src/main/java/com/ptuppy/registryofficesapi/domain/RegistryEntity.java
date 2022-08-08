package com.ptuppy.registryofficesapi.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "registry_offices")
public class RegistryEntity extends AbstractEntity<Long> {

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false, unique = true)
    private String name;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address_fk")
    private AddressEntity address;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name="registry_certificates", joinColumns=
            {@JoinColumn(name="registry_id")}, inverseJoinColumns=
            {@JoinColumn(name="certificate_id")})
    private List<CertificatesEntity> certificates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<CertificatesEntity> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificatesEntity> certificates) {
        this.certificates = certificates;
    }
}
