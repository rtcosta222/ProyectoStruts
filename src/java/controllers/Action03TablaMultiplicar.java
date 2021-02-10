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
public class Action03TablaMultiplicar extends org.apache.struts.action.Action {

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
        
        DynaActionForm formulario = (DynaActionForm) form;
        String z_ui = formulario.get("respuesta").toString();
        int z_multiplicando = Integer.parseInt(z_ui);
        String html = "";
        for(int i=1; i<=10; i++) {
            html += "<tr><td>" + i + " * " + z_multiplicando + " = " + (i*z_multiplicando) + "</td></tr>";
        }
        request.setAttribute("tablamulti", html);
        // Volvemos a la mismaa página.
        return mapping.getInputForward();
    }
}
