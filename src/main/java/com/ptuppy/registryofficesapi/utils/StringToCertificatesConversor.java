package com.ptuppy.registryofficesapi.utils;

import com.ptuppy.registryofficesapi.domain.CertificatesEntity;
import com.ptuppy.registryofficesapi.service.CertificatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCertificatesConversor implements Converter<String, CertificatesEntity> {

    @Autowired
    private CertificatesService service;

    @Override
    public CertificatesEntity convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return service.findById(id);
    }

}
