/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios.Funciones;

import AccesoDatos.AccesoDatos;
import AccesoDatos.ConjuntoResultado;
import AccesoDatos.Parametro;
import LogicaNegocios.Clases.Usuario;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanessa
 */
public class FUsuario {
    
     public static boolean insertarUsuario(Usuario usuario) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, usuario.getUsu_usuario()));
        lstpar.add(new Parametro(2, usuario.getUsu_contrasenia()));
        lstpar.add(new Parametro(3, usuario.getTipu_id()));
        String sql = "SELECT fn_usuario_insertar(?,?,?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public static boolean modificarUsuario(Usuario usuario) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, usuario.getUsu_id()));
         lstpar.add(new Parametro(2, usuario.getUsu_usuario()));
        lstpar.add(new Parametro(3, usuario.getUsu_contrasenia()));
        lstpar.add(new Parametro(4, usuario.getTipu_id()));
        String sql = "SELECT fn_usuario_actualizar(?,?,?,?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public static boolean eliminarTipoUsuario(Usuario usuario) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, usuario.getUsu_id()));
        String sql = "SELECT fn_usuario_eliminar(?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public static ArrayList<Usuario> obtenerUsuarios() {
        Usuario usuario = null;
        ArrayList<Usuario> lstUsuario = new ArrayList<>();
        String sql = "SELECT * FROM v_listar_usuario;";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql);
            while (cjres.next()) {
                usuario = new Usuario();
                usuario.setUsu_id(cjres.getInt(0));
                usuario.setUsu_usuario(cjres.getString(1));
                usuario.setUsu_contrasenia(cjres.getString(2));
                usuario.setTipu_id(cjres.getInt(3));
                lstUsuario.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstUsuario;
    }
    
    public static Usuario obtenerTipoUsuario(int codigo) {
        Usuario usuario = null;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, codigo));
        String sql = "select * from fn_usuario_consulta(?);";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql, lstpar);
            while (cjres.next()) {
                usuario = new Usuario();
                usuario.setUsu_id(cjres.getInt(0));
                usuario.setUsu_usuario(cjres.getString(1));
                usuario.setUsu_contrasenia(cjres.getString(2));
                usuario.setTipu_id(cjres.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
    
    public static ArrayList<Usuario> ObtenerUsuarios() {
        Usuario usuario = null;
        ArrayList<Usuario> lstusuario = new ArrayList<Usuario>();
        String sql = "SELECT * FROM v_listar_usuario;";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql);
            while (cjres.next()) {
                usuario = new Usuario();
                usuario.setUsu_id(cjres.getInt(0));
                usuario.setUsu_usuario(cjres.getString(1));
                usuario.setUsu_contrasenia(cjres.getString(2));
                usuario.setTipu_id(cjres.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstusuario;
    }
        
}
