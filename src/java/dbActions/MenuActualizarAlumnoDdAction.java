/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbActions;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojos.Alumno;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class MenuActualizarAlumnoDdAction {

    /**
     * Creates a new instance of MenuActualizarAlumnoBdAction
     */
    public MenuActualizarAlumnoDdAction() {
    }
    
     public Alumno validarAlumno(int carne){
        Alumno resultado = new Alumno();
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "select no_carne, nombre, apellido, id_area, ciclo, foto from carnealumno where no_carne = " + carne + "";
            //st.executeUpdate("insert into usuario values ('"+user+"', '"+pass+"', '"+passEncript+"')");
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){
                    resultado.setCarne(rs.getInt("no_carne"));            
                    resultado.setNombre(rs.getString("nombre"));
                    resultado.setApellido(rs.getString("apellido"));
                    resultado.setArea(rs.getInt("id_area"));
                    resultado.setCiclo(rs.getInt("ciclo"));
                    resultado.setFoto(rs.getString("foto"));
                }
            }
            else{
                resultado = null;
            }
        } catch(Exception ex){
            ex.printStackTrace();                    
        }        
        return resultado;
    }
     
     /**
    * Metodo para ingresar un Actualizar Alumno
    * @param carne
    * @param nombre
    * @param apellido
    * @param area
    * @param ciclo
    * @param foto
    * @return 
    */
    public int actualizarAlumno(int carne, String nombre, String apellido, int area, int ciclo, String foto) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();  
            String sql = "UPDATE carnealumno SET nombre='" + nombre + "', apellido='" + apellido + "', id_area=" + area + ", ciclo='" + ciclo + "', foto='" + foto +"' where no_carne='" + carne + "'";
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
