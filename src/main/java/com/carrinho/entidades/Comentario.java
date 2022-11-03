package com.carrinho.entidades;

public class Comentario {
    private int idcomentario;
    private String conteudocomentario;
    private int aceito;
    private int idartigo;

    public Comentario() {
    }

    public Comentario(String conteudocomentario, int idartigo) {
        this.conteudocomentario = conteudocomentario;
        this.idartigo = idartigo;
    }

    public Comentario(int idcomentario, String conteudocomentario, int aceito, int idartigo) {
        this.idcomentario = idcomentario;
        this.conteudocomentario = conteudocomentario;
        this.aceito = aceito;
        this.idartigo = idartigo;
    }

    public int getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getConteudocomentario() {
        return conteudocomentario;
    }

    public void setConteudocomentario(String conteudocomentario) {
        this.conteudocomentario = conteudocomentario;
    }

    public int getAceito() {
        return aceito;
    }

    public void setAceito(int aceito) {
        this.aceito = aceito;
    }

    public int getIdartigo() {
        return idartigo;
    }

    public void setIdartigo(int idartigo) {
        this.idartigo = idartigo;
    }
}
