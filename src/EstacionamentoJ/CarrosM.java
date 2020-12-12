//classe acess dados(sql+java)
package EstacionamentoJ;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Logan
 */
public class CarrosM {

    private Connection con;

    //construtor
    public CarrosM(Connection con) {
        this.con = con;
    }
    //getter setters

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String insCarro(CarrosBD cars) {
        String sql = "insert into carros(placa,cor,descricao) values(?,?,?)";

        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            //inserir valores a tb carros com getters
            prepare.setString(1, cars.getPlaca());
            prepare.setString(2, cars.getCor());
            prepare.setString(3, cars.getDescricao());

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
    public String altcarro(CarrosBD cars){
        String sql = "update carros set cor = ?, descricao = ? where placa = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
            
            prepare.setString(1, cars.getCor());
            prepare.setString(2, cars.getDescricao());
            prepare.setString(3, cars.getPlaca());
            
            if(prepare.executeUpdate() > 0){
            return "Alterado com sucesso!";
            
            }else{
            return "Erro ao alterar!(dados infuficientes)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    //excluir dados
    public String exCarro(CarrosBD cars){
        String sql = "delete from carros where placa = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
            
            /*prepare.setString(1, cars.getCor());
            prepare.setString(2, cars.getDescricao());*/
            prepare.setString(1, cars.getPlaca()); 
            
            if(prepare.executeUpdate() > 0){
            return "Deletado com sucesso!";
            }else{
            return "Erro ao deletar(placa inválida)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    
    //criação de select
    public List<CarrosBD> listarTudo(){
        String sql ="select * from carros";
        //criação de vetor/matriz
        List<CarrosBD> listCars =  new ArrayList<>();
        
        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            if(rs != null){
                while(rs.next()){
                CarrosBD cB = new CarrosBD();
                cB.setPlaca(rs.getString(1));
                cB.setCor(rs.getString(2));
                cB.setDescricao(rs.getString(3));
                
                listCars.add(cB);
                }
                return listCars;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
}

//37 min aula
