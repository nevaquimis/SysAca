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
public class Usuario {
    private int usu_id;
    private String usu_usuario;
    private String usu_contrasenia;
    private int tipu_id;

    public Usuario() {
        this.usu_id=0;
        this.usu_usuario="";
        this.usu_contrasenia="";
    }

    public Usuario(int usu_id, String usu_usuario, String usu_contrasenia, int tipu_id) {
        this.usu_id = usu_id;
        this.usu_usuario = usu_usuario;
        this.usu_contrasenia = usu_contrasenia;
        this.tipu_id = tipu_id;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_usuario() {
        return usu_usuario;
    }

    public void setUsu_usuario(String usu_usuario) {
        this.usu_usuario = usu_usuario;
    }

    public String getUsu_contrasenia() {
        return usu_contrasenia;
    }

    public void setUsu_contrasenia(String usu_contrasenia) {
        this.usu_contrasenia = usu_contrasenia;
    }

    public int getTipu_id() {
        return tipu_id;
    }

    public void setTipu_id(int tipu_id) {
        this.tipu_id = tipu_id;
    }
    
    
}
