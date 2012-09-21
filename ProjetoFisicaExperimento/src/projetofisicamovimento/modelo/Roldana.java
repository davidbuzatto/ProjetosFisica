/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Modelo da roldana.
 * 
 * @author David Buzatto
 */
public class Roldana extends Sprite {
    
    public Roldana() {
        // x, y, largura, altura
        super( 0, 0, 15, 15 );
        desenharGuia = false;
    }
    
    @Override
    public void desenheMe( Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        
        AffineTransform at = new AffineTransform();
        at.rotate( Math.toRadians( rotacao ), getXCentro(), getYCentro() );
        g2d.setTransform( at );
        
        // só desenha no tamanho
        //g2d.clip( new Rectangle2D.Double( x, y, largura + 1, altura + 1 ) );
        
        // guia
        if ( desenharGuia ) {
            Color corAntiga = g2d.getColor();
            g2d.setColor( new Color( 0, 102, 153, 100 ) );
            g2d.fill( new Rectangle2D.Double( x, y, largura, altura ) );
            g2d.setColor( corAntiga );
        }
        
        
        /*****************************************************
         ****** início do código do desenho da roldana *******
         *****************************************************/
        
        // desenha a roldana
        g2d.setColor( new Color( 255, 255, 255 ) );
        g2d.fill( new Ellipse2D.Double( x, y, largura, altura ) );
        g2d.setColor( Color.BLACK );
        
        g2d.draw( new Line2D.Double( x, getYCentro(), getXFim(), getYCentro() ) );
        g2d.draw( new Line2D.Double( getXCentro(), y, getXCentro(), getYFim() ) );
        
        g2d.setStroke( new BasicStroke( 2 ) );
        
        g2d.draw( new Ellipse2D.Double( x, y, largura, altura ) );
        
        
        /*****************************************************
         ******* fim do código do desenho da roldana *********
         *****************************************************/
        
        // libera o contexto gráfico
        g2d.dispose();
        
    }
    
}
