/*
 * Classe: Tipo de Plano
 * Atributos: intCodigo, strDescricao, dblValorMensal, intFranquia, dblValorChamada
 * Métodos: get e set para todos os atributos;
 */
package Interface;

import Controlador.Controlador;
import java.text.ParseException;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */

public class Menu {
    private int intMenuAtual = 0;
    private Controlador cControlador = new Controlador();
    
    public void MenuPrincipal(){
        System.out.println("**********************************************");
        System.out.println("*                    Menu                    *");
        System.out.println("**********************************************");
        System.out.println("* 1) Tipo de Plano                           *");
        System.out.println("* 2) Cliente                                 *");
        System.out.println("* 3) Número de telefone                      *");
        System.out.println("* 4) Chamada originada                       *");
        System.out.println("* 5) Relatórios                              *");
        System.out.println("* 6) Sair                                    *");
        System.out.println("**********************************************");
    }
    
    public void SubMenuTipoPlano(){
        System.out.println("**********************************************");
        System.out.println("*               Tipo de Plano                *");
        System.out.println("**********************************************");
        System.out.println("* 1) Cadastrar                               *");
        System.out.println("* 2) Alterar                                 *");
        System.out.println("* 3) Excluir                                 *");
        System.out.println("* 4) Listar                                  *");
        System.out.println("* 5) Pesquisar                               *");
        System.out.println("* 6) Voltar                                  *");
        System.out.println("**********************************************");
    }
    
    public void SubMenuCliente(){
        System.out.println("**********************************************");
        System.out.println("*                  Cliente                   *");
        System.out.println("**********************************************");
        System.out.println("* 1) Cadastrar                               *");
        System.out.println("* 2) Alterar                                 *");
        System.out.println("* 3) Excluir                                 *");
        System.out.println("* 4) Listar                                  *");
        System.out.println("* 5) Pesquisar                               *");
        System.out.println("* 6) Voltar                                  *");
        System.out.println("**********************************************");
    }
    
    public void SubMenuNumeroTelefone(){
        System.out.println("**********************************************");
        System.out.println("*             Número de Telefone             *");
        System.out.println("**********************************************");
        System.out.println("* 1) Cadastrar                               *");
        System.out.println("* 2) Alterar                                 *");
        System.out.println("* 3) Excluir                                 *");
        System.out.println("* 4) Cancelar                                *");
        System.out.println("* 5) Listar                                  *");
        System.out.println("* 6) Pesquisar                               *");
        System.out.println("* 7) Voltar                                  *");
        System.out.println("**********************************************");
    }
    
    public void SubMenuChamadaOriginada(){
        System.out.println("**********************************************");
        System.out.println("*             Chamada Originada              *");
        System.out.println("**********************************************");
        System.out.println("* 1) Registrar                               *");
        System.out.println("* 2) Excluir                                 *");
        System.out.println("* 3) Listar                                  *");
        System.out.println("* 4) Pesquisar                               *");
        System.out.println("* 5) Voltar                                  *");
        System.out.println("**********************************************");
    }
    
    public void SubMenuRelatorios(){
        System.out.println("**********************************************");
        System.out.println("*                 Relatórios                 *");
        System.out.println("**********************************************");
        System.out.println("* 1) Números telefônicos de um cliente       *");
        System.out.println("* 2) Conta de telefone                       *");
        System.out.println("* 3) Voltar                                  *");
        System.out.println("**********************************************");
    }
    
    public boolean EscolheMenu(int intMenu) throws ParseException{
        boolean blnRetorno = false;
        switch(this.intMenuAtual){
            case 0:
                MenuPrincipal();
                this.intMenuAtual = 1;
                break;
            case 1: //Menu Principal
                switch(intMenu){
                    case -1:
                        MenuPrincipal();
                        break;
                    case 1:
                        SubMenuTipoPlano();
                        this.intMenuAtual = 2;
                        break;
                    case 2:
                        SubMenuCliente();
                        this.intMenuAtual = 3;
                        break;
                    case 3:
                        SubMenuNumeroTelefone();
                        this.intMenuAtual = 4;
                        break;
                    case 4:
                        SubMenuChamadaOriginada();
                        this.intMenuAtual = 5;
                        break;
                    case 5:
                        SubMenuRelatorios();
                        this.intMenuAtual = 6;
                        break;
                    case 6:
                        blnRetorno = true;
                        break;
                    default:
                        OpcaoInvalida();
                        break;
                }
                break;
            case 2: //SubMenuTipoPlano
                switch(intMenu){
                    case -1:
                        SubMenuTipoPlano();
                        break;        
                    case 1:
                        cControlador.CadastrarTipoPlano();
                        break;
                    case 2:
                        cControlador.AlterarTipoPlano();
                        break;
                    case 3:
                        cControlador.ExcluirTipoPlano();
                        break;
                    case 4:
                        cControlador.ListarTipoPlano();
                        break;
                    case 5:
                        cControlador.PesquisarTipoPlano();
                        break;
                    case 6:
                        this.intMenuAtual = 0;
                        break;
                    default:
                        OpcaoInvalida();
                        break;
                }
                break;
            case 3: //SubMenuCliente
                switch(intMenu){
                    case -1:
                        SubMenuCliente();
                        break;
                    case 1:
                        cControlador.CadastrarCliente();
                        break;
                    case 2:
                        cControlador.AlterarCliente();
                        break;
                    case 3:
                        cControlador.ExcluirCliente();
                        break;
                    case 4:
                        cControlador.ListarCliente();
                        break;
                    case 5:
                        cControlador.PesquisarCliente();
                        break;
                    case 6:
                        this.intMenuAtual = 0;
                        break;
                    default:
                        OpcaoInvalida();
                        break;
                }
                break;
            case 4: //SubMenuNumeroTelefone
                switch(intMenu){
                    case -1:
                        SubMenuNumeroTelefone();
                        break;
                    case 1:
                        cControlador.CadastrarNumeroTelefone();
                        break;
                    case 2:
                        cControlador.AlterarNumeroTelefone();
                        break;
                    case 3:
                        cControlador.ExcluirNumeroTelefone();
                        break;
                    case 4:
                        cControlador.CancelarNumeroTelefone();
                        break;
                    case 5:
                        cControlador.ListarNumeroTelefone();
                        break;
                    case 6:
                        cControlador.PesquisarNumeroTelefone();
                        break;
                    case 7:
                        this.intMenuAtual = 0;
                        break;
                    default:
                        OpcaoInvalida();
                        break;
                }
                break;
            case 5: //SubMenuChamadaOriginada
                switch(intMenu){
                    case -1:
                        SubMenuChamadaOriginada();
                        break;
                    case 1:
                        cControlador.RegistrarChamada();
                        break;
                    case 2:
                        cControlador.ExcluirChamada();
                        break;
                    case 3:
                        cControlador.ListarChamada();
                        break;
                    case 4:
                        cControlador.PesquisarChamada();
                        break;
                    case 5:
                        this.intMenuAtual = 0;
                        break;
                    default:
                        OpcaoInvalida();
                        break;
                }
                break;
            case 6: //SubMenuRelatorios
                switch(intMenu){
                    case -1:
                        SubMenuRelatorios();
                        break;
                    case 1:
                        cControlador.ExibeNumerosTelefonicosCliente();
                        break;
                    case 2:
                        cControlador.Conta();
                        break;
                    case 3:
                        this.intMenuAtual = 0;
                        break;
                    default:
                        OpcaoInvalida();
                        break;
                }
                break;
        }
        
        return blnRetorno;
    }
    
    public void OpcaoInvalida() throws ParseException{
        /*System.out.println("**********************************************");
        System.out.println("*              Opção inválida!!              *");
        System.out.println("**********************************************");*/
        EscolheMenu(-1);
    }
}
