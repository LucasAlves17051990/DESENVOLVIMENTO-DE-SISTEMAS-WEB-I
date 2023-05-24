package br.com.lince.pokeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lince.pokeapi.model.Ginasio;
import br.com.lince.pokeapi.model.Validation;
import br.com.lince.pokeapi.repository.GinasioRepository;

@Service
public class GinasioService {
    @Autowired
    private GinasioRepository repository;

    public List<Ginasio> findAll() {
        return repository.findAll();
    }


    public Ginasio save(Ginasio ginasio) throws IllegalArgumentException {
        if (!Validation.titleValidate(ginasio.getTrainer())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 100 caracteres");
        }
        if (!Validation.nameValidate(ginasio.getPokemon())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 50 caracteres");
        }
        if (!Validation.nameValidate(ginasio.getBadge())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 50 caracteres");
        }
        return repository.save(ginasio);
    }
    
    public Optional<Ginasio> findOne(String trainer) {
        return repository.findById(trainer);
    }
    public void delete(String trainer) {
        repository.deleteById(trainer);
    }
}