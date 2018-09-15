package br.com.rafaelvalentim.agro.Model;

public class UnidadeProdutiva {

    private Long id;
    private String nomeFantasia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String toString(){
        return this.getId() + "- " +  this.getNomeFantasia();
    }
}
