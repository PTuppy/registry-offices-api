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

        CertificatesEntity f = new CertificatesEntity();
        f.setId(4L);
        f.setNome("Nova certidão");
        list.add(f);

        list.forEach(certificate -> fetchCertificate(certificate));

        return list;
    }

    @Override
    public CertificatesEntity findById(Long id) {

        if(id==4L ){
            CertificatesEntity f = new CertificatesEntity();
            f.setId(4L);
            f.setNome("Nova certidão");
            return f;
        } else {
            return remoteCertificateService.listCertificates()
                    .stream()
                    .filter(certificatesEntity -> certificatesEntity.getId() == id)
                    .findFirst()
                    .orElseThrow();
        }
    }

    private void fetchCertificate(CertificatesEntity certificate) {
        certificateDao.update(certificate);
    }

}
