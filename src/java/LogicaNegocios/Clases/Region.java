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
public class Region {
    private int reg_id;
    private String reg_descripcion;

    public Region() {
    }

    public Region(int reg_id, String reg_descripcion) {
        this.reg_id = reg_id;
        this.reg_descripcion = reg_descripcion;
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public String getReg_descripcion() {
        return reg_descripcion;
    }

    public void setReg_descripcion(String reg_descripcion) {
        this.reg_descripcion = reg_descripcion;
    } 
    
}
