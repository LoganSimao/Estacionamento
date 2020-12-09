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
        String sql = "insert into clientes(CPF,nome,sobrenome,email,rua,cidade,celular) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            //inserir valores a tb carros com getters
            prepare.setString(1, clients.getCPF());
            prepare.setString(2, clients.getNome());
            prepare.setString(3, clients.getSobrenome());
            prepare.setString(4, clients.getEmail());
            prepare.setString(5, clients.getRua());
            prepare.setString(6, clients.getCidade());
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
        String sql = "update clientes set nome = ?, sobrenome = ?,email = ?, rua = ?, cidade = ?, celular = ?  where CPF = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
           
            prepare.setString(1, clients.getNome());
            prepare.setString(2, clients.getSobrenome());
            prepare.setString(3, clients.getEmail());
            prepare.setString(4, clients.getRua());
            prepare.setString(5, clients.getCidade());
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
        String sql = "delete from clientes where CPF = ?";
        
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
        String sql ="select * from clientes";
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
                cB.setSobrenome(rs.getString(4));
                cB.setEmail(rs.getString(5));
                cB.setRua(rs.getString(6));
                cB.setCidade(rs.getString(7));
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
    
}
