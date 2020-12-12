/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionamentoJ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Logan
 */
public class ClientesM {
    private Connection con;

    //construtor
    public ClientesM(Connection con) {
        this.con = con;
    }
    //getter setters

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String insCliente(ClientesBD clients) {
        String sql = "insert into usuarios(CPF,nome,email,login,senha,privilegio,celular) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            //inserir valores a tb carros com getters
            prepare.setString(1, clients.getCPF());
            prepare.setString(2, clients.getNome());
            prepare.setString(3, clients.getEmail());
            prepare.setString(4, clients.getLogin());
            prepare.setString(5, clients.getSenha());
            prepare.setString(6, clients.getPrivilegio());
            prepare.setString(7, clients.getCelular());

            if (prepare.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir carro!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    //alterar dados
    public String altClientes(ClientesBD clients){
        String sql = "update usuarios set nome = ?, email = ?,login = ?, senha = ?, privilegio = ?, celular = ?  where CPF = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
           
            prepare.setString(1, clients.getNome());
            prepare.setString(2, clients.getEmail());
            prepare.setString(3, clients.getLogin());
            prepare.setString(4, clients.getSenha());
            prepare.setString(5, clients.getPrivilegio());
            prepare.setString(6, clients.getCelular());
            prepare.setString(7, clients.getCPF());
            
            if(prepare.executeUpdate() > 0){
            return "Alterado com sucesso!";
            
            }else{
            return "Erro ao alterar!(CPF Inválido)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    //excluir dados
    public String exCliente(ClientesBD clients){
        String sql = "delete from usuarios where CPF = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
           
            prepare.setString(1, clients.getCPF());
            
            if(prepare.executeUpdate() > 0){
            return "Deletado com sucesso!";
            }else{
            return "Erro ao deletar!(CPF invalido)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    
    //criação de select
    public List<ClientesBD> listarTudo(){
        String sql ="select * from usuarios";
        //criação de vetor/matriz
        List<ClientesBD> listClients =  new ArrayList<>();
        
        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            if(rs != null){
                while(rs.next()){
                ClientesBD cB = new ClientesBD();
                cB.setID(rs.getInt(1));
                cB.setCPF(rs.getString(2));
                cB.setNome(rs.getString(3));
                cB.setEmail(rs.getString(4));
                cB.setLogin(rs.getString(5));
                cB.setSenha(rs.getString(6));
                cB.setPrivilegio(rs.getString(7));
                cB.setCelular(rs.getString(8));
                
                listClients.add(cB);
                }
                return listClients;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public String verificarLogin(ClientesBD login){
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
       // String sql2 = "SELECT privilegio FROM usuarios WHERE login = ? AND senha = ?";
        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            
            prepare.setString(1, login.getLogin());
            prepare.setString(2, login.getSenha());
            
            //PreparedStatement prepare2 = getCon().prepareStatement(sql2);
            //prepare2.setString(1, login.getPrivilegio());
            //prepare.setString(3, login.getPrivilegio());
            ResultSet rs = prepare.executeQuery();
            //ResultSet ss = prepare.executeQuery(sql2);
            if(rs.next()){
                //String log;
                //LoginBD bd = new LoginBD();
                //Boolean valor = true;
                login.setPrivilegio(rs.getString(7));
                //login.setLogin(rs.getString(2));
                //login.setSenha(rs.getString(3));
                login.setCheckagem("logado");
                
                
                
                //log.setVisible(false);
                
                return "";
            }else{
            return "Erro ao entrar!";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    
}
