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
 * Painel para os gráficos.
 * 
 * @author David Buzatto
 */
public class PainelGrafico extends JPanel {
    
    public enum TipoGrafico {
        ET,
        AT,
        VT
    }
    
    private List<Ellipse2D> pontosETDesenho;
    private List<Ellipse2D> pontosATDesenho;
    private List<Ellipse2D> pontosVTDesenho;
    private List<Point2D> pontosET;
    private List<Point2D> pontosAT;
    private List<Point2D> pontosVT;
    
    private double diametroPontos;
    private int fatorZoom;
    private boolean mostrarValores;
    private Color corPontosET;
    private Color corPontosAT;
    private Color corPontosVT;
    private int origemX;
    private int origemY;
    private int margemX;
    private int margemY;
    
    private TipoGrafico tipoGrafico;
    
    public PainelGrafico() {
        pontosETDesenho = new ArrayList<Ellipse2D>();
        pontosATDesenho = new ArrayList<Ellipse2D>();
        pontosVTDesenho = new ArrayList<Ellipse2D>();
        pontosET = new ArrayList<Point2D>();
        pontosAT = new ArrayList<Point2D>();
        pontosVT = new ArrayList<Point2D>();
        
        diametroPontos = 5;
        fatorZoom = 3;
        mostrarValores = true;
        corPontosET = new Color( 255, 153, 0 );
        corPontosAT = new Color( 6, 187, 248 );
        corPontosVT = new Color( 102, 204, 0 );
        
        origemX = 10;
        origemY = 10;
        margemX = 10;
        margemY = 10;
        
        tipoGrafico = TipoGrafico.ET;
        
    }

    private void adicionarPonto( double x, double y, List<Point2D> pontos, List<Ellipse2D> pontosDesenho ) {
        pontos.add( new Point2D.Double( x, y ) );
        pontosDesenho.add( new Ellipse2D.Double( 
                x - ( diametroPontos / 2 ), 
                y - ( diametroPontos / 2 ), 
                diametroPontos, 
                diametroPontos ) );
    }
    
    public void adicionarPontoEspacoVersusTempo( double x, double y ) {
        adicionarPonto( x, y, pontosET, pontosETDesenho );
    }
    
    public void adicionarPontoAceleracaoVersusTempo( double x, double y ) {
        adicionarPonto( x, y, pontosAT, pontosATDesenho );
    }
    
    public void adicionarPontoVelocidadeVersusTempo( double x, double y ) {
        adicionarPonto( x, y, pontosVT, pontosVTDesenho );
    }
    
    public void limparPontosEspacoVersusTempo() {
        pontosETDesenho.clear();
        pontosET.clear();
    }
    
    public void limparPontosAceleracaoVersusTempo() {
        pontosATDesenho.clear();
        pontosAT.clear();
    }
    
    public void limparPontosVelocidadeVersusTempo() {
        pontosVTDesenho.clear();
        pontosVT.clear();
    }
    
    public void limparTodosOsPontos() {
        limparPontosEspacoVersusTempo();
        limparPontosAceleracaoVersusTempo();
        limparPontosVelocidadeVersusTempo();
    }

    public Color getCorPontosET() {
        return corPontosET;
    }
    
    public Color getCorPontosAT() {
        return corPontosAT;
    }
    
    public Color getCorPontosVT() {
        return corPontosVT;
    }

    public void setCorPontosET( Color corPontosET ) {
        this.corPontosET = corPontosET;
    }
    
    public void setCorPontosAT( Color corPontosAT ) {
        this.corPontosAT = corPontosAT;
    }
    
    public void setCorPontosVT( Color corPontosVT ) {
        this.corPontosVT = corPontosVT;
    }

    public double getDiametroPontos() {
        return diametroPontos;
    }

    public void setDiametroPontos( double diametroPontos ) {
        this.diametroPontos = diametroPontos;
    }

    public int getFatorZoom() {
        return fatorZoom;
    }

    public void setFatorZoom( int fatorZoom ) {
        this.fatorZoom = fatorZoom;
    }

    public TipoGrafico getTipoGrafico() {
        return tipoGrafico;
    }

    public void setTipoGrafico( TipoGrafico tipoGrafico ) {
        this.tipoGrafico = tipoGrafico;
    }

    public boolean isMostrarValores() {
        return mostrarValores;
    }

    public void setMostrarValores( boolean mostrarValores ) {
        this.mostrarValores = mostrarValores;
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
        
        
        g2d.setColor( Color.BLACK );
        g2d.draw( new Line2D.Double( origemX, getHeight() - margemY, getWidth() - margemX, getHeight() - margemY ) );
        g2d.draw( new Line2D.Double( origemX, origemY, origemX, getHeight() - margemY ) );
        
        g2d.translate( 0, getHeight() );
        
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
        
        
        switch ( tipoGrafico ) {
            
            case ET:
                desenharPontos( g2d, "t", "S", corPontosET, corPontosET.darker(), pontosET, pontosETDesenho );
                break;
                
            case AT:
                desenharPontos( g2d, "t", "a", corPontosAT, corPontosAT.darker(), pontosAT, pontosATDesenho );
                break;
                
            case VT:
                desenharPontos( g2d, "t", "V", corPontosVT, corPontosVT.darker(), pontosVT, pontosVTDesenho );
                break;
            
        }
        
        
        g2d.dispose();
        
    }
    
    private void desenharPontos( 
            Graphics2D g2d, 
            String labelEixoX,
            String labelEixoY,
            Color corPontos, 
            Color corLinhaELegenda, 
            List<Point2D> pontos,
            List<Ellipse2D> pontosDesenho ) {
        
        g2d.drawString( labelEixoY, 1, - ( getHeight() - 25 ) );
        g2d.drawString( labelEixoX, getWidth() - 20, -12 );

        double menorX = 0;
        double maiorX = 0;
        double fatorX = 0;
        
        double menorY = 0;
        double maiorY = 0;
        double fatorY = 0;
        
        if ( !pontosDesenho.isEmpty() ) {
            Ellipse2D ponto = pontosDesenho.get( 0 );
            menorX = ponto.getX();
            maiorX = menorX;
            menorY = ponto.getY();
            maiorY = menorY;
        }
        
        for ( Ellipse2D p : pontosDesenho ) {
            if ( menorX > p.getX() ) {
                menorX = p.getX();
            }
            if ( maiorX < p.getX() ) {
                maiorX = p.getX();
            }
            if ( menorY > p.getY() ) {
                menorY = p.getY();
            }
            if ( maiorY < p.getY() ) {
                maiorY = p.getY();
            }
        }
        
        double largura = getWidth() - 130;
        double altura = getHeight() - 30;
        
        if ( maiorX != 0 ) {
            fatorX = largura / ( maiorX - menorX );
        }
        
        if ( maiorY != 0 ) {
            fatorY = altura / ( maiorY - menorY );
        }
        
        Path2D.Double path = new Path2D.Double();
        
        for ( int i = 0; i < pontosDesenho.size(); i++ ) { 
            
            Ellipse2D ponto = pontosDesenho.get( i );
            Point2D pontoReal = pontos.get( i );
            
            double x = ( ponto.getX() - menorX ) * fatorX;
            if ( Double.isNaN( x ) ) {
                x = 0;
            }
            
            double y = ( ponto.getY() - menorY ) * fatorY;
            if ( Double.isNaN( y ) ) {
                y = 0;
                
            }
            
            Ellipse2D novoPonto = new Ellipse2D.Double( 
                    x + margemX - + ponto.getWidth() / 2, 
                    - ( y + margemY + ponto.getHeight() / 2 ), 
                    ponto.getWidth(), ponto.getHeight() );

            if ( i == 0 ) {
                path.moveTo( novoPonto.getCenterX(), novoPonto.getCenterY() );
            } else {
                path.lineTo( novoPonto.getCenterX(), novoPonto.getCenterY() );
            }

            g2d.setColor( corPontos );
            System.out.println( novoPonto.getY() );
            g2d.fill( novoPonto );
            
            if ( mostrarValores ) {
                g2d.setColor( corLinhaELegenda );
                g2d.drawString( 
                        String.format( "%.2f; %.2f", pontoReal.getX(), pontoReal.getY() ), 
                        ( int ) ( novoPonto.getCenterX() + novoPonto.getWidth() + 2 ), 
                        ( int ) ( novoPonto.getCenterY() + novoPonto.getHeight() + 2 ) );
            }
        }

        g2d.setColor( corLinhaELegenda );
        g2d.draw( path );
                
    }
    
    /*private void desenharPontos( 
            Graphics2D g2d, 
            String labelEixoX,
            String labelEixoY,
            Color corPontos, 
            Color corLinhaELegenda, 
            List<Point2D> pontos,
            List<Ellipse2D> pontosDesenho ) {
        
        g2d.drawString( labelEixoY, 1, - ( getHeight() - 25 ) );
        g2d.drawString( labelEixoX, getWidth() - 20, -12 );

        Path2D.Double path = new Path2D.Double();

        for ( int i = 0; i < pontosDesenho.size(); i++ ) { 
            
            Ellipse2D ponto = pontosDesenho.get( i );
            Point2D pontoReal = pontos.get( i );

            Ellipse2D novoPonto = new Ellipse2D.Double( 
                    ( ponto.getX() / fatorZoom ) + margemX, 
                    - ( ( ponto.getY() / fatorZoom ) + margemY + ponto.getWidth() ), 
                    ponto.getWidth(), ponto.getHeight() );

            if ( i == 0 ) {
                path.moveTo( novoPonto.getCenterX(), novoPonto.getCenterY() );
            } else {
                path.lineTo( novoPonto.getCenterX(), novoPonto.getCenterY() );
            }

            g2d.setColor( corPontos );
            g2d.fill( novoPonto );
            
            if ( mostrarValores ) {
                g2d.setColor( corLinhaELegenda );
                g2d.drawString( 
                        String.format( "%.2f; %.2f", pontoReal.getX(), pontoReal.getY() ), 
                        ( int ) ( novoPonto.getCenterX() + novoPonto.getWidth() + 2 ), 
                        ( int ) ( novoPonto.getCenterY() + novoPonto.getHeight() + 2 ) );
            }
        }

        g2d.setColor( corLinhaELegenda );
        g2d.draw( path );
                
    }*/
    
}
