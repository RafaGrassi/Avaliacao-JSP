package com.carrinho.dao;

import com.carrinho.entidades.Comentario;
import com.carrinho.entidades.Usuario;
import com.carrinho.utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {
    public static List<Usuario> usuarios = new ArrayList<Usuario>();

    public static String salvar(Usuario usu){
        Connection con = Conexao.conectar();
        if(con != null){
            String sql = "insert into usuario(email,senha,tipo)" +
                    "values(?,?,?)";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1,usu.getEmail());
                stm.setString(2,usu.getSenha());
                stm.setInt(3,0);

                stm.execute();

            } catch (SQLException e) {
                return "Erro: " + e.getMessage();
            }
            return "Usuario criado com sucesso";
        }
        return "erro de conexão";
    }

    public static Boolean autentificar(String email, String senha){
        Connection con = Conexao.conectar();
        Usuario p = new Usuario();
        if(con != null){
            try {
                PreparedStatement stm = con.prepareStatement("select * from usuario where email = ? and senha = ?");
                stm.setString(1,email);
                stm.setString(2,senha);
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    p.setEmail(rs.getString("email"));
                    if (p.getEmail() != "") {
                        return true;
                    }
                }
            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }

    public static Boolean administrador(String email, String senha){
        Connection con = Conexao.conectar();
        Usuario p = new Usuario();
        if(con != null){
            try {
                PreparedStatement stm = con.prepareStatement("select * from usuario where email = ? and senha = ? and tipo = 1");
                stm.setString(1,email);
                stm.setString(2,senha);
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    p.setEmail(rs.getString("email"));
                    if (p.getEmail() != "") {
                        return true;
                    }
                }
            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }





}
