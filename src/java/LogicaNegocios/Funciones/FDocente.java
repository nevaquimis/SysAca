/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios.Funciones;

import AccesoDatos.AccesoDatos;
import AccesoDatos.ConjuntoResultado;
import AccesoDatos.Parametro;
import LogicaNegocios.Clases.Docente;
import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */
public class FDocente {
    
    public static boolean insertarDocente(Docente docente) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, docente.getDoc_cedula()));
        lstpar.add(new Parametro(2, docente.getDoc_nombre().toUpperCase()));
        lstpar.add(new Parametro(3, docente.getDoc_apellido().toUpperCase()));
        lstpar.add(new Parametro(4, docente.getDoc_direccion().toUpperCase()));
        lstpar.add(new Parametro(5, docente.getDoc_telefono()));
        lstpar.add(new Parametro(6, docente.getDoc_celular()));
        lstpar.add(new Parametro(7, docente.getDoc_email()));
        String sql = "SELECT fn_docente_insertar(?,?,?,?,?,?,?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public static boolean modificarDocente(Docente docente) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, docente.getDoc_cedula()));
        lstpar.add(new Parametro(2, docente.getDoc_nombre().toUpperCase()));
        lstpar.add(new Parametro(3, docente.getDoc_apellido().toUpperCase()));
        lstpar.add(new Parametro(4, docente.getDoc_direccion().toUpperCase()));
        lstpar.add(new Parametro(5, docente.getDoc_telefono()));
        lstpar.add(new Parametro(6, docente.getDoc_celular()));
        lstpar.add(new Parametro(7, docente.getDoc_email()));
        String sql = "SELECT fn_docente_actualizar(?,?,?,?,?,?,?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public static boolean eliminarDocente(Docente docente) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, docente.getDoc_cedula()));
        String sql = "SELECT fn_docente_eliminar(?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

   public static ArrayList<Docente> obtenerDocentes() {
        Docente docente = null;
        ArrayList<Docente> lstdocente = new ArrayList<>();
        String sql = "SELECT * FROM v_listar_docente;";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql);
            while (cjres.next()) {
                docente = new Docente();
                docente.setDoc_cedula(cjres.getString(0));
                docente.setDoc_nombre(cjres.getString(1));
                docente.setDoc_apellido(cjres.getString(2));
                docente.setDoc_direccion(cjres.getString(3));
                docente.setDoc_telefono(cjres.getString(4));
                docente.setDoc_celular(cjres.getString(5));
                docente.setDoc_email(cjres.getString(6));
                lstdocente.add(docente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstdocente;
    }
    
    public static Docente obtenerDocente(String cedula) {
        Docente docente = null;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, cedula));
        String sql = "select * from fn_docente_consulta(?);";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql, lstpar);
            while (cjres.next()) {
                docente = new Docente();
                 docente.setDoc_cedula(cjres.getString(0));
                docente.setDoc_nombre(cjres.getString(1));
                docente.setDoc_apellido(cjres.getString(2));
                docente.setDoc_direccion(cjres.getString(3));
                docente.setDoc_telefono(cjres.getString(4));
                docente.setDoc_celular(cjres.getString(5));
                docente.setDoc_email(cjres.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return docente;
    }
    
}
