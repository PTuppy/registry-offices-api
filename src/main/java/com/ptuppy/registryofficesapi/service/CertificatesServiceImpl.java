package com.ptuppy.registryofficesapi.service;

import com.ptuppy.registryofficesapi.domain.CertificatesEntity;
import com.ptuppy.registryofficesapi.repository.CertificateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CertificatesServiceImpl implements CertificatesService{

    @Autowired
    private CertificateDao certificateDao;

    @Autowired
    private RemoteCertificateService remoteCertificateService;

    @Override
    public List<CertificatesEntity> findAll() {
        List<CertificatesEntity> list = remoteCertificateService.listCertificates();

        list.forEach(certificate -> updateRepository(certificate));

        return list;
    }

    @Override
    public CertificatesEntity findById(Long id) {

            return remoteCertificateService.listCertificates()
                    .stream()
                    .filter(certificatesEntity -> certificatesEntity.getId() == id)
                    .findFirst()
                    .orElseThrow();
        }

    private void updateRepository(CertificatesEntity certificate) {
        certificateDao.update(certificate);
    }

}
