package br.com.fiap.teste.entity;


import javax.persistence.*;

@Entity
@SequenceGenerator(name = "presidiario",sequenceName = "sq_presidiario")
public class Presidiario {

    @Id
    @GeneratedValue(generator = "presidiario",strategy = GenerationType.SEQUENCE)
    private int presidiarioId;

    @Column(name ="PR_NOME")
    private String Nome;

    @Enumerated(EnumType.STRING)
    @Column(name="PR_ESCOLARIDADE")
    private Escolaridade escolaridade;

    @Column(name = "PR_SAIDINHA")
    private boolean saidinha;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Cela cela;


    public Cela getCela() {
        return cela;
    }

    public void setCela(Cela cela) {
        this.cela = cela;
    }

    public int getPresidiarioId() {
        return presidiarioId;
    }

    public void setPresidiarioId(int presidiarioId) {
        this.presidiarioId = presidiarioId;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isSaidinha() {
        return saidinha;
    }

    public void setSaidinha(boolean saidinha) {
        this.saidinha = saidinha;
    }
}
