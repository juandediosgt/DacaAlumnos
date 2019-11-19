/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojos.Usuario;
import utils.Conexion;

/**
 *
 * @author ardan
 */
public class VerUsuariosBean implements Serializable{
    
    
    /**
     * Creates a new instance of VerUsuarios2Bean
     */
    public VerUsuariosBean() {
    }
    public String home(){
        String resultado = "home";
        return resultado;
    }
    public List<Usuario> listar(){
        List<Usuario> ListaUsuario = new ArrayList();
                
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "SELECT usuario.correo, usuario.password, usuario.nombre, usuario.apellido, usuario.id_estado, estado.descripcion AS estado, usuario.id_rol, rol.descripcion AS rol, usuario.fecha_creacion FROM usuario, rol, estado WHERE usuario.id_estado = estado.id_estado AND usuario.id_rol = rol.id_rol AND usuario.id_estado = 1";
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){ ListaUsuario.add(new Usuario(rs.getString("correo"),
                    rs.getString("password"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("id_estado"),
                    rs.getString("estado"),
                    rs.getInt("id_rol"),
                    rs.getString("rol"),
                    rs.getDate("fecha_creacion")));
                    }
            }
            else{
            }
        } catch(ConnectException | SQLException ex){
            ex.printStackTrace();                    
        }        
        return ListaUsuario;
    }

}