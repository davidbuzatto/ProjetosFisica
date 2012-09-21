/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Tragetória do objeto.
 * 
 * @author David Buzatto
 */
public class Tragetoria extends Sprite {

    private List<Ellipse2D> pontos;
    private double diametroPonto;
    private Color corPonto;
    
    public Tragetoria( double diametroPonto, Color corPonto ) {
        pontos = new ArrayList();
        this.diametroPonto = diametroPonto;
        this.corPonto = corPonto;
    }
    
    public void adicionarPonto( double x, double y ) {
        pontos.add( new Ellipse2D.Double( 
                x - ( diametroPonto / 2 ), 
                y - ( diametroPonto / 2 ), 
                diametroPonto, 
                diametroPonto ) );
    }
    
    public void limparPontos() {
        pontos.clear();
    }

    public Color getCorPonto() {
        return corPonto;
    }

    public void setCorPonto( Color corPonto ) {
        this.corPonto = corPonto;
    }

    public double getDiametroPonto() {
        return diametroPonto;
    }

    public void setDiametroPonto( double diametroPonto ) {
        this.diametroPonto = diametroPonto;
    }
    
    @Override
    public void desenheMe( Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        g2d.setColor( corPonto );
        
        for ( Ellipse2D ponto : pontos ) {
            g2d.fill( ponto );
        }
        
        g2d.dispose();
        
    }
    
}
