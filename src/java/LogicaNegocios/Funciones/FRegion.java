/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios.Funciones;

import AccesoDatos.AccesoDatos;
import AccesoDatos.ConjuntoResultado;
import AccesoDatos.Parametro;
import LogicaNegocios.Clases.Region;
import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */
public class FRegion {
     public static boolean insertarRegion(Region region) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, region.getReg_descripcion().toUpperCase()));
        String sql = "SELECT fn_region_insertar(?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
     
     public static boolean modificarRegion(Region region) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, region.getReg_id()));
        lstpar.add(new Parametro(2, region.getReg_descripcion().toUpperCase()));
        String sql = "SELECT fn_region_actualizar(?,?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
     
     public static boolean eliminarRegion(Region region) {
        boolean respuesta = false;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, region.getReg_id()));
        String sql = "SELECT fn_region_eliminar(?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
     
      public static ArrayList<Region> obtenerRegiones() {
        Region region = null;
        ArrayList<Region> lstregion = new ArrayList<>();
        String sql = "SELECT * FROM v_listar_region;";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql);
            while (cjres.next()) {
                region = new Region();
                region.setReg_id(cjres.getInt(0));
                region.setReg_descripcion(cjres.getString(1));
                lstregion.add(region);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstregion;
    }
      
      public static Region obtenerRegion(int codigo) {
        Region region = null;
        ArrayList<Parametro> lstpar = new ArrayList<>();
        lstpar.add(new Parametro(1, codigo));
        String sql = "select * from fn_region_consulta(?);";
        try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql, lstpar);
            while (cjres.next()) {
                region = new Region();
                region.setReg_id(cjres.getInt(0));
                region.setReg_descripcion(cjres.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return region;
    }
}
