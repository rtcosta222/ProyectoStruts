/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanEmpleados;
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
public class Action14DetallesEmpleado extends org.apache.struts.action.Action {

    BeanEmpleados bean;
    RepositoryEmpleados repo;
    
    public Action14DetallesEmpleado() {
        this.bean = new BeanEmpleados();
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
        
        String empnoinc = request.getParameter("empnoinc");
        String empno = request.getParameter("empno");
        int z_empno;
        if(empnoinc != null) {
            z_empno = Integer.parseInt(empnoinc);
            this.repo.incrementarSalarioEmpleado(z_empno, 1);
        } else {
            z_empno = Integer.parseInt(empno);
        }
        
        Empleado z_emp = this.repo.getDetallesEmp(z_empno);
        request.setAttribute("EMPLEADO", z_emp);
        String html = this.bean.getDetallesEmp(z_empno);
        request.setAttribute("detallesEmp", html);
        return mapping.findForward("web14detallesempleado");
    }
}
