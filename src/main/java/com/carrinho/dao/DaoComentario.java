package com.carrinho.dao;

import com.carrinho.entidades.Artigo;
import com.carrinho.entidades.Comentario;
import com.carrinho.utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoComentario {
    public static List<Comentario> comentarios = new ArrayList<Comentario>();

    public static String salvar(Comentario comen){
        Connection con = Conexao.conectar();
        if(con != null){
            String sql = "insert into comentario(conteudocomentario,aceito,idartigo)" +
                    "values(?,?,?)";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1,comen.getConteudocomentario());
                stm.setInt(2,0);
                stm.setInt(3,comen.getIdartigo());

                stm.execute();

            } catch (SQLException e) {
                return "Erro: " + e.getMessage();
            }
            return "Registro inserido com sucesso";
        }
        return "erro de conexão";
    }

    public static List<Comentario> consultarTodos(){
        List<Comentario> lista = new ArrayList<Comentario>();
        Connection con = Conexao.conectar();
        if(con != null) {
            try {
                PreparedStatement stm = con.prepareStatement("select * from comentario");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Comentario p = new Comentario();
                    p.setIdcomentario(rs.getInt("idcomentario"));
                    p.setConteudocomentario(rs.getString("conteudocomentario"));
                    p.setAceito(rs.getInt("aceito"));
                    p.setIdartigo(rs.getInt("idartigo"));
                    lista.add(p);
                }
            } catch (SQLException e) {
                return lista;
            }
        }
        return lista;
    }

    public static List<Comentario> consultarPorArtigo(int idartigo){
        List<Comentario> lista = new ArrayList<Comentario>();
        Connection con = Conexao.conectar();
        if(con != null) {
            try {
                PreparedStatement stm = con.prepareStatement("select * from comentario where idartigo = ?");
                stm.setInt(1,idartigo);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Comentario p = new Comentario();
                    p.setIdcomentario(rs.getInt("idcomentario"));
                    p.setConteudocomentario(rs.getString("conteudocomentario"));
                    p.setAceito(rs.getInt("aceito"));
                    p.setIdartigo(rs.getInt("idartigo"));
                    lista.add(p);
                }
            } catch (SQLException e) {
                return lista;
            }
        }
        return lista;
    }


    public static Comentario consultar(int idcomentario){
        Connection con = Conexao.conectar();
        Comentario p = new Comentario();
        if(con != null){
            try {
                PreparedStatement stm = con.prepareStatement("select * from comentario where idcomentario = ?");
                stm.setInt(1,idcomentario);
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    p.setIdcomentario(rs.getInt("idcomentario"));
                    p.setConteudocomentario(rs.getString("conteudocomentario"));
                    p.setAceito(rs.getInt("aceito"));
                    p.setIdartigo(rs.getInt("idartigo"));
                }
            } catch (SQLException e) {
                return p;
            }
        }
        return p;
    }


    public static void aceitar(int idcomentario){
        Connection con = Conexao.conectar();
        if(con != null){
            String sql = "update comentario set aceito = ? where idcomentario = ?";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1, 1);
                stm.setInt(2,idcomentario);
                stm.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
