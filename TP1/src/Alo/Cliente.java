/*
 * Classe: Cliente
 * Atributos: strCPF, strNome, strEndereco
 * Métodos: get e set para todos os atributos;
 */
package Alo;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */
public class Cliente {
    //Declaracao de atributos
    /**
     * @param strCPF = CPF do cliente
     * @param strNome = Nome do cliente
     * @param strEndereco = Endereço do cliente
     */
    private String strCPF, strNome, strEndereco;
    
    //Metodos get e set
    public String getStrCPF() {
        return strCPF;
    }

    public void setStrCPF(String strCPF) {
        this.strCPF = strCPF;
    }

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrEndereco() {
        return strEndereco;
    }

    public void setStrEndereco(String strEndereco) {
        this.strEndereco = strEndereco;
    }
}
