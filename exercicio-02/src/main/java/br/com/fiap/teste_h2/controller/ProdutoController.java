package br.com.fiap.teste_h2.controller;

import br.com.fiap.teste_h2.entity.Produto;
import br.com.fiap.teste_h2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/cadastrar")
    public String Cadastrar(){
        return "produto-home";
    }

    @PostMapping("/cadastrar")
    public String Cadastrado(Produto produto){
        repository.save(produto);
        return "sucesso";
    }
    @GetMapping("/buscar")
    public String Buscando(){
        return "busca";
    }
    @PostMapping("/buscar")
    public String Cadastrado(int codigo, Model model){
       Optional<Produto> produto = repository.findById(codigo);
      model.addAttribute("prod", produto);
        return "buscar";
    }



}
