package br.com.lince.pokeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;

import br.com.lince.pokeapi.model.Pokemon;
import br.com.lince.pokeapi.service.PokemonService;


@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService service;
    @GetMapping
    public List<Pokemon> findAll(){
        return service.findAll();
    }
   
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Pokemon pokemon){
        try{
        return new ResponseEntity<>(service.save(pokemon),HttpStatus.CREATED);
       } catch (IllegalArgumentException iae){
        return new ResponseEntity<>(iae.getMessage(),
        HttpStatus.BAD_REQUEST);
       }catch (Exception e) {
        return new ResponseEntity<>("Houve um erro inesperado em nosso sistema, tente novamente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);
        // Gere um log contendo o e.getMessage()
       }
    }
@PutMapping
    public ResponseEntity<Object> edit(@RequestBody Pokemon pokemon){
       try{
        var result = service.findOne(pokemon.getName());
        if(result.isPresent()) {
           return new ResponseEntity<>(service.save(pokemon),
           HttpStatus.CREATED);

        }
        return new ResponseEntity<>("O pokemon informado não existe", HttpStatus.NOT_FOUND);
       }catch(IllegalArgumentException iae) {
          return new ResponseEntity<Object>(iae.getMessage(), HttpStatus.BAD_REQUEST);
       }catch(Exception e){
          return new ResponseEntity<>("Houve um erro inesperado em nosso sistema, tente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String name) {
       try{
        service.delete(name);
        var pokemon = service.findOne(name);
        if(pokemon.isEmpty()) {
            return new ResponseEntity<Object>("Esse pokemon foi removido com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Erro ao remover o pokemon informado", HttpStatus.GONE);
       }catch(Exception e) {
        return new ResponseEntity<Object>("Houve um erro em nosso sistema, tente novamente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
