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
public class Docente {
    public String doc_cedula;
    public String doc_nombre;
    public String doc_apellido;
    public String doc_direccion;
    public  String doc_telefono;
    public String  doc_celular;
    public String doc_email;

    public Docente() {
    }

    public Docente(String doc_cedula, String doc_nombre, String doc_apellido, String doc_direccion, String doc_telefono, String doc_celular, String doc_email) {
        this.doc_cedula = doc_cedula;
        this.doc_nombre = doc_nombre;
        this.doc_apellido = doc_apellido;
        this.doc_direccion = doc_direccion;
        this.doc_telefono = doc_telefono;
        this.doc_celular = doc_celular;
        this.doc_email = doc_email;
    }

    public String getDoc_cedula() {
        return doc_cedula;
    }

    public void setDoc_cedula(String doc_cedula) {
        this.doc_cedula = doc_cedula;
    }

    public String getDoc_nombre() {
        return doc_nombre;
    }

    public void setDoc_nombre(String doc_nombre) {
        this.doc_nombre = doc_nombre;
    }

    public String getDoc_apellido() {
        return doc_apellido;
    }

    public void setDoc_apellido(String doc_apellido) {
        this.doc_apellido = doc_apellido;
    }

    public String getDoc_direccion() {
        return doc_direccion;
    }

    public void setDoc_direccion(String doc_direccion) {
        this.doc_direccion = doc_direccion;
    }

    public String getDoc_telefono() {
        return doc_telefono;
    }

    public void setDoc_telefono(String doc_telefono) {
        this.doc_telefono = doc_telefono;
    }

    public String getDoc_celular() {
        return doc_celular;
    }

    public void setDoc_celular(String doc_celular) {
        this.doc_celular = doc_celular;
    }

    public String getDoc_email() {
        return doc_email;
    }

    public void setDoc_email(String doc_email) {
        this.doc_email = doc_email;
    }
    
}
