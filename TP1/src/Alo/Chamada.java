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
import java.util.Scanner;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */
public class Chamada {
    Scanner scnEntrada = new Scanner(System.in);
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
    public Date getDtInicioDate() {
        return this.dtInicio;
    }
    public String getDrFim() {
        return RetornaData(drFim);
    }
    public Date getDrFimDate() {
        return this.drFim;
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
     * Função para imprimir os dados do Número
     */
    public void Imprimir(){
        System.out.println("Número de origem: " + this.getNmrOrigem().getIntNumero());
        System.out.println("Número de destino: " + this.getStrTelefoneDestino());
        System.out.println("Início: " + this.getDtInicio());
        System.out.println("Fim: " + this.getDrFim());

    }
    /**
     * Recebe uma data no tipo String e transforma no tipo Date
     * @param strData = Data no formato string
     * @return Date
     * @throws ParseException 
     */
    protected Date SetData(String strData) throws ParseException{
        Date dtData = new Date();
        SimpleDateFormat dtrDataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            dtData = dtrDataFormatada.parse(strData);
        }
        catch(ParseException e){
            try{
                dtrDataFormatada = new SimpleDateFormat("dd/MM/yyyy");
                dtData = dtrDataFormatada.parse(strData);
            }
            catch(ParseException x){
                dtData = null;
            }   
        }
        return dtData;
    }
    
    public Chamada[] RegistrarChamada(Chamada[] lstChamada, int intQuantidadeChamada, NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone) throws ParseException{
        int intNumero;
        int vetRetorno[] = new int[2];
        Chamada[] lstChamadaNovo;
        if(intQuantidadeChamada != 0 || lstChamada.length == 0)
            lstChamadaNovo = new Chamada[lstChamada.length + 1];
        else
            lstChamadaNovo = new Chamada[lstChamada.length];
        System.out.println("**********************************************");
        System.out.println("*            Cadastro de Chamada             *");
        System.out.println("**********************************************");
        System.out.print("Número origem: ");
        intNumero = scnEntrada.nextInt();
        for(int intAuxiliar = 0; intAuxiliar < intQuantidadeChamada; intAuxiliar ++){
            lstChamadaNovo[intAuxiliar] = lstChamada[intAuxiliar];
        }
        vetRetorno = lstNumeroTelefone[0].VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, intQuantidadeNumeroTelefone);
        if(vetRetorno[0] == 1){
            if(lstNumeroTelefone[vetRetorno[1]].VerificaNumeroAtivo()){
                this.setNmrOrigem(lstNumeroTelefone[vetRetorno[1]]);
                scnEntrada.nextLine();
                System.out.print("Número destino: ");
                this.setStrTelefoneDestino(scnEntrada.nextLine());
                System.out.print("Data e hora de início: ");
                this.setDtInicio(scnEntrada.nextLine());
                System.out.print("Data e hora de fim: ");
                this.setDrFim(scnEntrada.nextLine());
                if(lstNumeroTelefone[vetRetorno[1]].getDtAtivacaoDate().after(dtInicio))
                    this.dtInicio = null;
                if(lstNumeroTelefone[vetRetorno[1]].getDtAtivacaoDate().after(drFim))
                    this.drFim = null;

                lstChamadaNovo[intQuantidadeChamada] = this;
                return lstChamadaNovo;
            }
            else{
                System.out.println("**********************************************");
                System.out.println("*              Número inativo!               *");
                System.out.println("**********************************************");
                return lstChamada;
            }
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*          Número não cadastrado!            *");
            System.out.println("**********************************************");
            return lstChamada;
        }
    }
    
    public Chamada[] ExcluirChamada(Chamada[] lstChamada, int intQuantidadeChamada, NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone) throws ParseException{
        int intAuxiliar, intNumero, intIndex = -1;
        int[] intRetornoVerifica = new int[2];
        Chamada chdChamada = new Chamada();
        Chamada[] lstChamadaNovo = new Chamada[lstChamada.length - 1];
        System.out.println("**********************************************");
        System.out.println("*              Excluir Chamada               *");
        System.out.println("**********************************************");
        System.out.print("Digite o número de origem: ");
        intNumero = scnEntrada.nextInt();
        scnEntrada.nextLine();
        intRetornoVerifica = lstNumeroTelefone[0].VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, lstNumeroTelefone.length);
        if(intRetornoVerifica[0] == 1){
            chdChamada.setNmrOrigem(lstNumeroTelefone[intRetornoVerifica[1]]);
            System.out.print("Número destino: ");
            chdChamada.setStrTelefoneDestino(scnEntrada.nextLine());
            System.out.print("Data e hora de início: ");
            chdChamada.setDtInicio(scnEntrada.nextLine());
            System.out.print("Data e hora de fim: ");
            chdChamada.setDrFim(scnEntrada.nextLine());
            for(intAuxiliar = 0; intAuxiliar < intQuantidadeChamada; intAuxiliar++){
                if(lstChamada[intAuxiliar] == chdChamada){
                    intIndex = intAuxiliar;
                }
            }
            if(intIndex != -1){
                for(intAuxiliar = intIndex; intAuxiliar < lstChamada.length; intAuxiliar++){
                    if(lstChamada.length - 1 == intAuxiliar)
                        lstChamada[intAuxiliar] = null;
                    else
                        lstChamada[intAuxiliar] = lstChamada[intAuxiliar+1];
                }
                for(intAuxiliar = 0; intAuxiliar < lstChamada.length - 1; intAuxiliar++){
                    lstChamadaNovo[intAuxiliar] = lstChamada[intAuxiliar];
                }

                return lstChamadaNovo;
            }
            else{
                System.out.println("**********************************************");
                System.out.println("*         Chamada não cadastrada!            *");
                System.out.println("**********************************************");
                return lstChamada;
            }   
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*          Número não cadastrado!            *");
            System.out.println("**********************************************");
            return lstChamada;
        } 
    }
    
    /**
     * 
     * @param lstChamada
     * @param intQuantidadeChamada 
     */
    public void ListarChamada(Chamada[] lstChamada, int intQuantidadeChamada){
        int intAuxiliar;
        System.out.println("**********************************************");
        System.out.println("*              Listar Chamada                *");
        System.out.println("**********************************************");
        if(intQuantidadeChamada == 0){
            System.out.println("**********************************************");
            System.out.println("*        Nenhuma Chamada está cadastrada!    *");
            System.out.println("**********************************************");
        }
        else{
            for(intAuxiliar = 0; intAuxiliar < intQuantidadeChamada; intAuxiliar++){
                System.out.println("\nChamada: " + (intAuxiliar+1));
                lstChamada[intAuxiliar].Imprimir();
            }
            
        }
    }
    
    /**
     * 
     * @param lstChamada
     * @param intQuantidadeChamada
     * @param lstNumeroTelefone
     * @param intQuantidadeNumeroTelefone 
     */
    public void PesquisarChamada(Chamada[] lstChamada, int intQuantidadeChamada, NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone){
        int intNumero, intAuxiliar;
        int[] intRetornoVerifica = new int[2];
        System.out.println("**********************************************");
        System.out.println("*             Pesquisar Chamada               *");
        System.out.println("**********************************************");
        if(intQuantidadeChamada == 0){
            System.out.println("**********************************************");
            System.out.println("*       Nenhuma Chamada está cadastrada!     *");
            System.out.println("**********************************************");
        }
        else{
            System.out.print("Digite o número: ");
            intNumero = scnEntrada.nextInt();
            intRetornoVerifica = lstNumeroTelefone[0].VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, intQuantidadeNumeroTelefone);
            if(intRetornoVerifica[0] == 1){
                for(intAuxiliar = 0; intAuxiliar < intQuantidadeChamada; intAuxiliar++){
                    if(lstChamada[intAuxiliar].nmrOrigem.getIntNumero() == intNumero){
                        lstChamada[intAuxiliar].Imprimir();
                    }
                }
            }
            else{
                System.out.println("**********************************************");
                System.out.println("*          Número não cadastrado!            *");
                System.out.println("**********************************************");
            } 
            
        }
    }
    
}
