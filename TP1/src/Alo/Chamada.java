/*
 * Classe: Chamada
 * Atributos: nmrOrigem,  nmrDestino,  dtInicio, dtFim
 * Métodos públicos: get e set para todos os atributos;
 *                   
 *Métodos protegidos: String RetornaData(Date dtData)
 *                    Date SetData(String strData)      
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
public class Chamada {
    //Declaração de atributos
    /**
     * @param nmrOrigem = Número de telefone de oridem da chamada
     * @param strTelefoneDestino = Número de telefone de destino da chamada
     * @param dtInicio = Data e hora do início da chamada
     * @param drFim = Data e hora do fim da chamada
     */
    private NumeroTelefone nmrOrigem = new NumeroTelefone();
    private String strTelefoneDestino;
    private Date dtInicio, drFim;
    //Métodos get e set padrão
    public NumeroTelefone getNmrOrigem() {
        return nmrOrigem;
    }
    public void setNmrOrigem(NumeroTelefone nmrOrigem) {
        this.nmrOrigem = nmrOrigem;
    }
    public String getStrTelefoneDestino() {
        return strTelefoneDestino;
    }
    public void setStrTelefoneDestino(String strTelefoneDestino) {
        this.strTelefoneDestino = strTelefoneDestino;
    }
    
    //Métodos get e set modificados
    /**
     * @return String (data e hora formatado)
     */
    public String getDtInicio() {
        return RetornaData(dtInicio);
    }
    public String getDrFim() {
        return RetornaData(drFim);
    }
    /**
     * 
     * @param strInicio = Data e hora do inicio da chamada
     */
    public void setDtInicio(String strInicio) throws ParseException {
        this.dtInicio = SetData(strInicio);
    }
    /**
     * A data/hora de fim de chamada deve ser superiorà data/hora de início de chamada.
     * @param strFim = Date e hora do fim da chamada
     * @return boolean (true = fim da chamada cadastrado, false = fim da chamada é antes do início)
     * @throws ParseException 
     */
    public boolean setDrFim(String strFim) throws ParseException {
        boolean blnRetorno = true;
        Date dtFim = new Date();
        dtFim = SetData(strFim);
        if(dtFim.after(this.dtInicio))
            this.drFim = dtFim;
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
    
}
