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
import pojos.Usuario;
import utils.Conexion;

/**
 *
 * @author ardan
 */
public class ActualizarUsuarioDbaction {

    /**
     * Creates a new instance of ActualizarUsuarioDbaction
     */
    public ActualizarUsuarioDbaction() {
    }
    public Usuario validarUsuario(String usuario){
        Usuario resultado = new Usuario();
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "select correo, password, nombre, apellido, id_estado, id_rol from usuario where correo = '" + usuario + "'";
            //st.executeUpdate("insert into usuario values ('"+user+"', '"+pass+"', '"+passEncript+"')");
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){
                    resultado.setCorreo(rs.getString("correo"));   
                    resultado.setPassword(rs.getString("password"));
                    resultado.setNombre(rs.getString("nombre"));
                    resultado.setApellido(rs.getString("apellido"));
                    resultado.setIdEstado(rs.getInt("id_estado"));
                    resultado.setIdRol(rs.getInt("id_rol"));
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

    public int actualizarUsuario(String usuario, String password, String nombre, String apellido, int estado, int rol) {
       int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();  
            String sql = "UPDATE usuario SET password='" + password + "', nombre='" + nombre + "', apellido='" + apellido + "', id_estado=" + estado + ", id_rol=" + rol + " where correo='" + usuario + "'";
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
