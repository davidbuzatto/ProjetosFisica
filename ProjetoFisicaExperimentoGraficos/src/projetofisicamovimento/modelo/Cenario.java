/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Cenário da animação.
 * 
 * @author David Buzatto
 */
public class Cenario extends Sprite {
    
    public Cenario() {
        super( 0, 0, 600, 300 );
    }
    
    public void desenheMe( Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        
        /*****************************************************
         ****** início do código do desenho do cenário *******
         *****************************************************/
        
        // fundo
        g2d.setColor( Color.WHITE );
        g2d.fill( new Rectangle2D.Double( x, y, largura, altura ) );

        
        // borda
        g2d.setColor( Color.BLACK );
        g2d.draw( new Rectangle2D.Double( x, y, largura - 1, altura - 1 ) );
        
        
        
        /*****************************************************
         ******* fim do código do desenho do cenário *********
         *****************************************************/
        
        g2d.dispose();
        
    }
    
}
