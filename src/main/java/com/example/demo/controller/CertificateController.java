package com.example.demo.controller;

import com.example.demo.model.Certificate;
import com.example.demo.repository.CertificateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateRepository certificateRepository;

    public CertificateController(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @GetMapping("/all")
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @PostMapping("/save")
    public Certificate saveCertificate(@RequestBody Certificate certificate) {
        return certificateRepository.save(certificate);
    }
}

