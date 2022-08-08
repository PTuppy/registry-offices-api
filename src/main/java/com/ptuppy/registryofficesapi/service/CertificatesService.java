package com.ptuppy.registryofficesapi.service;


import com.ptuppy.registryofficesapi.domain.CertificatesEntity;

import java.util.List;

public interface CertificatesService {

    List<CertificatesEntity> findAll();

    CertificatesEntity findById(Long id);



}
