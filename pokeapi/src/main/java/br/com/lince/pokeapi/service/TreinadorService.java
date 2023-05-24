package br.com.lince.pokeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.lince.pokeapi.model.Treinador;
import br.com.lince.pokeapi.model.Validation;
import br.com.lince.pokeapi.repository.TreinadorRepository;


@Service
public class TreinadorService {
    @Autowired
    private TreinadorRepository repository;

    public List<Treinador> findAll() {
        return repository.findAll();
    }


    public Treinador save(Treinador treinador) throws IllegalArgumentException {
        if (!Validation.titleValidate(treinador.getName())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 100 caracteres");
        }
        if (!Validation.nameValidate(treinador.getAge())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 50 caracteres");
        }
        if (!Validation.nameValidate(treinador.getSize())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 50 caracteres");
        }
        return repository.save(treinador);
    }
    
    public Optional<Treinador> findOne(String name) {
        return repository.findById(name);
    }
    public void delete(String name) {
        repository.deleteById(name);
    }
}