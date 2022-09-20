package br.com.fiap.exercicio05.rest;


import br.com.fiap.exercicio05.entity.Produto;
import br.com.fiap.exercicio05.repository.ProdutoRepository;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoRest {

   @Autowired
    private ProdutoRepository repository;

   @GetMapping
    public List<Produto> lista(){
       return repository.findAll();

   }

   @GetMapping("pesquisa")
    public List<Produto> procurarPorNome(@RequestParam String nome){
       return repository.findByNome(nome);
   }

   @GetMapping("{codigo}")
    public Produto buscarPorCodigo(@PathVariable int codigo){
       return repository.findById(codigo).get();
   }
   @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
       return repository.save(produto);

   }

   @PutMapping("{id}")
   public Produto atualizar(@RequestBody Produto produto, @PathVariable int id){
       produto.setCodigo(id);

       return repository.save(produto);
   }



    @DeleteMapping("{codigo}")
    public void deletar(@PathVariable int id){

       repository.deleteById(id);

    }
}
