/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento;

import javax.swing.JFrame;
import projetofisicamovimento.ig.JanelaPrincipal;

/**
 * Classe principal do projeto.
 * 
 * @author David Buzatto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        java.awt.EventQueue.invokeLater( new Runnable() {
            public void run() {
                JanelaPrincipal jp = new JanelaPrincipal();
                jp.setExtendedState( JFrame.MAXIMIZED_BOTH );
                jp.setVisible( true );
            }
        });
    }
}
