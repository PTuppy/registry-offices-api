package com.ptuppy.registryofficesapi.repository;

import com.ptuppy.registryofficesapi.domain.CertificatesEntity;

import java.util.List;

public interface CertificateDao {

    void save(CertificatesEntity certificate);

    void update(CertificatesEntity certificate);

    List<CertificatesEntity> findAll();

    CertificatesEntity findById(Long id);

    CertificatesEntity findByName(String name);

}
