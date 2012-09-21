/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Modelo da linha de tração.
 * 
 * @author David Buzatto
 */
public class Linha extends Sprite {
    
    private Carrinho carrinho;
    private Roldana roldana;
    private MassaAceleradora massaAceleradora;
    
    public Linha() {
        // largura e altura nesse caso são desnecessários
        super( 0, 0, 0, 0 );
        desenharGuia = true;
    }
    
    @Override
    public void desenheMe( Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        
        AffineTransform at = new AffineTransform();
        at.rotate( Math.toRadians( rotacao ), getXCentro(), getYCentro() );
        g2d.setTransform( at );
        
        // guia
        if ( desenharGuia ) {
            Color corAntiga = g2d.getColor();
            g2d.setColor( new Color( 0, 102, 153, 100 ) );
            g2d.fill( new Rectangle2D.Double( x, y, largura, altura ) );
            g2d.setColor( corAntiga );
        }
        
        
        /*****************************************************
         ******* início do código do desenho da linha ********
         *****************************************************/
        
        // desenha a linha
        g2d.setColor( Color.BLACK );
        g2d.draw( new Line2D.Double( 
                carrinho.getXCentro(), carrinho.getYCentro(),
                roldana.getXCentro(), roldana.getYCentro() - roldana.getAltura() / 2 ) );
        g2d.draw( new Line2D.Double( 
                roldana.getXCentro() + roldana.getLargura() / 2, roldana.getYCentro(),
                massaAceleradora.getXCentro(), massaAceleradora.getYCentro() ) );
        
        
        /*****************************************************
         ******** fim do código do desenho do linha **********
         *****************************************************/
        
        // libera o contexto gráfico
        g2d.dispose();
        
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho( Carrinho carrinho ) {
        this.carrinho = carrinho;
    }

    public MassaAceleradora getMassaAceleradora() {
        return massaAceleradora;
    }

    public void setMassaAceleradora( MassaAceleradora massaAceleradora ) {
        this.massaAceleradora = massaAceleradora;
    }

    public Roldana getRoldana() {
        return roldana;
    }

    public void setRoldana( Roldana roldana ) {
        this.roldana = roldana;
    }
    
}
