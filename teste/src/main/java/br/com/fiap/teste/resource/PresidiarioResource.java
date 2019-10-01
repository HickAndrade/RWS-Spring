package br.com.fiap.teste.resource;


import br.com.fiap.teste.entity.Presidiario;
import br.com.fiap.teste.repository.PresidiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Presidiario")
public class PresidiarioResource {

    @Autowired
    private PresidiarioRepository repository;

    @GetMapping("Listar")
    public List<Presidiario> Listar(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Presidiario Cadastrar(@RequestBody Presidiario presidiario){
        return repository.save(presidiario);
    }

    @PutMapping("{id}")
    public Presidiario Atualizar(@RequestBody Presidiario presidiario, @PathVariable int id){
        presidiario.setPresidiarioId(id);
        return repository.save(presidiario);

    }

    @DeleteMapping("{codigo}")
    public void Deletar(@PathVariable int codigo){
        repository.deleteById(codigo);
    }


    @GetMapping("Nome")
    public List<Presidiario> BuscarPorNome(@RequestParam String nome){
        return repository.findByNome(nome);

    }
/**Bùscar por ID não tem retorno de lista porque é obvio, não existe mais de um dado que se repete quando a busca é por ID, Já
 * NOME , o retorno pode ser com lista*/
    @GetMapping("{codigo}")
    public Presidiario BuscarPorId(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }


}
