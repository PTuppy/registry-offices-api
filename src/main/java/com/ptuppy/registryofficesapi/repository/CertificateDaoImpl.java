package com.ptuppy.registryofficesapi.repository;

import com.ptuppy.registryofficesapi.domain.CertificatesEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CertificateDaoImpl extends AbstractDao<CertificatesEntity,Long> implements CertificateDao{

    public CertificatesEntity findByName(String name) {
        return getEntityManager().createQuery(
                        "SELECT c FROM certificates c WHERE c.nome LIKE :nome",CertificatesEntity.class)
                .setParameter("nome", name)
                .getSingleResult();
    }



}
