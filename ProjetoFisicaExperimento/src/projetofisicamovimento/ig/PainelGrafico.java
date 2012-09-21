/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.ig;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Painel para o gráfico S x t.
 * 
 * @author David Buzatto
 */
public class PainelGrafico extends JPanel {
    
    private List<Ellipse2D> pontosDesenho;
    private List<Point2D> pontos;
    private double diametroPontos;
    private Color corPontos;
    
    public PainelGrafico() {
        pontosDesenho = new ArrayList<Ellipse2D>();
        pontos = new ArrayList<Point2D>();
        this.diametroPontos = 5;
        this.corPontos = new Color( 255, 127, 39, 150 );
    }

    public void adicionarPonto( double x, double y ) {
        pontos.add( new Point2D.Double( x, y ) );
        pontosDesenho.add( new Ellipse2D.Double( 
                x - ( diametroPontos / 2 ), 
                y - ( diametroPontos / 2 ), 
                diametroPontos, 
                diametroPontos ) );
    }
    
    public void limparPontos() {
        pontosDesenho.clear();
        pontos.clear();
    }

    public List<Point2D> getPontos() {
        return pontos;
    }

    public Color getCorPontos() {
        return corPontos;
    }

    public void setCorPontos( Color corPontos ) {
        this.corPontos = corPontos;
    }

    public double getDiametroPontos() {
        return diametroPontos;
    }

    public void setDiametroPontos( double diametroPontos ) {
        this.diametroPontos = diametroPontos;
    }
    
    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        
        Graphics2D g2d = ( Graphics2D ) g.create();
        g2d.setRenderingHint( 
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON );
        
        // fundo
        g2d.setColor( Color.WHITE );
        g2d.fill( new Rectangle2D.Double( 0, 0, getWidth(), getHeight() ) );
        
        // borda
        g2d.setColor( Color.BLACK );
        g2d.draw( new Rectangle2D.Double( 0, 0, getWidth() - 1, getHeight() - 1 ) );
        
        
        // linhas do gráfico
        int origemX = 10;
        int origemY = 10;
        int margemX = 10;
        int margemY = 10;
        
        g2d.setColor( Color.BLACK );
        g2d.draw( new Line2D.Double( origemX, getHeight() - margemY, getWidth() - margemX, getHeight() - margemY ) );
        g2d.draw( new Line2D.Double( origemX, origemY, origemX, getHeight() - margemY ) );
        
        g2d.translate( 0, getHeight() );
        
        g2d.drawString( "S", 1, - ( getHeight() - 25 ) );
        g2d.drawString( "t", getWidth() - 20, -12 );
        
        Path2D flechaS = new Path2D.Double();
        flechaS.moveTo( 6, - ( getHeight() - 10 ) );
        flechaS.lineTo( 11, - ( getHeight() - 5 ) );
        flechaS.lineTo( 16, - ( getHeight() - 10 ) );
        flechaS.closePath();
        
        Path2D flechaT = new Path2D.Double();
        flechaT.moveTo( getWidth() - 10, -5 );
        flechaT.lineTo( getWidth() - 5, -10 );
        flechaT.lineTo( getWidth() - 10, -15 );
        flechaT.closePath();
        
        g2d.fill( flechaS );
        g2d.fill( flechaT );
        
        
        
        // área
        if ( !pontosDesenho.isEmpty() ) {
            
            g2d.setColor( new Color( 0, 102, 153, 60 ) );
            
            Path2D area = new Path2D.Double();
            boolean primeiroPonto = true;
            double ultimoX = 0;

            for ( Ellipse2D ponto : pontosDesenho ) {

                if ( primeiroPonto ) {
                    area.moveTo( ponto.getX() + margemX + 2, -origemY );
                    primeiroPonto = false;
                }

                ultimoX = ponto.getX() + margemX + 2;
                area.lineTo( ultimoX, 
                        - ( ponto.getY() + margemY + ponto.getWidth() - 2 ) );
            }

            area.lineTo( ultimoX, -origemY );
            area.closePath();

            g2d.fill( area );
            
        }
        
        
        
        // pontos do gráfico
        g2d.setColor( corPontos );
        
        for ( Ellipse2D ponto : pontosDesenho ) {
            Ellipse2D novoPonto = new Ellipse2D.Double( 
                    ponto.getX() + margemX, 
                    - ( ponto.getY() + margemY + ponto.getWidth() ), 
                    ponto.getWidth(), ponto.getHeight() );
            g2d.fill( novoPonto );
        }
        
        g2d.dispose();
        
    }
    
}
