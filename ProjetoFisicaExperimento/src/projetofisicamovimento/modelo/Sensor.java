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
 * Modelo do sensor.
 * 
 * @author David Buzatto
 */
public class Sensor extends Sprite {
    
    private boolean ativado;
    private Color corAtivado;
    
    public Sensor() {
        // x, y, largura, altura
        super( 0, 0, 11, 50 );
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
        
        
        /*****************************************************
         ******* início do código do desenho do sensor *******
         *****************************************************/
        
        // desenha o sensor
        if ( ativado ) {
            g2d.setColor( corAtivado );
        } else {
            g2d.setColor( new Color( 150, 150, 150 ) );
        }
        
        g2d.fill( new Rectangle2D.Double( x, y, largura, altura ) );
        g2d.setColor( Color.BLACK );
        g2d.draw( new Rectangle2D.Double( x, y, largura, altura ) );
        
        
        /*****************************************************
         ******** fim do código do desenho do senhor *********
         *****************************************************/
        
        // libera o contexto gráfico
        g2d.dispose();
        
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado( boolean ativado ) {
        this.ativado = ativado;
    }

    public Color getCorAtivado() {
        return corAtivado;
    }

    public void setCorAtivado( Color corAtivado ) {
        this.corAtivado = corAtivado;
    }
    
}
