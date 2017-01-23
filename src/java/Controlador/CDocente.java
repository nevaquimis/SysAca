/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import LogicaNegocios.Clases.Docente;
import LogicaNegocios.Funciones.FDocente;
import java.io.Serializable;
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
public class CDocente implements Serializable{
    private ArrayList<Docente> listaDocente;
    private Docente docenteNuevo;
    private Docente docenteSel;
    private List<Docente> filtered;

    public CDocente() {
        Cargar();
    }

    public CDocente(ArrayList<Docente> listaDocente, Docente docenteNuevo, Docente docenteSel, List<Docente> filtered) {
        this.listaDocente = listaDocente;
        this.docenteNuevo = docenteNuevo;
        this.docenteSel = docenteSel;
        this.filtered = filtered;
    }

    public ArrayList<Docente> getListaDocente() {
        return listaDocente;
    }

    public void setListaDocente(ArrayList<Docente> listaDocente) {
        this.listaDocente = listaDocente;
    }

    public Docente getDocenteNuevo() {
        return docenteNuevo;
    }

    public void setDocenteNuevo(Docente docenteNuevo) {
        this.docenteNuevo = docenteNuevo;
    }

    public Docente getDocenteSel() {
        return docenteSel;
    }

    public void setDocenteSel(Docente docenteSel) {
        this.docenteSel = docenteSel;
    }

    public List<Docente> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<Docente> filtered) {
        this.filtered = filtered;
    }
    
    public void Cargar(){
        listaDocente=FDocente.obtenerDocentes();
        docenteNuevo=new Docente();
        docenteSel=new Docente();        
    }
    
    public void ingresar() {
        if (FDocente.insertarDocente(docenteNuevo)) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Docente ingresado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            Cargar();
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error desconocido, consulte con el Administrador");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }

    public void modificar() {
        if (FDocente.modificarDocente(docenteSel)) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Modificado los datos del docente correctamente");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            Cargar();
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error desconocido,consulte con el Administrador");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }

    public void eliminar() {
        if (FDocente.eliminarDocente(docenteSel)) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Eliminado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            Cargar();
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error desconocido");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }
    
    
}
