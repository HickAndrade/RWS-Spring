package br.com.fiap.teste.controller;


import br.com.fiap.teste.entity.Cela;
import br.com.fiap.teste.repository.CelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Cela")
public class CelaController {
    @Autowired
    private CelaRepository repository;


    @GetMapping("Listar")
    public String Listar(Model model){
        model.addAttribute("celinha",repository.findAll());
        return "listar";
    }

    @GetMapping("Cadastrar")
    public String Cadastrar(){
        return "Cadastrar";
    }

    @PostMapping("Cadastrar")
    public String Cadastrar(Cela cela){
        repository.save(cela);
        return "redirect:/Cela/Listar";

    }

    @GetMapping("Atualizar")
    public String Atualizar(){

        return "Atualizar";
    }

    /**Consigo Atualizar desse jeito?? minha logica é, o GETmapping vai retornar a pagina, e o post vai pegar o ID do objeto CELA*/
    @PostMapping("Atualizar")
    public String Atualizar(int id, Cela cela, Model model){

        model.addAttribute("id",cela.getCelaId());
        repository.save(cela);
        return "redirect:/Cela/Listar";
    }


    /*Se eu fizer o Atualizar, Remover, como botão no template, eu preciso fazer só as action com o a anotation post?*/
    @GetMapping("Remover")
    public String Remover(){

    return "duvida";
    };





}
