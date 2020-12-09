// classe objeto
package EstacionamentoJ;

import java.util.List;

/**
 *
 * @author Logan
 */
public class CarrosBD {
    private String placa;
    private String cor;
    private String descricao;
    
    
    
    //criando construtores

    public CarrosBD() {
    }

    public CarrosBD(String placa, String cor, String descricao) {
        this.placa = placa;
        this.cor = cor;
        this.descricao = descricao;
    }

    //alt ins para gerar getters & setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
