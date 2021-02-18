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
import repositories.RepositoryEmpleados;

/**
 * Obs.: Esta Action ha sido llamada desde dos Views distintas: 
 *          web18empleadosoficioscombo.jsp y web14empleados.jsp, 
 *       en contra de la afirmación "cada Action con su View".
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
        
        String idEmpleado = request.getParameter("idEmpIncrementar");
        String empno = request.getParameter("empno");
        String z_oficio = request.getParameter("oficioSeleccionado");
        int z_empno;
        if(idEmpleado != null) {
            z_empno = Integer.parseInt(idEmpleado);
            this.repo.incrementarSalarioEmpleado(z_empno, 1);
            ArrayList<Empleado> z_emps = this.repo.getEmpleadoOficio(z_oficio);
            request.setAttribute("empsOficio", z_emps);
            return mapping.findForward("web18empleadosoficioscombo");
        } else {
            z_empno = Integer.parseInt(empno);
            Empleado z_emp = this.repo.getDetallesEmp(z_empno);
            request.setAttribute("EMPLEADO", z_emp);
            String html = this.bean.getDetallesEmp(z_empno);
            request.setAttribute("detallesEmp", html);
            return mapping.findForward("web14detallesempleado");
        }
    }
}
