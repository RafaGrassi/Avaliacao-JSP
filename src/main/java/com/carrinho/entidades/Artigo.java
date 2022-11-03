package com.carrinho.entidades;

public class Artigo {
    private int idartigo;
    private String tituloartigo;
    private String conteudoartigo;

    public Artigo() {
    }

    public Artigo(String tituloartigo, String conteudoartigo) {
        this.tituloartigo = tituloartigo;
        this.conteudoartigo = conteudoartigo;
    }

    public Artigo(int idartigo, String tituloartigo, String conteudoartigo) {
        this.idartigo = idartigo;
        this.tituloartigo = tituloartigo;
        this.conteudoartigo = conteudoartigo;
    }

    public int getIdartigo() {
        return idartigo;
    }

    public void setIdartigo(int idartigo) {
        this.idartigo = idartigo;
    }

    public String getTituloartigo() {
        return tituloartigo;
    }

    public void setTituloartigo(String tituloartigo) {
        this.tituloartigo = tituloartigo;
    }

    public String getConteudoartigo() {
        return conteudoartigo;
    }

    public void setConteudoartigo(String conteudoartigo) {
        this.conteudoartigo = conteudoartigo;
    }
}
