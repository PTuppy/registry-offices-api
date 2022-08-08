package com.ptuppy.registryofficesapi.unit.utils;

import com.ptuppy.registryofficesapi.domain.AddressEntity;
import com.ptuppy.registryofficesapi.domain.CertificatesEntity;
import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import com.ptuppy.registryofficesapi.domain.UfEnum;

import java.util.ArrayList;
import java.util.List;

public class GenerateEntity {

    public static RegistryEntity generateRegistryRequest(){

        AddressEntity address = new AddressEntity();

        address.setAddress("Rua de Teste");
        address.setAdditionalInfo("Ap 1");
        address.setCity("São Paulo");
        address.setDistrict("Dia");
        address.setNumber(123);
        address.setUf(UfEnum.BA);
        address.setZipCode("02345-098");

        CertificatesEntity certificates = new CertificatesEntity();

        certificates.setId(1l);
        certificates.setNome("2º Via de Documento");

        List<CertificatesEntity> certificatesList = new ArrayList<>();

        RegistryEntity registry = new RegistryEntity();
        registry.setName("Nome de Teste");
        registry.setAddress(address);
        registry.setCertificates(certificatesList);

        return registry;
    }

}
