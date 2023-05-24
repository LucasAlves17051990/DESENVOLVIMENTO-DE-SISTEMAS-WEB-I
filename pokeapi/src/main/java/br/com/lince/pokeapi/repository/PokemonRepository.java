package br.com.lince.pokeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lince.pokeapi.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,String>{
    
}

