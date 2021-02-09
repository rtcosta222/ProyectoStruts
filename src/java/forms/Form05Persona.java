/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author lscar
 */
public class Form05Persona extends org.apache.struts.action.ActionForm {
    private String nombre;
    private String email;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        // Si errors está vacío, llegaremos hasta el Action. Si tiene contenido,
        // funciona de cortafuegos y no deja llegar a la Action si hay errores, 
        // o sea, nos devuelve a la View.
        if(getNombre() == null || getNombre().equals("")) {
            errors.add("nombre", new ActionMessage("error.nombre.obligatorio"));
        } else if(getEmail() == null || getEmail().equals("")) {
            errors.add("email", new ActionMessage("error.email.obligatorio"));
        } else if (getEdad() < 18) {
            errors.add("edad", new ActionMessage("error.edad.rango"));
        }
        return errors;
    }
}
