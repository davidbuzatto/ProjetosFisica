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

/**
 * Modelo de uma bola.
 * 
 * @author David Buzatto
 */
public class Bola extends Sprite {

    public Bola() {
    }
    
    public Bola( double x, double y, double largura, double altura ) {
       super( x, y, largura, altura );
    }
    
    public Bola( double x, double y, double largura, double altura, 
            Color corPreenchimento, Color corContorno ) {
       super( x, y, largura, altura, corPreenchimento, corContorno );
    }
    
    @Override
    public void desenheMe( Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        
        AffineTransform at = new AffineTransform();
        at.rotate( Math.toRadians( rotacao ), getXCentro(), getYCentro() );
        g2d.setTransform( at );
        
        g2d.setColor( corPreenchimento );
        Ellipse2D.Double eP = new Ellipse2D.Double( x, y, largura, altura );
        g2d.fill( eP );
        
        g2d.setColor( corContorno );
        g2d.setStroke( new BasicStroke( 2 ) );
        Ellipse2D.Double eC = new Ellipse2D.Double( x, y, largura, altura );
        g2d.draw( eC );
        
        g2d.dispose();
        
    }
    
}
