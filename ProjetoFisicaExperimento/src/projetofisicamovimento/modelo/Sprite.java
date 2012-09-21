/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofisicamovimento.modelo;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Sprite.
 * 
 * Contém os atributos base para qualquer objeto de desenho
 * do projeto.
 * 
 * @author David Buzatto
 */
public abstract class Sprite {

    protected double x;
    protected double y;
    protected double velocidadeX;
    protected double velocidadeY;
    protected double aceleracaoX;
    protected double aceleracaoY;
    protected double largura;
    protected double altura;
    protected double rotacao;
    protected Color corPreenchimento;
    protected Color corContorno;
    protected boolean desenharGuia;

    public Sprite() {
        this( 0, 0, 100, 100, Color.BLACK, Color.BLACK );
    }

    public Sprite( double x, double y, double largura, double altura ) {
        this( x, y, largura, altura, Color.BLACK, Color.BLACK );
    }

    public Sprite( double x, double y, double largura, double altura, Color corPreenchimento, Color corContorno ) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.corPreenchimento = corPreenchimento;
        this.corContorno = corContorno;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura( double altura ) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura( double largura ) {
        this.largura = largura;
    }

    public double getVelocidadeX() {
        return velocidadeX;
    }

    public void setVelocidadeX( double velocidadeX ) {
        this.velocidadeX = velocidadeX;
    }

    public double getVelocidadeY() {
        return velocidadeY;
    }

    public void setVelocidadeY( double velocidadeY ) {
        this.velocidadeY = velocidadeY;
    }

    public double getX() {
        return x;
    }

    public void setX( double x ) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY( double y ) {
        this.y = y;
    }
    
    public double getXFim() {
        return x + largura;
    }
    
    public double getYFim() {
        return y + altura;
    }

    public Color getCorContorno() {
        return corContorno;
    }

    public void setCorContorno( Color corContorno ) {
        this.corContorno = corContorno;
    }

    public Color getCorPreenchimento() {
        return corPreenchimento;
    }

    public void setCorPreenchimento( Color corPreenchimento ) {
        this.corPreenchimento = corPreenchimento;
    }

    public double getRotacao() {
        return rotacao;
    }

    public void setRotacao( double rotacao ) {
        this.rotacao = rotacao;
    }
    
    public double getXCentro() {
        return x + ( largura / 2 );
    }
    
    public double getYCentro() {
        return y + ( altura / 2 );
    }

    public double getAceleracaoX() {
        return aceleracaoX;
    }

    public void setAceleracaoX( double aceleracaoX ) {
        this.aceleracaoX = aceleracaoX;
    }

    public double getAceleracaoY() {
        return aceleracaoY;
    }

    public void setAceleracaoY( double aceleracaoY ) {
        this.aceleracaoY = aceleracaoY;
    }
    
    /**
     * Método para aumentar (valor > 0) ou diminuir (valor < 0) a 
     * aceleração em X.
     * 
     * @param valor Quantidade a aumentar a aceleração.
     */
    public void acelerarX( double valor ) {
        velocidadeX += valor;
    }
    
    /**
     * Método para aumentar (valor > 0) ou diminuir (valor < 0) a 
     * aceleração em Y.
     * 
     * @param valor Quantidade a aumentar a aceleração.
     */
    public void acelerarY( double valor ) {
        velocidadeY += valor;
    }
    
    /**
     * Método abstrato de desenho.
     * 
     * @param g2d Contexto gráfico.
     */
    public abstract void desenheMe( Graphics2D g2 );
    
}
