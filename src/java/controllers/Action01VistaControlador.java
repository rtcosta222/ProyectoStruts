/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author lscar
 */
public class Action01VistaControlador extends org.apache.struts.action.Action {

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
        // La info viene con un form del tipo DynaActionForm
        DynaActionForm formulario = (DynaActionForm) form;
        String respuesta = formulario.get("respuesta").toString();
        int valor = Integer.parseInt(respuesta);
        if (valor == 4) {
            // Respuesta correcta. Le envimos el usuario a otra página.
            return mapping.findForward("respuestacorrecta");
        } else {
            // Respuesta incorrecta. Le mantenemos en la misma
            // página de la petición.
            return mapping.getInputForward();
        }
    }
}
