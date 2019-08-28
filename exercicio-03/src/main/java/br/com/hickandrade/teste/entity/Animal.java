package br.com.hickandrade.teste.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="animal",sequenceName = "SQ_ANIMAL")
public class Animal {

    @Id
    @GeneratedValue(generator = "animal",strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private boolean velho;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isVelho() {
        return velho;
    }

    public void setVelho(boolean velho) {
        this.velho = velho;
    }
}
