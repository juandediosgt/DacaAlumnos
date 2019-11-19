/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbActions;

import java.io.Serializable;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class MenuNuevoAlumnoDbAction implements Serializable {

    /**
     * Creates a new instance of MenuNuevoAlumnoDbAction
     */
    public MenuNuevoAlumnoDbAction() {
    }
    
   /**
    * Metodo para ingresar un nuevo alumno
    * @param carne
    * @param nombre
    * @param apellido
    * @param area
    * @param ciclo
    * @param foto
    * @return 
    */
    public int ingresarAlumno(int carne, String nombre, String apellido, int area, int ciclo, String foto) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "insert into carnealumno(no_carne, nombre, apellido, id_area, ciclo, foto ) values('" + carne + "', '" + nombre + "', '" + apellido + "', " + area + ", '" + ciclo + "', '" + foto + "')";
            Statement pst = conn.createStatement();
            int resultado = pst.executeUpdate(sql);
            if (resultado == 1) {
                result = resultado;                
            } else {
                result = resultado;                
            }
        } catch (ConnectException | SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    
}
