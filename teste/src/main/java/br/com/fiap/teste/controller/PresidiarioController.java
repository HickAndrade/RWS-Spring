package br.com.fiap.teste.controller;


import br.com.fiap.teste.entity.Presidiario;
import br.com.fiap.teste.repository.PresidiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Presidiario")
public class PresidiarioController {

    @Autowired
    private PresidiarioRepository repository;

    @GetMapping("/listar")
    public String Listar(Model model){
    model.addAttribute("presidiario",repository.findAll());

        return "listar";
    }

    /**registrar**/
    @GetMapping("/cadastrar")
    public String Cadastrar(Model model, Presidiario presidiario){

        return"cadastrar";
    }

    @PostMapping("/cadastrar")
    public String Cadastrar(Presidiario presidiario){
        repository.save(presidiario);
        return "listar";
    }
    /**Atualizar**/









}
