/*
 * Classe: Numero de Telefone
 * Atributos: intNumero, cltNumeroTelefone, tpPlano, dtAtivacao, dtCancelamento, intDiaPagamento
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
import java.util.Scanner;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */

public class NumeroTelefone {
    Scanner scnEntrada = new Scanner(System.in);
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
    public Date getDtAtivacaoDate() {
        return dtAtivacao;
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
     * @return String = Se a data existir, retorna a data formatada. Caso não exista, retorna um traço (-)
     */
    protected String RetornaData(Date dtData){
        SimpleDateFormat dtrDataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if(dtData == null)
            return "-"; //Caso a data seja ainda não tenha sido informada
        
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
    /**
     * Verifica se o número está ativo no sistema (ativo = não possui data de cancelamento)
     * @return boolean (true = Número ativo, false = Número cancelado)
     */
    public boolean VerificaNumeroAtivo(){
        boolean blnRetorno = false;
        if(this.dtCancelamento == null)
            blnRetorno = true;
        return blnRetorno;
    }
    /**
     * 
     * @param lstNumeroTelefone
     * @param intNumero
     * @param intTamanho
     * @return 
     */
    public int[] VerificaNumeroCadastrado(NumeroTelefone[] lstNumeroTelefone, int intNumero, int intTamanho){
        int vetRetorno[] = new int[2];
        vetRetorno[0] = 0; //0 caso não exista, 1 caso exista
        vetRetorno[1] = -1; //-1 caso não exista, posição no vetor caso exista
        int intAuxiliar = 0;
        for(intAuxiliar = 0; intAuxiliar < intTamanho; intAuxiliar++){
            if(lstNumeroTelefone[intAuxiliar].getIntNumero() == intNumero){
                vetRetorno[0] = 1;
                vetRetorno[1] = intAuxiliar;
                
            }
        }
        return vetRetorno;
    }
    
    /**
     * Função para imprimir os dados do Número
     */
    public void Imprimir(){
        System.out.println("Número telefônico: " + this.intNumero);
        System.out.println("Cliente: " + this.cltCliente.getStrCPF());
        System.out.println("Tipo de plano: " + this.tdPlano.getStrDescricao());
        System.out.println("Data de ativação: " + this.getDtAtivacao());
        System.out.println("Data de cancelamento: " + this.getDtCancelamento());
        System.out.println("Dia de pagamento: " + this.getIntDiaPagamento());
    }
    
    /**
     * 
     * @param lstNumeroTelefone
     * @param intQuantidadeNumeroTelefone
     * @param lstCliente
     * @param intQuantidadeCliente
     * @param lstTipoPlano
     * @param intQuantidadeTipoPlano
     * @return Uma nova lista contendo o novo número cadastrado
     */
    public NumeroTelefone[] CadastrarNumeroTelefone(NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone, Cliente[] lstCliente, int intQuantidadeCliente, TipoPlano[] lstTipoPlano, int intQuantidadeTipoPlano){
        int intNumero, intCodigoTipoPlano;
        String strCpf;
        int[] intRetornoVerifica = new int[2];
        boolean blnRetorno;
        NumeroTelefone[] lstNumeroTelefoneNovo;
        if(intQuantidadeNumeroTelefone != 0 || lstNumeroTelefone.length == 0)
            lstNumeroTelefoneNovo = new NumeroTelefone[lstNumeroTelefone.length + 1];
        else
            lstNumeroTelefoneNovo = new NumeroTelefone[lstNumeroTelefone.length];
        System.out.println("**********************************************");
        System.out.println("*         Cadastro de Numero Telefone        *");
        System.out.println("**********************************************");
        System.out.print("Número: ");
        intNumero = scnEntrada.nextInt();
        for(int intAuxiliar = 0; intAuxiliar < intQuantidadeNumeroTelefone; intAuxiliar ++){
            lstNumeroTelefoneNovo[intAuxiliar] = lstNumeroTelefone[intAuxiliar];
        }
        intRetornoVerifica = this.VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, intQuantidadeNumeroTelefone);
        if((intRetornoVerifica[0] == 0) || (intRetornoVerifica[0] == 1 && lstNumeroTelefone[intRetornoVerifica[1]].VerificaNumeroAtivo() == false )){
            this.setIntNumero(intNumero);
            scnEntrada.nextLine();
            do{
                System.out.print("Digite o CPF do Cliente: ");
                strCpf = scnEntrada.nextLine();
                intRetornoVerifica = cltCliente.VerificaCPFCadastrado(lstCliente, strCpf, intQuantidadeCliente);
                if(intRetornoVerifica[0] == 0){
                    System.out.println("**********************************************");
                    System.out.println("*             CPF não cadastrado!            *");
                    System.out.println("**********************************************");
                }
            }while(intRetornoVerifica[0] == 0);
            this.setCltCliente(lstCliente[intRetornoVerifica[1]]);
            
            do{
                System.out.print("Digite o código do Tipo de Plano: ");
                intCodigoTipoPlano = scnEntrada.nextInt();
                intRetornoVerifica = tdPlano.VerificaCodigoCadastrado(lstTipoPlano, intCodigoTipoPlano, intQuantidadeTipoPlano);
                if(intRetornoVerifica[0] == 0){
                    System.out.println("**********************************************");
                    System.out.println("*           Código não cadastrado!           *");
                    System.out.println("**********************************************");
                }
            }while(intRetornoVerifica[0] == 0);
            this.setTdPlano(lstTipoPlano[intRetornoVerifica[1]]);
            
            do{
                System.out.print("Digite o dia de pagamento(1, 5, 10, 15): ");
                blnRetorno = this.setIntDiaPagamento(scnEntrada.nextInt());
                if(!blnRetorno){
                    System.out.println("**********************************************");
                    System.out.println("*               Dia inválido!                *");
                    System.out.println("**********************************************");
                }
                    
            }while(!blnRetorno);
            scnEntrada.nextLine();
            do{
                System.out.print("Data de ativação: ");
                try {
                    this.setDtAtivacao(scnEntrada.nextLine());
                } catch (ParseException ex) {
                    System.out.println("**********************************************");
                    System.out.println("*               Data inválida!               *");
                    System.out.println("**********************************************");
                }
            }while(this.dtAtivacao == null);
            
            

            lstNumeroTelefoneNovo[intQuantidadeNumeroTelefone] = this;
            return lstNumeroTelefoneNovo;
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*           Número já cadastrado!            *");
            System.out.println("**********************************************");
            return lstNumeroTelefone;
        }
    }
    
    /**
     * 
     * @param lstNumeroTelefone
     * @param intQuantidadeNumeroTelefone
     * @param lstCliente
     * @param intQuantidadeCliente
     * @param lstTipoPlano
     * @param intQuantidadeTipoPlano
     * @return Uma lista de números contendo as novas informações do número alterado.
     */
    public NumeroTelefone[] AlterarNumeroTelefone(NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone, Cliente[] lstCliente, int intQuantidadeCliente, TipoPlano[] lstTipoPlano, int intQuantidadeTipoPlano) throws ParseException{
        int intNumero;
        int[] intRetornoVerifica = new int[2];
        String strCpf;
        int intCodigoTipoPlano;
        System.out.println("**********************************************");
        System.out.println("*               Alterar Número               *");
        System.out.println("**********************************************");
        System.out.print("Digite o Número do Telefone: ");
        intNumero = scnEntrada.nextInt();
        intRetornoVerifica = this.VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, intQuantidadeNumeroTelefone);
        if(intRetornoVerifica[0] == 1){
            System.out.println("**********************************************");
            System.out.println("* 1) Cliente                                 *");
            System.out.println("* 2) Tipo de plano                           *");
            System.out.println("* 3) Data de cancelamento                    *");
            System.out.println("* 4) Dia de pagamento                        *");
            System.out.println("**********************************************");
            System.out.print("Digite o número do campo que deseja alterar: ");
            switch(scnEntrada.nextInt()){
                case 1:
                    scnEntrada.nextLine();
                    System.out.print("Digite o CPF do Cliente: ");
                    strCpf = scnEntrada.nextLine();
                    intRetornoVerifica = this.cltCliente.VerificaCPFCadastrado(lstCliente, strCpf, intQuantidadeCliente);
                    if(intRetornoVerifica[0] == 1)
                        this.setCltCliente(lstCliente[intRetornoVerifica[1]]);
                    else{
                        System.out.println("**********************************************");
                        System.out.println("*            CPF não cadastrado!             *");
                        System.out.println("**********************************************");
                    }
                    break;
                case 2:
                    System.out.print("Digite o Código do Plano: ");
                    intCodigoTipoPlano = scnEntrada.nextInt();
                    intRetornoVerifica = this.tdPlano.VerificaCodigoCadastrado(lstTipoPlano, intCodigoTipoPlano, intQuantidadeTipoPlano);
                    if(intRetornoVerifica[0] == 1)
                        this.setTdPlano(lstTipoPlano[intRetornoVerifica[1]]);
                    else{
                        System.out.println("**********************************************");
                        System.out.println("*            Código não cadastrado!          *");
                        System.out.println("**********************************************");
                    }
                    break;
                case 3:
                    System.out.print("Data de cancelamento: ");
                    this.setDtCancelamento(scnEntrada.nextLine());
                    break;
                case 4:
                    boolean blnRetorno;
                    do{
                        System.out.print("Digite o dia de pagamento(1, 5, 10, 15): ");
                        blnRetorno = this.setIntDiaPagamento(scnEntrada.nextInt());
                        if(!blnRetorno){
                            System.out.println("**********************************************");
                            System.out.println("*               Dia inválido!                *");
                            System.out.println("**********************************************");
                        }

                    }while(!blnRetorno);
                    scnEntrada.nextLine();
                    break;
                default:
                    System.out.println("**********************************************");
                    System.out.println("*              Opção inválida                *");
                    System.out.println("**********************************************");
                    break;
            }  
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*          Número não cadastrado!            *");
            System.out.println("**********************************************");
        }
        
        return lstNumeroTelefone;
    }
    /**
     * Função para excluir um número de telefone do sistema
     * @param lstNumeroTelefone
     * @param intQuantidadeNumeroTelefone
     * @return Caso o número exista, a função retorna a lista de números sem o número informado. Caso contrário, retorna a lista passada como parâmetro
     */
    public NumeroTelefone[] ExcluirNumeroTelefone(NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone){
        int intAuxiliar, intNumero;
        int[] intRetornoVerifica = new int[2];
        NumeroTelefone[] lstNumeroTelefoneNovo = new NumeroTelefone[lstNumeroTelefone.length - 1];
        System.out.println("**********************************************");
        System.out.println("*          Excluir Número Telefone           *");
        System.out.println("**********************************************");
        System.out.print("Digite o número: ");
        intNumero = scnEntrada.nextInt();
        intRetornoVerifica = this.VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, lstNumeroTelefone.length);
        if(intRetornoVerifica[0] == 1){
            scnEntrada.nextLine();
            System.out.print("Deseja excluir o item? (s/n): ");
            if(scnEntrada.nextLine().equals("s")){
                for(intAuxiliar = intRetornoVerifica[1]; intAuxiliar < lstNumeroTelefone.length; intAuxiliar++){
                    if(lstNumeroTelefone.length - 1 == intAuxiliar)
                        lstNumeroTelefone[intAuxiliar] = null;
                    else
                        lstNumeroTelefone[intAuxiliar] = lstNumeroTelefone[intAuxiliar+1];
                }
                for(intAuxiliar = 0; intAuxiliar < lstNumeroTelefone.length - 1; intAuxiliar++){
                    lstNumeroTelefoneNovo[intAuxiliar] = lstNumeroTelefone[intAuxiliar];
                }

                return lstNumeroTelefoneNovo;
            }
            else
                return lstNumeroTelefone;
            
            
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*          Número não cadastrado!            *");
            System.out.println("**********************************************");
            return lstNumeroTelefone;
        } 
    }
    /**
     * 
     * @param lstNumeroTelefone
     * @param intQuantidadeNumeroTelefone
     * @return Uma lista de números contendo o número cancelado
     * @throws ParseException 
     */
    public NumeroTelefone[] CancelarNumeroTelefone(NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone, Chamada[] lstChamada, int intQuantidadeChamada) throws ParseException{
        int intNumero;
        int[] intRetornoVerifica = new int[2];
        String strCpf;
        int intCodigoTipoPlano, intAuxiliar;
        Date dtDataChamadaRecente = new Date();
        System.out.println("**********************************************");
        System.out.println("*              Cancelar Número               *");
        System.out.println("**********************************************");
        System.out.print("Digite o Número do Telefone: ");
        intNumero = scnEntrada.nextInt();
        intRetornoVerifica = this.VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, intQuantidadeNumeroTelefone);
        scnEntrada.nextLine();
        if(intRetornoVerifica[0] == 1){
            System.out.print("Data de cancelamento: ");
            if(!lstNumeroTelefone[intRetornoVerifica[1]].setDtCancelamento(scnEntrada.nextLine())){
                dtDataChamadaRecente = lstChamada[0].getDtInicioDate();
                for(intAuxiliar = 0; intAuxiliar < intQuantidadeChamada; intAuxiliar++){
                    if(lstChamada[intAuxiliar].getNmrOrigem().getIntNumero() == intNumero){
                        if(dtDataChamadaRecente.after(lstChamada[intAuxiliar].getDtInicioDate()))
                            dtDataChamadaRecente = lstChamada[intAuxiliar].getDtInicioDate();
                    }
                }
                if(lstNumeroTelefone[intRetornoVerifica[1]].dtCancelamento.after(dtDataChamadaRecente)){
                    lstNumeroTelefone[intRetornoVerifica[1]].setDtCancelamento(null);
                    System.out.println("**********************************************");
                    System.out.println("*              Data inválida!                *");
                    System.out.println("**********************************************");
                }
                
            }
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*          Número não cadastrado!            *");
            System.out.println("**********************************************");
        }
        return lstNumeroTelefone;
    }
    /**
     * Método para listar os números de telefone cadastrados no sistema
     * @param lstNumeroTelefone
     * @param intQuantidadeNumeroTelefone 
     */
    public void ListarNumeroTelefone(NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone){
        int intAuxiliar;
        System.out.println("**********************************************");
        System.out.println("*          Listar Número Telefone            *");
        System.out.println("**********************************************");
        if(intQuantidadeNumeroTelefone == 0){
            System.out.println("**********************************************");
            System.out.println("*        Nenhum número está cadastrado!      *");
            System.out.println("**********************************************");
        }
        else{
            for(intAuxiliar = 0; intAuxiliar < intQuantidadeNumeroTelefone; intAuxiliar++){
                System.out.println("\nNúmero: " + (intAuxiliar+1));
                lstNumeroTelefone[intAuxiliar].Imprimir();
            }
            
        }
    }
    /**
     * Método de pesquisa para número de telefone
     * @param lstNumeroTelefone
     * @param intQuantidadeNumeroTelefone 
     */
    public void PesquisarNumeroTelefone(NumeroTelefone[] lstNumeroTelefone, int intQuantidadeNumeroTelefone){
        int intNumero;
        int[] intRetornoVerifica = new int[2];
        System.out.println("**********************************************");
        System.out.println("*             Pesquisar Número               *");
        System.out.println("**********************************************");
        if(intQuantidadeNumeroTelefone == 0){
            System.out.println("**********************************************");
            System.out.println("*       Nenhum número está cadastrado!      *");
            System.out.println("**********************************************");
        }
        else{
            System.out.print("Digite o número: ");
            intNumero = scnEntrada.nextInt();
            intRetornoVerifica = this.VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, intQuantidadeNumeroTelefone);
            if(intRetornoVerifica[0] == 1){
                lstNumeroTelefone[intRetornoVerifica[1]].Imprimir();
            }
            else{
                System.out.println("**********************************************");
                System.out.println("*          Número não cadastrado!            *");
                System.out.println("**********************************************");
            } 
            
        }
    }
    
}
