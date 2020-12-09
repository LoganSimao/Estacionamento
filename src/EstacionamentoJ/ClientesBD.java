/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionamentoJ;

/**
 *
 * @author Logan
 */
public class ClientesBD {
    private int ID;
    private String CPF;
    private String nome;
    private String sobrenome;
    private String email;
    private String rua;
    private String cidade;
    private String celular;

    public ClientesBD(String CPF, String nome, String sobrenome, String email, String rua, String cidade, String celular) {
        this.CPF = CPF;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.rua = rua;
        this.cidade = cidade;
        this.celular = celular;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    public int getID(){
        return ID;
    }
    public ClientesBD() {
    }
}
