package EstacionamentoJ;

import java.sql.*;
import java.util.List;

/**
 *
 * @author Logan
 */
public class Estacionamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = Conn.open();
        // instanciando
        CarrosBD cbd = new CarrosBD();
        CarrosM cm = new CarrosM(con);
         /*
        //inserindo valores na tabela
        cbd.setPlaca("668FHNM");
        cbd.setCor("Vermelho");
        cbd.setDescricao("Jetta");
        System.out.println(cm.insCarro(cbd));
        
       
        //alterar(nao funcionando ainda)
        cbd.setPlaca("345S4HG");
        cbd.setCor("Azul");
        cbd.setDescricao("Golfao");
        
        cm.altcarro(cbd);
        System.out.println(cm.altcarro(cbd));
        
        
        */
         
         List<CarrosBD> lista = cm.listarTudo();
         
         if (lista != null){
             for (CarrosBD carro: lista){
                 System.out.println("Placa: " + carro.getPlaca());
                 System.out.println("Cor: " + carro.getCor());
                 System.out.println("Descrição: " + carro.getDescricao());
                 System.out.println(" ");
             }
         }else{
             System.out.println("Erro ao mostrar");
         }
        
        
    }
    
}
