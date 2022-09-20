package br.com.fiap.exercicio05.controller;


import br.com.fiap.exercicio05.entity.Produto;
import br.com.fiap.exercicio05.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*não tá cadastrando o valor, só o nome e se é novo, a data e o preço não vai*/

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

/**Lista dos produtos cadastrados**/


   @GetMapping("listar")
    public String listar( Model model) {
       model.addAttribute("produtos",repository.findAll());
        return "objeto";
    }



    /**========================================REGISTER===================================**/
    @GetMapping("cadastrar")
    public String cadastrar(Produto produto,Model model) {
        model.addAttribute("prod", produto);
        return "cadastrar";
    }

    @PostMapping("cadastrar")
    public String ProcessandoForm(Produto produto){
        repository.save(produto);
        return "redirect:/produto/listar";
    }




    /**========================================FIND_BY_NAME=======================================**/

    @GetMapping("bnome")
    public String buscarporNome(){
    return "buscar";
    }

    @PostMapping("bnome")
    public String buscarPorNome(String nome, Model model){
        List<Produto> produtos = repository.findByNome(nome);
        model.addAttribute("prod",produtos);
        return"Lista";
    }
/**=============================================FIND_BY_CODE===================================**/

    @GetMapping("bpc")
    public String buscarPorCodigo(){
    return "buscar";
    }

    @PostMapping("codigo")
    public String buscarPorCodigo(int codigo, Model model){
        List<Produto> produtos = repository.findByCodigo(codigo);
        model.addAttribute("prod", produtos);
        return "Lista";
    }

/**====================================FIND_BY_NAME_AND_NEW======================================**/


    @GetMapping("bnn")
    public String BuscarPorNomeAndNovo(){
        return"buscar";
    }

    @PostMapping("bnn")
    public String BuscarPorNomeAndNovo(String nome, boolean novo, Model model){
    List<Produto> produtos = repository.findByNomeAndNovo(nome,novo);
    model.addAttribute("prod",produtos);
    return"Lista";
    }

    /**====================================FIND_BY_PRICE_GREATER_THAN======================================**/

    @GetMapping("bpp")
    public String BuscarPorMaiorPreco(){
        return "buscar";
    }

    @PostMapping("bpp")
    public String BuscarPorMaiorPreco(Double preco, Model model){
        List<Produto> produtos = repository.findByPrecoGreaterThan(preco);
        model.addAttribute("prod",produtos);
    return "Lista";
    }
    /**====================================FIND_BY_NOVO_ORDER_BY_NOME======================================**/

    @GetMapping("procurarNovo")
    public String ProcurarPorNovoNomeDesc() {
        return "buscar";

    }
        @PostMapping("procurarNovo")
        public String ProcurarPorNovoNomeDesc(boolean novo, Model model) {
        List<Produto> produtos = repository.findByNovoOrderByNome(novo);
        model.addAttribute("prod", produtos);

            return "Lista";
        }

    /**====================================FIND_BY_NOME_IGNORE_CASE_ORDER_BY_PRECO_ASC======================================**/
     @GetMapping("procurarNomeCase")
    public String ProcurarNomeIgnoreCaseOrderByPrecoAsc(){
         return "buscar";
     }

     @PostMapping("procurarNomeCase")
    public String ProcurarNomeIgnoreCaseOrderByPrecoAsc(String nome, Double preco, Model model){
         List<Produto> produtos = repository.findByNomeIgnoreCaseOrderByPrecoAsc(nome);
         model.addAttribute("prod" ,produtos);
        return "buscar";
    }

    }
