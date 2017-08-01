/*
 * Classe: Tipo de Plano
 * Atributos: intCodigo, strDescricao, dblValorMensal, intFranquia, dblValorChamada
 * Métodos: get e set para todos os atributos;
 */
package Alo;

import java.util.Scanner;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */
public class TipoPlano {
    Scanner scnEntrada = new Scanner(System.in);
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
    /**
     * 
     * @param lstTipoPlano
     * @param intCodigo
     * @param intTamanho
     * @return vetRetorno[0] se existe ou não
     *         vetRetorno[0] posição do vetor 
     */
    public int[] VerificaCodigoCadastrado(TipoPlano[] lstTipoPlano, int intCodigo, int intTamanho){
        int vetRetorno[] = new int[2];
        vetRetorno[0] = 0; //0 caso não exista, 1 caso exista
        vetRetorno[1] = -1; //-1 caso não exista, posição no vetor caso exista
        int intAuxiliar = 0;
        for(intAuxiliar = 0; intAuxiliar < intTamanho; intAuxiliar++){
            if(lstTipoPlano[intAuxiliar].getIntCodigo() == intCodigo){
                vetRetorno[0] = 1;
                vetRetorno[1] = intAuxiliar;
            }
        }
        return vetRetorno;
    }
    /**
     * Função para imprimir os dados do Tipo de Plano
     */
    public void Imprimir(){
        System.out.println("Código: " + this.intCodigo);
        System.out.println("Descrição: " + this.strDescricao);
        System.out.println("Franquia: " + this.intFranquia);
        System.out.println("Valor mensal: " + this.dblValorMensal);
        System.out.println("Valor da chamada: " + this.dblValorChamada);
    }
    

    /**
     * 
     * @param lstTipoPlano
     * @param intQuantidadeTipoPlano
     * @return 
     */
    public TipoPlano[] CadastrarTipoPlano(TipoPlano[] lstTipoPlano, int intQuantidadeTipoPlano){
        int intCodigo;
        TipoPlano[] lstTipoPlanoNovo;
        if(intQuantidadeTipoPlano != 0 || lstTipoPlano.length == 0)
            lstTipoPlanoNovo = new TipoPlano[lstTipoPlano.length + 1];
        else
            lstTipoPlanoNovo = new TipoPlano[lstTipoPlano.length];
        
        System.out.println("**********************************************");
        System.out.println("*         Cadastro de Tipo de Plano          *");
        System.out.println("**********************************************");
        System.out.print("Código: ");
        intCodigo = scnEntrada.nextInt();
        for(int intAuxiliar = 0; intAuxiliar < intQuantidadeTipoPlano; intAuxiliar ++){
            lstTipoPlanoNovo[intAuxiliar] = lstTipoPlano[intAuxiliar];
        }
        if(this.VerificaCodigoCadastrado(lstTipoPlano, intCodigo, intQuantidadeTipoPlano)[0] == 0){
            this.setIntCodigo(intCodigo);
            scnEntrada.nextLine();
            System.out.print("Descrição: ");
            this.setStrDescricao(scnEntrada.nextLine());
            System.out.print("Franquia: ");
            this.setIntFranquia(scnEntrada.nextInt());
            System.out.print("Valor mensal: ");
            this.setDblValorMensal(scnEntrada.nextDouble());
            System.out.print("Valor da chamada: ");
            this.setDblValorChamada(scnEntrada.nextDouble());

            lstTipoPlanoNovo[intQuantidadeTipoPlano] = this;
            return lstTipoPlanoNovo;
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*           Código já cadastrado!            *");
            System.out.println("**********************************************");
            return lstTipoPlano;
        }
    }
    /**
     * 
     * @param lstTipoPlano
     * @param intQuantidadeTipoPlano
     * @return 
     */
    public TipoPlano[] AlterarTipoPlano(TipoPlano[] lstTipoPlano, int intQuantidadeTipoPlano){
        int intCodigo;
        int[] intRetornoVerifica = new int[2];
        System.out.println("**********************************************");
        System.out.println("*           Alterar Tipo de Plano            *");
        System.out.println("**********************************************");
        System.out.print("Digite o código: ");
        intCodigo = scnEntrada.nextInt();
        scnEntrada.nextLine();
        intRetornoVerifica = this.VerificaCodigoCadastrado(lstTipoPlano, intCodigo, intQuantidadeTipoPlano);
        if(intRetornoVerifica[0] == 1){
            System.out.println("**********************************************");
            System.out.println("* 1) Descrição                               *");
            System.out.println("* 2) Franquia                                *");
            System.out.println("* 3) Valor mensal                            *");
            System.out.println("* 4) Valor da chamada                        *");
            System.out.println("**********************************************");
            System.out.print("Digite o número do campo que deseja alterar: ");
            switch(scnEntrada.nextInt()){
                case 1:
                    scnEntrada.nextLine();
                    System.out.print("Descrição: ");
                    lstTipoPlano[intRetornoVerifica[1]].setStrDescricao(scnEntrada.nextLine());
                    break;
                case 2:
                    scnEntrada.nextLine();
                    System.out.print("Franquia: ");
                    lstTipoPlano[intRetornoVerifica[1]].setIntFranquia(scnEntrada.nextInt());
                    break;
                case 3:
                    System.out.print("Valor mensal: ");
                    lstTipoPlano[intRetornoVerifica[1]].setDblValorMensal(scnEntrada.nextDouble());
                    break;
                case 4:
                    System.out.print("Valor da chamada: ");
                    lstTipoPlano[intRetornoVerifica[1]].setDblValorChamada(scnEntrada.nextDouble());
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
            System.out.println("*          Código não cadastrado!            *");
            System.out.println("**********************************************");
        }
        
        return lstTipoPlano;
    }
   /**
    * 
    * @param lstTipoPlano
    * @param intQuantidadeTipoPlano
    * @return 
    */
    public TipoPlano[] ExcluirTipoPlano(TipoPlano[] lstTipoPlano, int intQuantidadeTipoPlano){
        int intCodigo, intAuxiliar;
        int[] intRetornoVerifica = new int[2];
        TipoPlano[] lstTipoPlanoNovo = new TipoPlano[lstTipoPlano.length - 1];
        System.out.println("**********************************************");
        System.out.println("*           Excluir Tipo de Plano            *");
        System.out.println("**********************************************");
        System.out.print("Digite o código: ");
        intCodigo = scnEntrada.nextInt();
        intRetornoVerifica = this.VerificaCodigoCadastrado(lstTipoPlano, intCodigo, lstTipoPlano.length);
        if(intRetornoVerifica[0] == 1){
            scnEntrada.nextLine();
            System.out.print("Deseja excluir o item? (s/n): ");
            if(scnEntrada.nextLine().equals("s")){
                for(intAuxiliar = intRetornoVerifica[1]; intAuxiliar < lstTipoPlano.length; intAuxiliar++){
                    if(lstTipoPlano.length - 1 == intAuxiliar)
                        lstTipoPlano[intAuxiliar] = null;
                    else
                        lstTipoPlano[intAuxiliar] = lstTipoPlano[intAuxiliar+1];
                }
                for(intAuxiliar = 0; intAuxiliar < lstTipoPlano.length - 1; intAuxiliar++){
                    lstTipoPlanoNovo[intAuxiliar] = lstTipoPlano[intAuxiliar];
                }

                return lstTipoPlanoNovo;
            }
            else
                return lstTipoPlano;   
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*          Código não cadastrado!            *");
            System.out.println("**********************************************");
            return lstTipoPlano;
        } 
        
        
    }
    /**
     * 
     * @param lstTipoPlano
     * @param intQuantidadeTipoPlano 
     */
    public void ListarTipoPlano(TipoPlano[] lstTipoPlano, int intQuantidadeTipoPlano){
        int intAuxiliar;
        System.out.println("**********************************************");
        System.out.println("*           Listar Tipo de Plano             *");
        System.out.println("**********************************************");
        if(intQuantidadeTipoPlano == 0){
            System.out.println("**********************************************");
            System.out.println("*    Nenhum tipo de plano está cadastrado!   *");
            System.out.println("**********************************************");
        }
        else{
            for(intAuxiliar = 0; intAuxiliar < intQuantidadeTipoPlano; intAuxiliar++){
                System.out.println("\nTipo de plano: " + (intAuxiliar+1));
                lstTipoPlano[intAuxiliar].Imprimir();
            }
            
        }
    }
    /**
     * 
     * @param lstTipoPlano
     * @param intQuantidadeTipoPlano 
     */
    public void PesquisarTipoPlano(TipoPlano[] lstTipoPlano, int intQuantidadeTipoPlano){
        int intCodigo;
        int[] intRetornoVerifica = new int[2];
        System.out.println("**********************************************");
        System.out.println("*         Pesquisar Tipo de Plano            *");
        System.out.println("**********************************************");
        if(intQuantidadeTipoPlano == 0){
            System.out.println("**********************************************");
            System.out.println("*    Nenhum tipo de plano está cadastrado!   *");
            System.out.println("**********************************************");
        }
        else{
            System.out.print("Digite o código: ");
            intCodigo = scnEntrada.nextInt();
            intRetornoVerifica = this.VerificaCodigoCadastrado(lstTipoPlano, intCodigo, intQuantidadeTipoPlano);
            if(intRetornoVerifica[0] == 1){
                lstTipoPlano[intRetornoVerifica[1]].Imprimir();
            }
            else{
                System.out.println("**********************************************");
                System.out.println("*          Código não cadastrado!            *");
                System.out.println("**********************************************");
            } 
            
        }
    }
}
