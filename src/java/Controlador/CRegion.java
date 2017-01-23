/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import LogicaNegocios.Clases.Region;
import LogicaNegocios.Funciones.FRegion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vanessa
 */
@ManagedBean
@ViewScoped
public class CRegion {
    private ArrayList<Region> listaRegion;
    private Region regionNuevo;
    private Region regionSel;
    private List<Region> filtered;   

    public CRegion() {
        Cargar();
    }

    public CRegion(ArrayList<Region> listaRegion, Region regionNuevo, Region regionSel, List<Region> filtered) {
        this.listaRegion = listaRegion;
        this.regionNuevo = regionNuevo;
        this.regionSel = regionSel;
        this.filtered = filtered;
    }

    public ArrayList<Region> getListaRegion() {
        return listaRegion;
    }

    public void setListaRegion(ArrayList<Region> listaRegion) {
        this.listaRegion = listaRegion;
    }

    public Region getRegionNuevo() {
        return regionNuevo;
    }

    public void setRegionNuevo(Region regionNuevo) {
        this.regionNuevo = regionNuevo;
    }

    public Region getRegionSel() {
        return regionSel;
    }

    public void setRegionSel(Region regionSel) {
        this.regionSel = regionSel;
    }

    public List<Region> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<Region> filtered) {
        this.filtered = filtered;
    }
    
    private void Cargar() {
        listaRegion = FRegion.obtenerRegiones();
        regionNuevo = new Region();
        regionSel = new Region();
    }
    
    public void ingresar() {
        if (FRegion.insertarRegion(regionNuevo)) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingresado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            Cargar();
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error desconocido");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }
    
    public void modificar() {
        if (FRegion.modificarRegion(regionSel)) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Modificado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            Cargar();
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error desconocido");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }
    
    public void eliminar() {
        if (FRegion.eliminarRegion(regionSel)) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Eliminado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            Cargar();
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error desconocido");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }
}
