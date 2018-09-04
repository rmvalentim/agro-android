package br.com.rafaelvalentim.agro.Model;

public class ApontamentoAPI {

    private long boletimId;

    private long culturaId;

    private long talhaoId;

    private long operacaoAgricolaId;

    private long operadorPrincipalId;

    private long operadorAjudanteId;

    private long equipamentoPrincipalId;

    private long equipamentoApoioId;

    private long produtoId;

    private double quantidadeProduto;

    private double hectaresTrabalhados;

    private double horasEquipamentos;

    private double horasOperadores;


    public long getBoletimId() {
        return boletimId;
    }

    public void setBoletimId(long boletimId) {
        this.boletimId = boletimId;
    }

    public long getCulturaId() {
        return culturaId;
    }

    public void setCulturaId(long culturaId) {
        this.culturaId = culturaId;
    }

    public long getTalhaoId() {
        return talhaoId;
    }

    public void setTalhaoId(long talhaoId) {
        this.talhaoId = talhaoId;
    }

    public long getOperacaoAgricolaId() {
        return operacaoAgricolaId;
    }

    public void setOperacaoAgricolaId(long operacaoAgricolaId) {
        this.operacaoAgricolaId = operacaoAgricolaId;
    }

    public long getOperadorPrincipalId() {
        return operadorPrincipalId;
    }

    public void setOperadorPrincipalId(long operadorPrincipalId) {
        this.operadorPrincipalId = operadorPrincipalId;
    }

    public long getOperadorAjudanteId() {
        return operadorAjudanteId;
    }

    public void setOperadorAjudanteId(long operadorAjudanteId) {
        this.operadorAjudanteId = operadorAjudanteId;
    }

    public long getEquipamentoPrincipalId() {
        return equipamentoPrincipalId;
    }

    public void setEquipamentoPrincipalId(long equipamentoPrincipalId) {
        this.equipamentoPrincipalId = equipamentoPrincipalId;
    }

    public long getEquipamentoApoioId() {
        return equipamentoApoioId;
    }

    public void setEquipamentoApoioId(long equipamentoApoioId) {
        this.equipamentoApoioId = equipamentoApoioId;
    }

    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    public double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getHectaresTrabalhados() {
        return hectaresTrabalhados;
    }

    public void setHectaresTrabalhados(double hectaresTrabalhados) {
        this.hectaresTrabalhados = hectaresTrabalhados;
    }

    public double getHorasEquipamentos() {
        return horasEquipamentos;
    }

    public void setHorasEquipamentos(double horasEquipamentos) {
        this.horasEquipamentos = horasEquipamentos;
    }

    public double getHorasOperadores() {
        return horasOperadores;
    }

    public void setHorasOperadores(double horasOperadores) {
        this.horasOperadores = horasOperadores;
    }
}
