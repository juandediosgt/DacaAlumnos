/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.CambioContraseñaDbAction;
import java.io.Serializable;
import utils.Messages;

/**
 *
 * @author ardan
 */
public class CambioPassword implements Serializable{
    private String correo;
    private String Password;
    private String Comprobacion;
    
    /**
     * Creates a new instance of CambioPassword
     */
    public CambioPassword() {
        
    }
    
    /**
     * Metodo que valida el cambio de password
     * @return 
     */
    public String cambiarContraseña(){
        String result = "";
        if(this.getPassword().equals("") || this.getComprobacion().equals("")){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else if(this.getPassword().equals(this.getComprobacion())){
            CambioContraseñaDbAction usuario = new CambioContraseñaDbAction();
            IndexBean correo = new IndexBean();
            int resultado = usuario.cambiarContraseña(this.getPassword(), "");
            if(resultado == 1){
                result = "index";
            } else{
                Messages.errorMessage("ERROR", "Error al guardar el usuario");
            }
        }else{
            Messages.warningMessage("Advertencia", "Verifica tu contraseña");
        }
        return result;
    }

    //Metodos gets y sets
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getComprobacion() {
        return Comprobacion;
    }

    public void setComprobacion(String Comprobacion) {
        this.Comprobacion = Comprobacion;
    }
     
     
}
