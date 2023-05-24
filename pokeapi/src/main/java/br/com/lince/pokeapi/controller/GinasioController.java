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

import br.com.lince.pokeapi.model.Ginasio;
import br.com.lince.pokeapi.service.GinasioService;

@RestController
@RequestMapping("/api/ginasio")
public class GinasioController {
    @Autowired
    private GinasioService service;
    @GetMapping
    public List<Ginasio> findAll(){
        return service.findAll();
    }
   
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Ginasio ginasio){
        try{
        return new ResponseEntity<>(service.save(ginasio),HttpStatus.CREATED);
       } catch (IllegalArgumentException iae){
        return new ResponseEntity<>(iae.getMessage(),
        HttpStatus.BAD_REQUEST);
       }catch (Exception e) {
        return new ResponseEntity<>("Houve um erro inesperado em nosso sistema, tente novamente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);
        // Gere um log contendo o e.getMessage()
       }
    }
@PutMapping
    public ResponseEntity<Object> edit(@RequestBody Ginasio ginasio){
       try{
        var result = service.findOne(ginasio.getTrainer());
        if(result.isPresent()) {
           return new ResponseEntity<>(service.save(ginasio),
           HttpStatus.CREATED);

        }
        return new ResponseEntity<>("Esse ginásio informado não existe", HttpStatus.NOT_FOUND);
       }catch(IllegalArgumentException iae) {
          return new ResponseEntity<Object>(iae.getMessage(), HttpStatus.BAD_REQUEST);
       }catch(Exception e){
          return new ResponseEntity<>("Houve um erro inesperado em nosso sistema, tente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String trainer) {
       try{
        service.delete(trainer);
        var ginasio = service.findOne(trainer);
        if(ginasio.isEmpty()) {
            return new ResponseEntity<Object>("Ginasio removido com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Erro ao remover o ginásio informado", HttpStatus.GONE);
       }catch(Exception e) {
        return new ResponseEntity<Object>("Houve um erro em nosso sistema, tente novamente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
