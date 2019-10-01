package br.com.fiap.teste.resource;


import br.com.fiap.teste.entity.Cela;
import br.com.fiap.teste.entity.Presidiario;
import br.com.fiap.teste.repository.CelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Cela")
public class CelaResource {
    @Autowired
    private CelaRepository repository;

    @GetMapping("listar")
    public List<Cela> Listar(){
    return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cela Cadastrar(@RequestBody Cela cela){
        return repository.save(cela);
    }

    @PutMapping("{id}")
    public Cela Atualizar(@PathVariable int id, @RequestBody Cela cela){
        cela.setCelaId(id);
        return repository.save(cela);
    }

    @DeleteMapping("{codigo}")
    public void Remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }


    @GetMapping("{codigo}")
    public Cela BuscarPorCodigo(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }

    @GetMapping("Nome")
    public List<Cela> BuscarPorNome(@RequestParam String nome){
       return repository.findByNome(nome);
    }

    @GetMapping("Presidiario")
    public List<Cela> BuscarPorPresidiario(@RequestParam List<Presidiario> presidiarios){
    return repository.findByPresidiario(presidiarios);

    }
}
