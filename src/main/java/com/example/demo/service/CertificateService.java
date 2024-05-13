package com.example.demo.service;

import com.example.demo.model.Certificate;
import com.example.demo.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }
    public Certificate saveCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }
}

