/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import forms.Form05Persona;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author lscar
 */
public class Action05Persona extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, 
                                ActionForm form,
                                HttpServletRequest request, 
                                HttpServletResponse response) throws Exception {
        
        Form05Persona formulario = (Form05Persona) form;
        String nombre = formulario.getNombre();
        String email = formulario.getEmail();
        int edad = formulario.getEdad();
        String html = "<h1>" + nombre + "</h1>";
        html += "<h1>" + email + "</h1>";
        html += "<h1>" + edad + "</h1>";
        request.setAttribute("datospersona", html);
        // Volvemos a la mismaa página.
        return mapping.getInputForward();
    }
}
