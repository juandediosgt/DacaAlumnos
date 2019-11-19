/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.ActualizarUsuarioDbaction;
import javax.faces.model.SelectItem;
import pojos.Usuario;
import utils.Catalogos;
import utils.Messages;

/**
 *
 * @author ardan
 */
public class ActualizarUsuarioBean {
    private String usuario;
    private String password;
    private String nombre;
    private String apellido;
    private int estado;
    private int rol;
    private SelectItem[] listaRoles;
    private SelectItem[] listaEstados;
    private Usuario usuarioo;
    

    /**
     * Creates a new instance of MenuActualizarAlumnoBean
     */
    public ActualizarUsuarioBean() {
        cargarSpinners();
    }
    
    public String home(){
       String resultado="regresar";
               return resultado;
   }
     /**
     * Metodo que carga las areas de los alumnos
     */
    public void cargarSpinners(){
        Catalogos lista = new Catalogos();
        listaRoles = lista.cargarRoles();
        listaEstados = lista.cargarEstado();
    }
    
    /**
     * Metodo que consulta el alumno en funcion del carnet ingresado
     */
    public void consultarUsuario(){
        ActualizarUsuarioDbaction actualizar = new ActualizarUsuarioDbaction();
        this.usuarioo = actualizar.validarUsuario(this.getUsuario());
        if(usuarioo != null){
            this.setPassword(usuarioo.getPassword());
            this.setNombre(usuarioo.getNombre());
            this.setApellido(usuarioo.getApellido());
            this.setRol(usuarioo.getIdRol());
            this.setEstado(usuarioo.getIdEstado());
        }
    }
    
    /**
     * Metodo que valida el carnet del alumno para consultarlo
     */
     public void validarActualizacionUsuario(){
       if(this.getUsuario().equals("")  || this.getPassword().equals("")  || this.getNombre().equals("")  ||  this.getApellido().equals("")  || this.getEstado()==0  || this.getRol() == 0){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            ActualizarUsuarioDbaction user = new ActualizarUsuarioDbaction();
            int resultado = user.actualizarUsuario(this.getUsuario(), this.getPassword(), this.getNombre(), this.getApellido(), this.getEstado(), this.getRol());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Data del Alumno actualizada exitosamente");
            } else{
                Messages.errorMessage("ERROR", "Error al actualizar la data del Alumno");
            }
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public SelectItem[] getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(SelectItem[] listaRoles) {
        this.listaRoles = listaRoles;
    }

    public SelectItem[] getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(SelectItem[] listaEstados) {
        this.listaEstados = listaEstados;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public Usuario getUsuarioo() {
        return usuarioo;
    }

    public void setUsuarioo(Usuario usuarioo) {
        this.usuarioo = usuarioo;
    }

    
    
    
}
