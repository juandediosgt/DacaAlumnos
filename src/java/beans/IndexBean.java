/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.CambioContraseñaDbAction;
import dbActions.IndexDbAction;
import java.io.Serializable;
import pojos.Usuario;
import utils.Messages;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ismael Ruiz
 */
public class IndexBean implements Serializable {

    //Atributos de la clase
    private String correo;
    private String password;
    private String newpass;
    private CambioPassword user;

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }

    /**
     * Metodo que valida el usuario y el password
     *
     * @return
     */
    public String validarUsuario() {
        String resultado = "";
        Usuario usuarioValidado = new Usuario();
        try {
            if (this.getCorreo().equals("") || this.getPassword().equals("")) {
                Messages.infoMessage("Mensaje de usuario", "Debe llenar los dos campos obligatoriamente");
            } else {
                IndexDbAction dbAction = new IndexDbAction();
                usuarioValidado = dbAction.validarUsuario(this.getCorreo(), this.getPassword());
                if (usuarioValidado != null) {
                    if (usuarioValidado.getIdEstado() != 1) {
                        resultado = "error";
                        Messages.errorMessage("Error", "Usuario inactivo!!!");
                    } else if (usuarioValidado.getCorreo().equals(usuarioValidado.getPassword())) {
                        resultado = "cambiocontrasena";
                    } else if (usuarioValidado.getIdEstado() == 1 && usuarioValidado.getIdRol() == 1) {
                        resultado = "administrador";
                    } else if (usuarioValidado.getIdEstado() == 1 && usuarioValidado.getIdRol() == 2) {
                        resultado = "supervisor";
                    } else if (usuarioValidado.getIdEstado() == 1 && usuarioValidado.getIdRol() == 3) {
                        resultado = "usuario";
                    } else {
                        resultado = "error";
                        Messages.errorMessage("Error", "Usuario y /o Contraseña incorrectos");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public String getCorreo() {
        return correo;
    }

    //Metodos gets y sets
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CambioPassword getUser() {
        return user;
    }

    public void setUser(CambioPassword user) {
        this.user = user;
    }

}
