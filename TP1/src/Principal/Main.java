/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Interface.Menu;

/**
 *
 * @author Gustavo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu mMenu = new Menu();
        mMenu.MenuPrincipal();
        mMenu.SubMenuTipoPlano();
        System.out.println("Programa encerrado!");
    }
    
}
