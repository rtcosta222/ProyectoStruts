/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanEmpleados;
import java.util.ArrayList;
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
public class Action18EmpleadosOficioCombo extends org.apache.struts.action.Action {

    BeanEmpleados bean;
    RepositoryEmpleados repo;

    public Action18EmpleadosOficioCombo() {
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
        
        DynaActionForm formulario = (DynaActionForm) form;
        String z_oficio = formulario.get("oficio").toString();

        // Solución con html en la View:
        //    String html = this.bean.getEmpleadosOficio(z_oficio);
        //    request.setAttribute("empsOficio", html);

        // Solución con ArrayList (objeto) en la View:
        ArrayList<Empleado> z_emps = this.repo.getEmpleadoOficio(z_oficio);
        request.setAttribute("empsOficio", z_emps);
        return mapping.findForward("web18empleadosoficioscombo");
        
    }
}
