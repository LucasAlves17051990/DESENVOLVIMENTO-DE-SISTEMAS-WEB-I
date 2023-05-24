package br.com.lince.pokeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lince.pokeapi.model.Treinador;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador,String>{
    
}
