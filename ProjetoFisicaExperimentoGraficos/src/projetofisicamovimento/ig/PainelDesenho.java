/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.ig;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import projetofisicamovimento.modelo.Cenario;
import projetofisicamovimento.modelo.Sprite;

/**
 * Painel para desenhar as Sprites.
 * 
 * @author David Buzatto
 */
public class PainelDesenho extends JPanel {
    
    private List<Sprite> sprites;
    private Cenario cenario;
    private double xIni;
    private double yIni;
    
    public PainelDesenho() {
        cenario = new Cenario();
        sprites = new ArrayList<Sprite>();
    }
    
    public void addSprite( Sprite sprite ) {
        sprites.add( sprite );
    }

    public double getXIni() {
        return xIni;
    }

    public void setXIni(double xIni) {
        this.xIni = xIni;
    }

    public double getYIni() {
        return yIni;
    }

    public void setYIni(double yIni) {
        this.yIni = yIni;
    }
    
    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        
        Graphics2D g2d = ( Graphics2D ) g.create();
        g2d.setRenderingHint( 
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON );
        
        cenario.setLargura( getWidth() );
        cenario.setAltura( getHeight() );
        cenario.desenheMe( g2d );
        
        for ( Sprite s : sprites ) {
            s.desenheMe( g2d );
        }
        
        g2d.dispose();
        
    }
    
}
