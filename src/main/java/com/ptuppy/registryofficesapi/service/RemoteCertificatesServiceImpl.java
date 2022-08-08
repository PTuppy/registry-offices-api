package com.ptuppy.registryofficesapi.service;

import com.ptuppy.registryofficesapi.configuration.WebConfig;
import com.ptuppy.registryofficesapi.domain.CertificatesEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RemoteCertificatesServiceImpl extends BaseRemoteService implements RemoteCertificateService{

    public RemoteCertificatesServiceImpl(final WebClient webClient, final WebConfig webConfig){
        super(webClient,webConfig);
    }

    @Override
    public List<CertificatesEntity> listCertificates() {
        return webClient
                .get()
                .uri(webConfig.getCertificatesUrl())
                .retrieve()
                .bodyToFlux(CertificatesEntity.class)
                .collectList()
                .block();

    }
}
