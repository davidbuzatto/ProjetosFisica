/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Modelo da massa aceleradora.
 * 
 * @author David Buzatto
 */
public class MassaAceleradora extends Sprite {
    
    public MassaAceleradora() {
        super( 0, 0, 20, 20 );
        desenharGuia = false;
    }
    
    @Override
    public void desenheMe( Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        
        AffineTransform at = new AffineTransform();
        at.rotate( Math.toRadians( rotacao ), getXCentro(), getYCentro() );
        g2d.setTransform( at );
        
        // só desenha no tamanho
        g2d.clip( new Rectangle2D.Double( x, y, largura + 1, altura + 1 ) );
        
        // guia
        if ( desenharGuia ) {
            Color corAntiga = g2d.getColor();
            g2d.setColor( new Color( 0, 102, 153, 100 ) );
            g2d.fill( new Rectangle2D.Double( x, y, largura, altura ) );
            g2d.setColor( corAntiga );
        }
        
        
        /**************************************************************
         ****** início do código do desenho da massa aceleradora ******
         **************************************************************/
        
        // desenha o carrinho
        g2d.setColor( new Color( 60, 60, 60 ) );
        g2d.fill( new Rectangle2D.Double( x, y, largura, altura ) );
        g2d.setColor( Color.BLACK );
        g2d.draw( new Rectangle2D.Double( x, y, largura, altura ) );
        
        
        /**************************************************************
         ******* fim do código do desenho da massa aceleradora ********
         **************************************************************/
        
        // libera o contexto gráfico
        g2d.dispose();
        
    }
    
}
