/*
 * Classe: Cliente
 * Atributos: strCPF, strNome, strEndereco
 * Métodos: get e set para todos os atributos;
 */
package Alo;

import java.util.Scanner;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */
public class Cliente {
    Scanner scnEntrada = new Scanner(System.in);
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
    /**
     * 
     * @param lstCliente
     * @param srCpf
     * @param intTamanho
     * @return 
     */
    public int[] VerificaCPFCadastrado(Cliente[] lstCliente, String srCpf, int intTamanho){
        int vetRetorno[] = new int[2];
        vetRetorno[0] = 0; //0 caso não exista, 1 caso exista
        vetRetorno[1] = -1; //-1 caso não exista, posição no vetor caso exista
        int intAuxiliar = 0;
        for(intAuxiliar = 0; intAuxiliar < intTamanho; intAuxiliar++){
            if(lstCliente[intAuxiliar].getStrCPF().equals(srCpf)){
                vetRetorno[0] = 1;
                vetRetorno[1] = intAuxiliar;
            }
        }
        return vetRetorno;
    }
    /**
     * Função para imprimir os dados do Cliente
     */
    public void Imprimir(){
        System.out.println("CPF: " + this.strCPF);
        System.out.println("Nome: " + this.strNome);
        System.out.println("Endereço: " + this.strEndereco);
    }
    
    /**
     * 
     * @param lstCliente
     * @param intQuantidadeCliente
     * @return 
     */
    public Cliente[] CadastrarCliente(Cliente[] lstCliente, int intQuantidadeCliente){
        String strCPF;
        Cliente[] lstClienteNovo;
        if(intQuantidadeCliente != 0 || lstCliente.length == 0)
            lstClienteNovo = new Cliente[lstCliente.length + 1];
        else
            lstClienteNovo = new Cliente[lstCliente.length];
        System.out.println("**********************************************");
        System.out.println("*            Cadastro de Cliente             *");
        System.out.println("**********************************************");
        System.out.print("CPF: ");
        strCPF = scnEntrada.nextLine();
        for(int intAuxiliar = 0; intAuxiliar < intQuantidadeCliente; intAuxiliar ++){
            lstClienteNovo[intAuxiliar] = lstCliente[intAuxiliar];
        }
        if(this.VerificaCPFCadastrado(lstCliente, strCPF, intQuantidadeCliente)[0] == 0){
            this.setStrCPF(strCPF);
            System.out.print("Nome: ");
            this.setStrNome(scnEntrada.nextLine());
            System.out.print("Endereço: ");
            this.setStrEndereco(scnEntrada.nextLine());

            lstClienteNovo[intQuantidadeCliente] = this;
            return lstClienteNovo;
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*             CPF já cadastrado!             *");
            System.out.println("**********************************************");
            return lstCliente;
        }
    }
    /**
     * 
     * @param lstCliente
     * @param intQuantidadeCliente
     * @return 
     */
    public Cliente[] AlterarCliente(Cliente[] lstCliente, int intQuantidadeCliente){
        String strCPF;
        int[] intRetornoVerifica = new int[2];
        System.out.println("**********************************************");
        System.out.println("*              Alterar Cliente               *");
        System.out.println("**********************************************");
        System.out.print("Digite o CPF: ");
        strCPF = scnEntrada.nextLine();
        intRetornoVerifica = this.VerificaCPFCadastrado(lstCliente, strCPF, intQuantidadeCliente);
        if(intRetornoVerifica[0] == 1){
            System.out.println("**********************************************");
            System.out.println("* 1) Nome                                    *");
            System.out.println("* 2) Endereço                                *");
            System.out.println("**********************************************");
            System.out.print("Digite o número do campo que deseja alterar: ");
            switch(scnEntrada.nextInt()){
                case 1:
                    System.out.print("Nome: ");
                    lstCliente[intRetornoVerifica[1]].setStrNome(scnEntrada.nextLine());
                    break;
                case 2:
                    System.out.print("Endereço: ");
                    lstCliente[intRetornoVerifica[1]].setStrEndereco(scnEntrada.nextLine());
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
            System.out.println("*            CPF não cadastrado!             *");
            System.out.println("**********************************************");
        }
        
        return lstCliente;
    }
    /**
     * 
     * @param lstCliente
     * @param intQuantidadeCliente
     * @return 
     */
    public Cliente[] ExcluirCliente(Cliente[] lstCliente, int intQuantidadeCliente){
        int intAuxiliar;
        String strCPF;
        int[] intRetornoVerifica = new int[2];
        Cliente[] lstClienteNovo = new Cliente[lstCliente.length - 1];
        System.out.println("**********************************************");
        System.out.println("*              Excluir Cliente               *");
        System.out.println("**********************************************");
        System.out.print("Digite o CPF: ");
        strCPF = scnEntrada.nextLine();
        intRetornoVerifica = this.VerificaCPFCadastrado(lstCliente, strCPF, lstCliente.length);
        if(intRetornoVerifica[0] == 1){
            System.out.print("Deseja excluir o item? (s/n): ");
            if(scnEntrada.nextLine().equals("s")){
                for(intAuxiliar = intRetornoVerifica[1]; intAuxiliar < lstCliente.length; intAuxiliar++){
                    if(lstCliente.length - 1 == intAuxiliar)
                        lstCliente[intAuxiliar] = null;
                    else
                        lstCliente[intAuxiliar] = lstCliente[intAuxiliar+1];
                }
                for(intAuxiliar = 0; intAuxiliar < lstCliente.length - 1; intAuxiliar++){
                    lstClienteNovo[intAuxiliar] = lstCliente[intAuxiliar];
                }

                return lstClienteNovo;
            }
            else
                return lstCliente;
            
            
        }
        else{
            System.out.println("**********************************************");
            System.out.println("*            CPF não cadastrado!             *");
            System.out.println("**********************************************");
            return lstCliente;
        } 
    }
    /**
     * 
     * @param lstCliente
     * @param intQuantidadeCliente 
     */
    public void ListarCliente(Cliente[] lstCliente, int intQuantidadeCliente){
        int intAuxiliar;
        System.out.println("**********************************************");
        System.out.println("*               Listar Cliente               *");
        System.out.println("**********************************************");
        if(intQuantidadeCliente == 0){
            System.out.println("**********************************************");
            System.out.println("*        Nenhum cliente está cadastrado!     *");
            System.out.println("**********************************************");
        }
        else{
            for(intAuxiliar = 0; intAuxiliar < intQuantidadeCliente; intAuxiliar++){
                System.out.println("\nCliente: " + (intAuxiliar+1));
                lstCliente[intAuxiliar].Imprimir();
            }
            
        }
    }
    /**
     * 
     * @param lstCliente
     * @param intQuantidadeCliente 
     */
    public void PesquisarCliente(Cliente[] lstCliente, int intQuantidadeCliente){
        String strCPF;
        int[] intRetornoVerifica = new int[2];
        System.out.println("**********************************************");
        System.out.println("*            Pesquisar Cliente               *");
        System.out.println("**********************************************");
        if(intQuantidadeCliente == 0){
            System.out.println("**********************************************");
            System.out.println("*       Nenhum cliente está cadastrado!      *");
            System.out.println("**********************************************");
        }
        else{
            System.out.print("Digite o CPF: ");
            strCPF = scnEntrada.nextLine();
            intRetornoVerifica = this.VerificaCPFCadastrado(lstCliente, strCPF, intQuantidadeCliente);
            if(intRetornoVerifica[0] == 1){
                lstCliente[intRetornoVerifica[1]].Imprimir();
            }
            else{
                System.out.println("**********************************************");
                System.out.println("*            CPF não cadastrado!             *");
                System.out.println("**********************************************");
            } 
            
        }
    }
}
