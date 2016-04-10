/*
 * Classe: Tipo de Plano
 * Atributos: intCodigo, strDescricao, dblValorMensal, intFranquia, dblValorChamada
 * Métodos: get e set para todos os atributos;
 */
package Alo;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */
public class TipoPlano {
    //Declaracao de atributos
    private int intCodigo, intFranquia;
    private double dblValorMensal, dblValorChamada;
    private String strDescricao;
    
    //Metodos get e set
    public int getIntCodigo() {
        return intCodigo;
    }

    public void setIntCodigo(int intCodigo) {
        this.intCodigo = intCodigo;
    }

    public int getIntFranquia() {
        return intFranquia;
    }

    public void setIntFranquia(int intFranquia) {
        this.intFranquia = intFranquia;
    }

    public double getDblValorMensal() {
        return dblValorMensal;
    }

    public void setDblValorMensal(double dblValorMensal) {
        this.dblValorMensal = dblValorMensal;
    }

    public double getDblValorChamada() {
        return dblValorChamada;
    }

    public void setDblValorChamada(double dblValorChamada) {
        this.dblValorChamada = dblValorChamada;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }
}
