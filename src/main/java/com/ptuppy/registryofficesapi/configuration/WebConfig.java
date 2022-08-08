package com.ptuppy.registryofficesapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebConfig {

    @Value("${docket.certificates.url}")
    private String certificatesUrl;

    public String getCertificatesUrl() {
        return certificatesUrl;
    }
}
