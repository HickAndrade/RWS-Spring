package br.com.fiap.teste.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "cela",sequenceName = "sq_cela")
public class Cela {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cela")
    private int celaId;
    private String nome;
    private int quantidade;
    private List<Presidiario> presidiarios;


    public int getCelaId() {
        return celaId;
    }

    public void setCelaId(int celaId) {
        this.celaId = celaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Presidiario> getPresidiarios() {
        return presidiarios;
    }

    public void setPresidiarios(List<Presidiario> presidiarios) {
        this.presidiarios = presidiarios;
    }
}
