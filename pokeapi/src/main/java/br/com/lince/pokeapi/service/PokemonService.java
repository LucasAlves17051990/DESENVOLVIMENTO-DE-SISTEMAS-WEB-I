package br.com.lince.pokeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.lince.pokeapi.model.Pokemon;
import br.com.lince.pokeapi.model.Validation;
import br.com.lince.pokeapi.repository.PokemonRepository;


@Service
public class PokemonService {
    @Autowired
    private PokemonRepository repository;

    public List<Pokemon> findAll() {
        return repository.findAll();
    }


    public Pokemon save(Pokemon pokemon) throws IllegalArgumentException {
        if (!Validation.titleValidate(pokemon.getName())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 100 caracteres");
        }
        if (!Validation.nameValidate(pokemon.getType())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 50 caracteres");
        }
        if (!Validation.nameValidate(pokemon.getWeight())) {
            throw new IllegalArgumentException(" O título do livro deve conter de 3 à 50 caracteres");
        }
        return repository.save(pokemon);
    }
    
    public Optional<Pokemon> findOne(String name ) {
        return repository.findById(name);
    }
    public void delete(String name) {
        repository.deleteById(name);
    }
}