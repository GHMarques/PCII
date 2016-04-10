/*
 * Classe: Tipo de Plano
 * Atributos: intCodigo, strDescricao, dblValorMensal, intFranquia, dblValorChamada
 * Métodos: get e set para todos os atributos;
 */
package Interface;

/**
 *
 * @author Gustavo Marques
 * TP1 - PCII
 */

public class Menu {
    /**
     * Tipo  de  Plano, Cliente, Numero  de  Telefone, Chamada Originada,Relatóriose  Sair
     */
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
}
