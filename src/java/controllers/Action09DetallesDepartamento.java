/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanDepartamentos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author lscar
 */
public class Action09DetallesDepartamento extends org.apache.struts.action.Action {

    BeanDepartamentos bean;

    public Action09DetallesDepartamento() {
        this.bean = new BeanDepartamentos();
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
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request, 
                                 HttpServletResponse response) throws Exception {
        
        String dato = request.getParameter("iddepartamento");
        int deptno = Integer.parseInt(dato);
        String html = this.bean.getDetallesDepartamento(deptno);
        request.setAttribute("detallesdepartamento", html);
        return mapping.findForward("webdetallesdepartamento");
    }
}
