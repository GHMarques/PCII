/*
 * Classe: Numero de Telefone
 * Atributos: intNumero, cltCliente, tpPlano, dtAtivacao, dtCancelamento, intDiaPagamento
 * Métodos públicos: 
 *                   get e set para todos os atributos;
 *                   boolean setIntDiaPagamento(int intDiaPagamento);
 *                   boolean setDtCancelamento(Date dtCancelamento);
 *                   boolean VerificaNumeroAtivo();
 *Métodos protegidos: 
 *                   String RetornaData(Date dtData);
 *                   Date SetData(String strData);
 *                   
 */
package Alo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */

public class NumeroTelefone {
    /**
     *
     * @param intNumero = Número de telefone
     * @param intDiaPagamento = dia do pagamento da fatura, deve ser um dos seguintes dias do mês: 1, 5, 10 ou 15
     * @param dtAtivacao = Data de ativação
     * @param dtCancelamento = Data de Cancelamento
     */
    //Declaracao de atributos
    private int intNumero, intDiaPagamento;
    private Cliente cltCliente = new Cliente();
    private TipoPlano tdPlano = new TipoPlano();
    private Date dtAtivacao, dtCancelamento;

    //Construtores
    public NumeroTelefone(int intNumero, int intDiaPagamento, Date dtAtivacao, Date dtCancelamento) {
        this.intNumero = intNumero;
        this.intDiaPagamento = intDiaPagamento;
        this.dtAtivacao = dtAtivacao;
        this.dtCancelamento = dtCancelamento;
    }
    //Data de cancelamento é opcional
    public NumeroTelefone(int intNumero, int intDiaPagamento, Date dtAtivacao) {
        this.intNumero = intNumero;
        this.intDiaPagamento = intDiaPagamento;
        this.dtAtivacao = dtAtivacao;
    }

    public NumeroTelefone() {}
    
    //Metodos get e set padrão
    public int getIntNumero() {
        return intNumero;
    }

    public void setIntNumero(int intNumero) {
        this.intNumero = intNumero;
    }
    
    public int getIntDiaPagamento() {
        return intDiaPagamento;
    }

    public Cliente getCltCliente() {
        return cltCliente;
    }

    public void setCltCliente(Cliente cltCliente) {
        this.cltCliente = cltCliente;
    }

    public TipoPlano getTdPlano() {
        return tdPlano;
    }

    public void setTdPlano(TipoPlano tdPlano) {
        this.tdPlano = tdPlano;
    }
    
    //Métodos get e set modificados
    /**
     * @return String (data e hora formatado)
     */
    public String getDtCancelamento() {
        return RetornaData(dtCancelamento);
    }
    public String getDtAtivacao() {
        return RetornaData(dtAtivacao);
    }
    /**
     * 
     * @param strAtivacao = Data de ativação
     * @throws ParseException 
     */
    public void setDtAtivacao(String strAtivacao) throws ParseException {
        this.dtAtivacao = SetData(strAtivacao);
    }
    /**
    * O dia de pagamento deve ser um dos seguintes dias do mês: 1, 5, 10 ou 15
    * @param intDiaPagamento = Dia do mês do pagamento
    * @return boolean (true = dia alterado, false = dia invalido, data nao foi alterada)
    */
    public boolean setIntDiaPagamento(int intDiaPagamento) {
        boolean blnRetorno = true;
        switch(intDiaPagamento){
            case 1:
            case 5:
            case 10:
            case 15:
                this.intDiaPagamento = intDiaPagamento;
                break;
            default:
                blnRetorno = false;
                break;
        }
        return blnRetorno;
    }
    
    /**
     * Recebe uma string digitada pelo usuário e transfomra no tipo date
     * @param strCancelamento = Data de cancelamento
     * @return boolean (true = data de cancelamento alterada, false = data de cancelamento é menor que a data de ativação)
     */ 
    public boolean setDtCancelamento(String strCancelamento) throws ParseException {
        boolean blnRetorno = true;
        Date dtCancelamento = new Date();
        dtCancelamento = SetData(strCancelamento);
        if(dtCancelamento.after(this.dtAtivacao))
            this.dtCancelamento = dtCancelamento;
        else
            blnRetorno = false;
        
        return blnRetorno;
    }
    
    //Outros métodos
    /**
     * Recebe como parâmetro uma data e retorna uma string formatada (dd/MM/yyyy HH:mm:ss)
     * @param dtData
     * @return String
     */
    protected String RetornaData(Date dtData){
        SimpleDateFormat dtrDataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        return dtrDataFormatada.format(dtData);
    }
    /**
     * Recebe uma data no tipo String e transforma no tipo Date
     * @param strData = Data no formato string
     * @return Date
     * @throws ParseException 
     */
    protected Date SetData(String strData) throws ParseException{
        Date dtData = new Date();
        SimpleDateFormat dtrDataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            dtData = dtrDataFormatada.parse(strData);
        }
        catch(ParseException e){
            dtData = null;
        }
        
        return dtData;
    }
    /**
     * Verifica se o número está ativo no sistema (ativo = não possui data de cancelamento)
     * @return boolean (true = Número ativo, false = Número cancelado)
     */
    public boolean VerificaNumeroAtivo(){
        boolean blnRetorno = true;
        if(this.dtCancelamento == null)
            blnRetorno = false;
        return blnRetorno;
    }
    
}
