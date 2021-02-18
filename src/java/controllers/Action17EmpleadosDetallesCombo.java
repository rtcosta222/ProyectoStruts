/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Empleado;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import repositories.RepositoryEmpleados;

/**
 *
 * @author lscar
 */
public class Action17EmpleadosDetallesCombo extends org.apache.struts.action.Action {

    RepositoryEmpleados repo;

    public Action17EmpleadosDetallesCombo() {
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
        
        DynaActionForm formulario = (DynaActionForm) form;
        String ui = formulario.get("idempleado").toString();
        int z_empno = Integer.parseInt(ui);
        Empleado z_emp = this.repo.getDetallesEmp(z_empno);
        request.setAttribute("EMPLEADO", z_emp);
        return mapping.findForward("web17empleadosdetallescombo");
    }
}
