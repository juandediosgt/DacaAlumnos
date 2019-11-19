/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Juan de Dios
 */
public class MenuAlumnoBean {
       
        

    /**
     * Creates a new instance of MenuAlumnoBean
     */
    public MenuAlumnoBean() {
    }
   
   public String irmenuNuevoAlumno(){
       String resultado="crear";
               return resultado;
   }
    public String irMenuActualizarAlumno(){
        String resultado = "actualizar";
        return resultado;
    }
    public String irMenuConsultarAlumno(){
        String resultado = "ver";
        return resultado;
    }
     public String cerrarSesion(){
       String resultado="salir";
               return resultado;
   }
       
}
