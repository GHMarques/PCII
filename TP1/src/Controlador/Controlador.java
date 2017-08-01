/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Alo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Controlador {
    Scanner scnEntrada = new Scanner(System.in);
    private TipoPlano[] lstTipoPlano = new TipoPlano[1];
    private Cliente[] lstCliente = new Cliente[1];
    private NumeroTelefone[] lstNumeroTelefone = new NumeroTelefone[1];
    private Chamada[] lstChamada = new Chamada[1];
    private int intQuantidadeTipoPlano = 0;
    private int intQuantidadeCliente = 0;
    private int intQuantidadeNumeroTelefone = 0;
    private int intQuantidadeChamada = 0;
    
    //Tipo de plano
    /**
     * Cadastro
     */
    public void CadastrarTipoPlano(){
        TipoPlano tpNovo = new TipoPlano();
        lstTipoPlano = tpNovo.CadastrarTipoPlano(lstTipoPlano, intQuantidadeTipoPlano);
        intQuantidadeTipoPlano = lstTipoPlano.length;
    }
    /**
     * Alterar
     */
    public void AlterarTipoPlano(){
        TipoPlano tpNovo = new TipoPlano();
        lstTipoPlano = tpNovo.AlterarTipoPlano(lstTipoPlano, intQuantidadeTipoPlano);
    }
    
    /**
     * Excluir
     */
    public void ExcluirTipoPlano(){
        TipoPlano tpNovo = new TipoPlano();
        lstTipoPlano = tpNovo.ExcluirTipoPlano(lstTipoPlano, intQuantidadeTipoPlano);
        intQuantidadeTipoPlano = lstTipoPlano.length;
    }
    
    /**
     * Listar
     */
    public void ListarTipoPlano(){
        TipoPlano tpNovo = new TipoPlano();
        tpNovo.ListarTipoPlano(lstTipoPlano, intQuantidadeTipoPlano);
    }
    
    /**
     * Pesquisar
     */
    public void PesquisarTipoPlano(){
        TipoPlano tpNovo = new TipoPlano();
        tpNovo.PesquisarTipoPlano(lstTipoPlano, intQuantidadeTipoPlano);
    }
    
    //Cliente
    /**
     * Cadastro
     */
    public void CadastrarCliente(){
        Cliente tpNovo = new Cliente();
        lstCliente = tpNovo.CadastrarCliente(lstCliente, intQuantidadeCliente);
        intQuantidadeCliente++;
    }
    /**
     * Alterar
     */
    public void AlterarCliente(){
        Cliente tpNovo = new Cliente();
        lstCliente = tpNovo.AlterarCliente(lstCliente, intQuantidadeCliente);
    }
    
    /**
     * Excluir
     */
    public void ExcluirCliente(){
        Cliente tpNovo = new Cliente();
        lstCliente = tpNovo.ExcluirCliente(lstCliente, intQuantidadeCliente);
        intQuantidadeCliente = lstCliente.length;
    }
    
    /**
     * Listar
     */
    public void ListarCliente(){
        Cliente tpNovo = new Cliente();
        tpNovo.ListarCliente(lstCliente, intQuantidadeCliente);
    }
    
    /**
     * Pesquisar
     */
    public void PesquisarCliente(){
        Cliente tpNovo = new Cliente();
        tpNovo.PesquisarCliente(lstCliente, intQuantidadeCliente);
    }
    
    //Numero Telefone
    /**
     * Cadastro
     */
    public void CadastrarNumeroTelefone(){
        NumeroTelefone tpNovo = new NumeroTelefone();
        lstNumeroTelefone = tpNovo.CadastrarNumeroTelefone(lstNumeroTelefone, intQuantidadeNumeroTelefone, lstCliente, intQuantidadeCliente, lstTipoPlano, intQuantidadeTipoPlano);
        intQuantidadeNumeroTelefone++;
    }
    /**
     * Alterar
     * @throws java.text.ParseException
     */
    public void AlterarNumeroTelefone() throws ParseException{
        NumeroTelefone tpNovo = new NumeroTelefone();
        lstNumeroTelefone = tpNovo.AlterarNumeroTelefone(lstNumeroTelefone, intQuantidadeNumeroTelefone, lstCliente, intQuantidadeCliente, lstTipoPlano, intQuantidadeTipoPlano);
    }
    
    /**
     * Excluir
     */
    public void ExcluirNumeroTelefone(){
        NumeroTelefone tpNovo = new NumeroTelefone();
        lstNumeroTelefone = tpNovo.ExcluirNumeroTelefone(lstNumeroTelefone, intQuantidadeNumeroTelefone);
        intQuantidadeNumeroTelefone = lstNumeroTelefone.length;
    }
    
    /**
     * Cancelar
     */
    public void CancelarNumeroTelefone() throws ParseException{
        NumeroTelefone tpNovo = new NumeroTelefone();
        tpNovo.CancelarNumeroTelefone(lstNumeroTelefone, intQuantidadeNumeroTelefone, lstChamada, intQuantidadeChamada);
    }
    
    /**
     * Listar
     */
    public void ListarNumeroTelefone(){
        NumeroTelefone tpNovo = new NumeroTelefone();
        tpNovo.ListarNumeroTelefone(lstNumeroTelefone, intQuantidadeNumeroTelefone);
    }
    
    /**
     * Pesquisar
     */
    public void PesquisarNumeroTelefone(){
        NumeroTelefone tpNovo = new NumeroTelefone();
        tpNovo.PesquisarNumeroTelefone(lstNumeroTelefone, intQuantidadeNumeroTelefone);
    }
    
    //Chamada
    public void RegistrarChamada() throws ParseException{
        Chamada tpNovo = new Chamada();
        lstChamada = tpNovo.RegistrarChamada(lstChamada, intQuantidadeChamada, lstNumeroTelefone, intQuantidadeNumeroTelefone);
        intQuantidadeChamada++;
    }
    
    public void ExcluirChamada() throws ParseException{
        Chamada tpNovo = new Chamada();
        lstChamada = tpNovo.ExcluirChamada(lstChamada, intQuantidadeChamada, lstNumeroTelefone, intQuantidadeNumeroTelefone);
        intQuantidadeChamada = lstChamada.length;
    }
    
    public void ListarChamada(){
        Chamada tpNovo = new Chamada();
        tpNovo.ListarChamada(lstChamada, intQuantidadeChamada);
    }
    
    public void PesquisarChamada(){
        Chamada tpNovo = new Chamada();
        tpNovo.PesquisarChamada(lstChamada, intQuantidadeChamada, lstNumeroTelefone, intQuantidadeNumeroTelefone);
    }
    
    //Relatórios
    public void ExibeNumerosTelefonicosCliente(){
        String strCPF;
        int intAuxiliar, intContador = 1;
        System.out.println("**********************************************");
        System.out.println("*       Números telefônicos do Cliente       *");
        System.out.println("**********************************************");
        System.out.print("CPF: ");
        strCPF = scnEntrada.nextLine();
        for(intAuxiliar = 0; intAuxiliar < intQuantidadeNumeroTelefone; intAuxiliar++){
            if(lstNumeroTelefone[intAuxiliar].getCltCliente().getStrCPF().equals(strCPF)){
                System.out.println("\nNúmero: " + intContador);
                lstNumeroTelefone[intAuxiliar].Imprimir();
                intContador++;
            }
                
        }
    }
    
    public void Conta() throws ParseException{
        int intNumero, intAuxiliar, intChamadaForaFranquia = 0;
        int[] intRetornoVerifica = new int[2];
        long intDuracaoChamada, intDuracaoTotal = 0;
        double dblValorForaFraquia = 0;
        String strData;
        Date dtData;
        System.out.println("**********************************************");
        System.out.println("*             Conta telefônica               *");
        System.out.println("**********************************************");
        System.out.print("Digite o número do telefone: ");
        intNumero = scnEntrada.nextInt();
        scnEntrada.nextLine();
        intRetornoVerifica = lstNumeroTelefone[0].VerificaNumeroCadastrado(lstNumeroTelefone, intNumero, intQuantidadeNumeroTelefone);
        if(intRetornoVerifica[0] == 1){
            System.out.print("O mês ano de referência (mm/aaaa): ");
            strData = scnEntrada.nextLine();

            SimpleDateFormat dtrDataFormatada = new SimpleDateFormat("MM/yyyy");
            dtData = dtrDataFormatada.parse(strData);
            if(dtData != null){

                //Pega as chamadas e suas durações
                for(intAuxiliar = 0; intAuxiliar < intQuantidadeChamada; intAuxiliar++){
                    if(lstChamada[intAuxiliar].getNmrOrigem().getIntNumero() == intNumero){
                        if(ComparaDatas(lstChamada[intAuxiliar].getDtInicioDate(), dtData)){
                            intDuracaoChamada = DuracacoChamada(lstChamada[intAuxiliar].getDtInicioDate(), lstChamada[intAuxiliar].getDrFimDate());
                            intDuracaoTotal += intDuracaoChamada;
                            if((int)intDuracaoTotal > lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getIntFranquia())
                                intChamadaForaFranquia++;

                            lstChamada[intAuxiliar].Imprimir();
                            System.out.println("Duração: " + intDuracaoChamada + "\n");
                        }
                    }
                }
                //Gera relatório
                dblValorForaFraquia = lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getDblValorChamada() * ((int)intDuracaoTotal-lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getIntFranquia());
                System.out.println("Total: " + intDuracaoTotal);
                System.out.println("Franquia: " + lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getIntFranquia());
                System.out.println("Minutos além da franquia: " + ((lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getIntFranquia() < (int)intDuracaoTotal) ? (int)intDuracaoTotal-lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getIntFranquia() : " - "));
                System.out.println("Valor do Plano: " + lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getDblValorMensal());
                System.out.println("Valor total: " + (lstNumeroTelefone[intRetornoVerifica[1]].getTdPlano().getDblValorMensal() + dblValorForaFraquia));
                
            }
            else{
                System.out.println("**********************************************");
                System.out.println("*              Data inválida                 *");
                System.out.println("**********************************************");
            }
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*         Número não cadastrado              *");
            System.out.println("**********************************************");
        }
             
    }
    //Compara as datas. Usado para retornar mês/ano referência do relatório
    public boolean ComparaDatas(Date dtPrimeiraData, Date dtSegundaData){
        boolean blnRetorno = false;
        SimpleDateFormat dtrDataFormatada = new SimpleDateFormat("MM/yyyy");
        blnRetorno = dtrDataFormatada.format(dtPrimeiraData).equals(dtrDataFormatada.format(dtSegundaData));
        return blnRetorno;
    }
    //Duração da chamada em minutos
    public long DuracacoChamada(Date dtPrimeiraData, Date dtSegundaData){
        return (dtSegundaData.getTime() - dtPrimeiraData.getTime()) / (1000*60);
    }
    
}
