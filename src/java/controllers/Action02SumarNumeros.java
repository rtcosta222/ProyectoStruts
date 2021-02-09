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
public class Action02SumarNumeros extends org.apache.struts.action.Action {

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
        String dato1 = formulario.get("numero1").toString();
        String dato2 = formulario.get("numero2").toString();
        int numero1 = Integer.parseInt(dato1);
        int numero2 = Integer.parseInt(dato2);
        int suma = numero1 + numero2;
        String html = "<h1 style='color:blue'>";
        html += "La suma es " + suma;
        html += "</h1>";
        request.setAttribute("suma", html);
        return mapping.getInputForward();
    }
}
