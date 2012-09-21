/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.ig;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import projetofisicamovimento.modelo.Cenario;
import projetofisicamovimento.modelo.Sprite;
import projetofisicamovimento.modelo.Tragetoria;

/**
 * Painel para desenhar as Sprites.
 * 
 * @author David Buzatto
 */
public class PainelDesenho extends JPanel {
    
    private Sprite sprite;
    private Cenario cenario;
    private Tragetoria tragetoria;
    private boolean desenharAjuda;
    private double xIni;
    private double yIni;
    
    public PainelDesenho() {
        cenario = new Cenario();
        //cenario = new Cenario( "/projetofisicamovimento/imagens/ceu.jpg" );
        tragetoria = new Tragetoria( 4, new Color( 255, 127, 39, 150 ) );
    }
    
    public void setSprite( Sprite sprite ) {
        this.sprite = sprite;
    }

    public boolean isDesenharAjuda() {
        return desenharAjuda;
    }

    public void setDesenharAjuda( boolean desenharAjuda ) {
        this.desenharAjuda = desenharAjuda;
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

    public Tragetoria getTragetoria() {
        return tragetoria;
    }

    public void setTragetoria( Tragetoria tragetoria ) {
        this.tragetoria = tragetoria;
    }

    private void fazerDesenhosAjuda( Sprite s, Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        
        g2d.setColor( new Color( 0, 102, 204, 100 ) );
        g2d.setStroke( new BasicStroke( 
                2, BasicStroke.CAP_SQUARE, 
                BasicStroke.JOIN_MITER, 10.0f, 
                new float[]{ 5 }, 0.0f ) );
        
        // desenha a caixa da sprite
        g2d.draw( new Rectangle2D.Double( 
                s.getX(), s.getY(), s.getLargura(), s.getAltura() ) );
        
        // desenha o eixo x
        g2d.draw( new Line2D.Double( 
                s.getX(), s.getYCentro(), s.getXFim(), s.getYCentro() ) );
        
        // desenha o eixo y
        g2d.draw( new Line2D.Double( 
                s.getXCentro(), s.getY(), s.getXCentro(), s.getYFim() ) );
        
        
        // valores
        g2d.setFont( new Font( Font.DIALOG, Font.PLAIN, 12 ) );
        g2d.setColor( new Color( 0, 0, 0, 100 ) );
        g2d.drawString( String.format( "início: (%.2f; %.2f)", 
                s.getX(), s.getY() ), 
                (float) s.getX(), (float) s.getYFim() + 15 );
        g2d.drawString( String.format( "centro: (%.2f; %.2f)",  
                s.getXCentro(), s.getYCentro() ), 
                (float) s.getX(), (float) s.getYFim() + 28 );
        g2d.drawString( String.format( "fim: (%.2f; %.2f)",  
                s.getXFim(), s.getYFim() ), 
                (float) s.getX(), (float) s.getYFim() + 41 );
        g2d.drawString( String.format( "vx: %.2f - vy: %.2f",  
                s.getVelocidadeX(), s.getVelocidadeY() ), 
                (float) s.getX(), (float) s.getYFim() + 54 );
        g2d.drawString( String.format( "ax: %.2f - ay: %.2f",  
                s.getAceleracaoX(), s.getAceleracaoY() ), 
                (float) s.getX(), (float) s.getYFim() + 67 );
        g2d.drawString( String.format( "largura: %.2f", s.getLargura() ), 
                (float) s.getX(), (float) s.getYFim() + 80 );
        g2d.drawString( String.format( "altura: %.2f", s.getAltura() ), 
                (float) s.getX(), (float) s.getYFim() + 93 );
        
        g2d.dispose();
        
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
        
        if ( desenharAjuda ) {
            tragetoria.desenheMe( g2d );
        }
        
        sprite.desenheMe( g2d );
        
        if ( desenharAjuda ) {
            fazerDesenhosAjuda( sprite, g2d );
        }
        
        g2d.dispose();
        
    }
    
}
