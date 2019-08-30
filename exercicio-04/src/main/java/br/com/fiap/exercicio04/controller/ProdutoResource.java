package br.com.fiap.exercicio04.controller;


import br.com.fiap.exercicio04.entity.Produto;
import br.com.fiap.exercicio04.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository repository;

  @GetMapping("pesquisar")
    public String abrirPesquisa() {
        return "pesquisa";
    }

    @PostMapping("pesquisar")
    public String processarForm(String nome, Model model) {
        List<Produto> produtos = repository.findByNome(nome);
        model.addAttribute("prod", produtos);
        return "sucesso";
    }



    @GetMapping("cadastrar")
    public String abrirFormulario(){
        return "cadastro";
    }

    @PostMapping("cadastrar")
    public String abrirCadastro(Produto produto, Model model){
        repository.save(produto);
        model.addAttribute("produto",produto);
        return "sucesso";
    }

}
