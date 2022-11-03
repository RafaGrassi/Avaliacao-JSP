package com.carrinho.dao;

import com.carrinho.entidades.Artigo;
import com.carrinho.utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoArtigo {
    public static List<Artigo> artigos = new ArrayList<Artigo>();

    public static String salvar(Artigo arti){
        Connection con = Conexao.conectar();
        if(con != null){
            String sql = "insert into artigo(tituloartigo,conteudoartigo)" +
                    "values(?,?)";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1,arti.getTituloartigo());
                stm.setString(2,arti.getConteudoartigo());

                stm.execute();

            } catch (SQLException e) {
                return "Erro: " + e.getMessage();
            }
            return "Registro inserido com sucesso";
        }
        return "erro de conexão";
    }

    public static List<Artigo> consultar(){
        List<Artigo> lista = new ArrayList<Artigo>();
        Connection con = Conexao.conectar();
        if(con != null) {
            try {
                PreparedStatement stm = con.prepareStatement("select * from artigo");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Artigo p = new Artigo();
                    p.setIdartigo(rs.getInt("idartigo"));
                    p.setTituloartigo(rs.getString("tituloartigo"));
                    p.setConteudoartigo(rs.getString("conteudoartigo"));
                    lista.add(p);
                }
            } catch (SQLException e) {
                return lista;
            }
        }
        return lista;
    }

    public static Artigo consultar(int idartigo){
        Connection con = Conexao.conectar();
        Artigo p = new Artigo();
        if(con != null){
            try {
                PreparedStatement stm = con.prepareStatement("select * from artigo where idartigo = ?");
                stm.setInt(1,idartigo);
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    p.setIdartigo(rs.getInt("idartigo"));
                    p.setTituloartigo(rs.getString("tituloartigo"));
                    p.setConteudoartigo(rs.getString("conteudoartigo"));
                }
            } catch (SQLException e) {
                return p;
            }
        }
        return p;
    }

    public static void excluir(int idartigo){
        Connection con = Conexao.conectar();
        if(con != null){
            String sql = "delete from artigo where idartigo = ?";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1,idartigo);
                stm.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String alterar(Artigo p){
        Connection con = Conexao.conectar();
        if(con != null){
            String sql = "update artigo set "+
                    "tituloartigo = ?, conteudoartigo = ? "+
                    " where idartigo = ?";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, p.getTituloartigo());
                stm.setString(2, p.getConteudoartigo());
                stm.setInt(3, p.getIdartigo());
                stm.execute();
                return "Registro alterado com sucesso.";
            } catch (SQLException e) {
                return "Não foi possivel alterar registro";
            }
        }
        return "erro de conexão";
    }

}
