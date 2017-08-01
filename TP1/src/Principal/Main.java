/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Interface.Menu;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Menu mMenu = new Menu();
        Scanner scnEntrada = new Scanner(System.in);
        boolean blnSair = false;
        //mMenu.MenuPrincipal();
        do{
            mMenu.EscolheMenu(-2);
            System.out.print("Opção: ");
            blnSair = mMenu.EscolheMenu(scnEntrada.nextInt());
        }while (blnSair == false);
        System.out.println("Programa encerrado!");
    }
    
}
