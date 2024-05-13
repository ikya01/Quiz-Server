package com.example.demo.service;

import com.example.demo.model.Result;
import com.example.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    // Méthode pour récupérer tous les résultats
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    // Méthode pour récupérer un résultat par son ID
    public Result getResultById(Long id) {
        Optional<Result> resultOptional = resultRepository.findById(id);
        return resultOptional.orElse(null); // ou utiliser .orElseThrow() pour lancer une exception si non trouvé
    }

    // Méthode pour ajouter un nouveau résultat
    public Result addResult(Result result) {
        return resultRepository.save(result);
    }



    // Méthode pour supprimer un résultat par son ID
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
