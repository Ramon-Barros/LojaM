package com.ramon.rest;

import com.ramon.model.enity.Cliente;
import com.ramon.model.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente  salvar( @RequestBody Cliente cliente ){
        return repository.save(cliente);

    }

    @GetMapping("{id}")
    public Cliente acharPorId( @PathVariable Integer id ){
                                                              // para lançar um erro de status
        return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id ){
        
            repository.findById(id).map( cliente -> {
                repository.delete(cliente);
                return Void.TYPE;
            }).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    
}
