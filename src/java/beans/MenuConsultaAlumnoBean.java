/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.MenuActualizarAlumnoDdAction;
import dbActions.MenuConsultaAlumnoDbAction;
import java.util.Calendar;
import javax.faces.model.SelectItem;
import pojos.Alumno;
import utils.Catalogos;
import utils.Messages;

/**
 *
 * @author Juan de Dios
 */
public class MenuConsultaAlumnoBean {
    private int carne;
    private String nombre;
    private String apellido;
    private int area;
    private int ciclo = Calendar.getInstance().get(Calendar.YEAR);
    private SelectItem[] listaAreas;
    private Alumno alumno;
    
    private int opcionBusqueda;
    private boolean actCarne;
    private boolean actNombre;
    private boolean actApellido;
    private boolean actArea;
    private boolean actCiclo;
    

    /**
     * Creates a new instance of MenuConsultaAlumnoBean
     */
    public MenuConsultaAlumnoBean() {
         cargarAreas();
    }
    
    public String irmenuAlumno(){
       String resultado="regresar";
               return resultado;
   }
       /**
     * Metodo que carga las areas de los alumnos
     */
    public void cargarAreas(){
        Catalogos lista = new Catalogos();
        listaAreas = lista.cargarAreas();
    }
     /**
     * Metodo que borra los datos de los inputTex
     */
    public void limpiarCampos(){
        this.carne= 0;
        this.nombre=null;
        this.apellido=null;
        this.area=0;
        this.ciclo=0;    
    }
    
    
    /**
    * Metodo que gestiona las opciones de busqueda
    *
    * @param opcion
    */
    public void accionesConsulta(int opcion) {
    switch (opcion) {
        case 1:
            limpiarCampos();
            this.setActCarne(false);
            this.setActNombre(true);
            this.setActApellido(true);
            this.setActArea(true);
            this.setActCiclo(true);
            this.setOpcionBusqueda(1);
            break;
        case 2:
            limpiarCampos();
            this.setActNombre(false);
            this.setActCarne(true);
            this.setActApellido(true);
            this.setActArea(true);
            this.setActCiclo(true);
            this.setOpcionBusqueda(2);
            break;
        default:
            break;
        }
    }
    
    public void consultarAlumno() {
    switch (this.opcionBusqueda) {
        case 1: {
            Alumno alumno = new Alumno();
            MenuConsultaAlumnoDbAction consulta = new MenuConsultaAlumnoDbAction();
            alumno = consulta.validarAlumnoCarne(this.getCarne());
            if (alumno == null) {
                Messages.errorMessage("Error", "Alumno no encontrado");
            } else {
                this.setCarne(alumno.getCarne());
                this.setNombre(alumno.getNombre());
                this.setApellido(alumno.getApellido());
                this.setArea(alumno.getArea ());
                this.setCiclo(alumno.getCiclo ());
            }
            break;
        }
        case 2: {
            Alumno alumno = new Alumno();
            MenuConsultaAlumnoDbAction consulta = new MenuConsultaAlumnoDbAction();
            alumno = consulta.validarAlumnoNombre(this.getNombre());
            if (alumno == null) {
                Messages.errorMessage("Error", "Alumno no encontrado");
            } else {
                this.setCarne(alumno.getCarne());
                this.setNombre(alumno.getNombre());
                this.setApellido(alumno.getApellido());
                this.setArea(alumno.getArea());
                this.setCiclo(alumno.getCiclo());
            }
            break;
        }
        default:
            break;
    }
}
    
    
    //metodos Get y SET
    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public SelectItem[] getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(SelectItem[] listaAreas) {
        this.listaAreas = listaAreas;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getOpcionBusqueda() {
        return opcionBusqueda;
    }

    public void setOpcionBusqueda(int opcionBusqueda) {
        this.opcionBusqueda = opcionBusqueda;
    }

    public boolean isActCarne() {
        return actCarne;
    }

    public void setActCarne(boolean actCarne) {
        this.actCarne = actCarne;
    }

    public boolean isActNombre() {
        return actNombre;
    }

    public void setActNombre(boolean actNombre) {
        this.actNombre = actNombre;
    }

    public boolean isActApellido() {
        return actApellido;
    }

    public void setActApellido(boolean actApellido) {
        this.actApellido = actApellido;
    }

    public boolean isActArea() {
        return actArea;
    }

    public void setActArea(boolean actArea) {
        this.actArea = actArea;
    }

    public boolean isActCiclo() {
        return actCiclo;
    }

    public void setActCiclo(boolean actCiclo) {
        this.actCiclo = actCiclo;
    } 
}
