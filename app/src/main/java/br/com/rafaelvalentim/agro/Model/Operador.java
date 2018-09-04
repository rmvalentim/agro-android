package br.com.rafaelvalentim.agro.Model;

public class Operador {

    private Long id;
    private String nomeCompleto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String toString(){
        return this.getId() + "- " +  this.getNomeCompleto();
    }
}
