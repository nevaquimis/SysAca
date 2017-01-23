/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios.Clases;

/**
 *
 * @author Vanessa
 */
public class TipoUsuario {
    public int tiu_id;
    public  String tiu_descripcion;

    public TipoUsuario() {
    }

    public TipoUsuario(int tiu_id, String tiu_descripcion) {
        this.tiu_id = tiu_id;
        this.tiu_descripcion = tiu_descripcion;
    }

    public int getTiu_id() {
        return tiu_id;
    }

    public void setTiu_id(int tiu_id) {
        this.tiu_id = tiu_id;
    }

    public String getTiu_descripcion() {
        return tiu_descripcion;
    }

    public void setTiu_descripcion(String tiu_descripcion) {
        this.tiu_descripcion = tiu_descripcion;
    }
}
