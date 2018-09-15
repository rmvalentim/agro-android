package br.com.rafaelvalentim.agro.Model;

public class BoletimAPI {

    private long unidadeProdutivaId;

    private long safraId;

    private String observacao;


    public long getSafraId() {
        return safraId;
    }

    public void setSafraId(long safraId) {
        this.safraId = safraId;
    }


    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public long getUnidadeProdutivaId() {
        return unidadeProdutivaId;
    }

    public void setUnidadeProdutivaId(long unidadeProdutivaId) {
        this.unidadeProdutivaId = unidadeProdutivaId;
    }
}
