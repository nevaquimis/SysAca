/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

/**
 *
 * @author Maritza
 */
public class Parametro {

    private int posicion;
    private Object valor;
    private int tipo;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Parametro() {
        posicion = 0;
        valor = null;
    }

    public Parametro(int posicion, Object valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    public Parametro(int posicion, Object valor, int tipo) {
        this.posicion = posicion;
        this.valor = valor;
        this.tipo = tipo;
    }
}
