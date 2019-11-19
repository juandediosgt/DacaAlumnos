/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import dbActions.MenuNuevoAlumnoDbAction;
import java.util.Calendar;
import javax.faces.model.SelectItem;
import utils.Catalogos;
import utils.Messages;

/**
 *
 * @author Juan de Dios
 */
public class MenuNuevoAlumnoBean {
        private int carne;
        private String nombre;
        private String apellido;
        private int area;
        private int ciclo = Calendar.getInstance().get(Calendar.YEAR);
        private String foto;
           private SelectItem[] listaAreas;

    /**
     * Creates a new instance of MenuNuevoAlumnoBean
     */
    public MenuNuevoAlumnoBean() {
        cargarAreas();
    }
    
     public String irMenuPricipal(){
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
    
    public void validarAlumno(){
       if(this.getCarne()==0  || this.getNombre().equals("")  ||  this.getApellido().equals("")  || this.getCiclo()==0  || this.getFoto().equals("")  || this.getArea()== -1){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            MenuNuevoAlumnoDbAction user = new MenuNuevoAlumnoDbAction();
            int resultado = user.ingresarAlumno(this.getCarne(), this.getNombre(), this.getApellido(), this.getArea(), this.getCiclo(), this.getFoto());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Alumno ingresado exitosamente");
            } else{
                Messages.errorMessage("ERROR", "Error al  el Alumno");
            }
        }
    }

    
    //Metodos gets y sets
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public SelectItem[] getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(SelectItem[] listaAreas) {
        this.listaAreas = listaAreas;
    }
    
    
}
