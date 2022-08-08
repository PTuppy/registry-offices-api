package com.ptuppy.registryofficesapi.service;

import com.ptuppy.registryofficesapi.domain.CertificatesEntity;

import java.util.List;

public interface RemoteCertificateService {

    List<CertificatesEntity> listCertificates();

}
