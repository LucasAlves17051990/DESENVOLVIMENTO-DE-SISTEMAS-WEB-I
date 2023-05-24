package br.com.lince.pokeapi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lince.pokeapi.model.Ginasio;

@Repository
public interface GinasioRepository extends JpaRepository<Ginasio,String>{
    
}
