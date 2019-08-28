package br.com.hickandrade.teste.controller;


import br.com.hickandrade.teste.entity.Animal;
import br.com.hickandrade.teste.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("animal")
public class AnimalResource {

    @Autowired
    private AnimalRepository repository;

    @GetMapping
    public List<Animal> lista(){return repository.findAll();}

    @GetMapping("{id}")
    public Animal consultar(@PathVariable int id){
        return repository.findById(id).get();
    }

    /* o ResponseBody seria para usar em alguma action do controller? para requisitar um template*/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Animal cadastrar(@RequestBody Animal animal){
        return repository.save(animal);
    }

    @PutMapping("{id}")
    public Animal atualizar(@RequestBody Animal animal ,@PathVariable int id){
        animal.setId(id);
        return repository.save(animal);
    }

    @DeleteMapping("{id}")
    public void deletar( @PathVariable int id){
        repository.deleteById(id);
    }

}
