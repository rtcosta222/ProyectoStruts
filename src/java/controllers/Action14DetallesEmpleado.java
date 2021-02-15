/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanEmpleados;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author lscar
 */
public class Action14DetallesEmpleado extends org.apache.struts.action.Action {

    BeanEmpleados bean;
    
    public Action14DetallesEmpleado() {
        this.bean = new BeanEmpleados();
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
        
        String ui = request.getParameter("empno");
        int z_empno = Integer.parseInt(ui);
        String html = this.bean.getDetallesEmp(z_empno);
        request.setAttribute("detallesEmp", html);
        return mapping.findForward("web14detallesempleado");
    }
}
