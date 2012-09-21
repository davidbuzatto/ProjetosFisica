/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Cenário da animação.
 * 
 * @author David Buzatto
 */
public class Cenario extends Sprite {
    
    private BufferedImage imagem;
    
    public Cenario() {
    }
    
    public Cenario( String caminhoImagem ) {
        
        try {
            InputStream input = getClass().getResourceAsStream( caminhoImagem );
            if ( input != null ) {
                imagem = ImageIO.read( input );
            }
        } catch ( IOException exc ) {
            exc.printStackTrace();
        }
        
    }
    
    public void desenheMe( Graphics2D g2 ) {
        
        Graphics2D g2d = ( Graphics2D ) g2.create();
        
        /*****************************************************
         ****** início do código do desenho do cenário *******
         *****************************************************/
        
        
        
        g2d.setColor( Color.WHITE );
        g2d.fill( new Rectangle2D.Double( x, y, largura, altura ) );
        
        if ( imagem != null ) {
            g2d.drawImage( imagem, 0, 0, null );
        }
        
        g2d.setColor( Color.BLACK );
        g2d.draw( new Rectangle2D.Double( x, y, largura - 1, altura - 1 ) );
        
        
        
        /*****************************************************
         ******* fim do código do desenho do cenário *********
         *****************************************************/
        
        g2d.dispose();
        
    }
    
}
