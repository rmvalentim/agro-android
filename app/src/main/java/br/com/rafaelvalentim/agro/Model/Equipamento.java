package br.com.rafaelvalentim.agro.Model;

public class Equipamento {

    private Long id;

    private String descricao;
    private String marca;
    private String modelo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String toString(){
        return ( this.getId() + "- " + this.getDescricao() + " " + this.getMarca() + " " + this.getModelo());
    }
}
