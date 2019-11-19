/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbActions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.model.SelectItem;
import pojos.Alumno;
import utils.Catalogos;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class MenuConsultaAlumnoDbAction {

    /**
     * Creates a new instance of MenuConsultaAlumnoDbAction
     */
    public MenuConsultaAlumnoDbAction() {  
    }
 
     public Alumno validarAlumnoCarne(int carne){
        Alumno resultado = new Alumno();
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "select no_carne, nombre, apellido, id_area, ciclo from carnealumno where no_carne = " + carne + "";
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
     
     public Alumno validarAlumnoNombre(String nombre){
        Alumno resultado = new Alumno();
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "select no_carne, nombre, apellido, id_area, ciclo from carnealumno where nombre= '" + nombre + "'";
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
}
