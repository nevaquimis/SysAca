/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios.Funciones;

import AccesoDatos.AccesoDatos;
import AccesoDatos.ConjuntoResultado;
import AccesoDatos.Parametro;
import LogicaNegocios.Clases.TipoUsuario;
import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */
public class FTipoUsuario {
    
    public static boolean insertarTipoUsuario(TipoUsuario tipo_usuario) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, tipo_usuario.tiu_descripcion));
        String sql = "SELECT fn_tipo_usuario_insertar(?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public static boolean modificarTipoUsuario(TipoUsuario tipo_usuario) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, tipo_usuario.getTiu_id()));
        lstpar.add(new Parametro(2, tipo_usuario.getTiu_descripcion()));
        String sql = "SELECT fn_tipo_usuario_actualizar(?,?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public static boolean eliminarTipoUsuario(TipoUsuario tipo_usuario) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, tipo_usuario.getTiu_id()));
        String sql = "SELECT fn_tipo_usuario_eliminar(?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public static ArrayList<TipoUsuario> obtenerTipoUsuarios() {
        TipoUsuario tipo_usuario = null;
        ArrayList<TipoUsuario> lsttipo_usuario = new ArrayList<>();
        String sql = "SELECT * FROM v_listar_tipo_usuario;";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql);
            while (cjres.next()) {
                tipo_usuario = new TipoUsuario();
                tipo_usuario.setTiu_id(cjres.getInt(0));
                tipo_usuario.setTiu_descripcion(cjres.getString(1));
                lsttipo_usuario.add(tipo_usuario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lsttipo_usuario;
    }
    
    public static TipoUsuario obtenerTipoUsuario(int codigo) {
        TipoUsuario tipo_usuario = null;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, codigo));
        String sql = "select * from fn_tipo_usuario_consulta(?);";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql, lstpar);
            while (cjres.next()) {
                tipo_usuario = new TipoUsuario();
                tipo_usuario.setTiu_id(cjres.getInt(0));
                tipo_usuario.setTiu_descripcion(cjres.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tipo_usuario;
    }
    
}
