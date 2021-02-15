/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Empleado;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import repositories.RepositoryEmpleados;

/**
 *
 * @author lscar
 */
public class Action14ApellidoEmpleados extends org.apache.struts.action.Action {
    // Creating thw variable
    RepositoryEmpleados repo;
    // Instantiating the class (new object created).
    public Action14ApellidoEmpleados() {
        this.repo = new RepositoryEmpleados();
    }
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList<Empleado> emps = this.repo.getEmpleados();
        request.setAttribute("allemps", emps);
        return mapping.findForward("web14empleados");    
    }
}
