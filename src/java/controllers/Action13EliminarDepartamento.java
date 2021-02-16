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
import org.apache.struts.action.DynaActionForm;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class Action13EliminarDepartamento extends org.apache.struts.action.Action {

    BeanDepartamentos bean;
    RepositoryDepartamentos repo;
    
    public Action13EliminarDepartamento(){
        this.bean = new BeanDepartamentos();
        this.repo = new RepositoryDepartamentos();
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
        
        DynaActionForm formulario = (DynaActionForm)form;
        String dato = formulario.get("deptno").toString();
        int iddepartamento = Integer.parseInt(dato);
        this.repo.eliminarDEpartamento(iddepartamento);

        String html = this.bean.getDepartamentos();
        request.setAttribute("tabladepartamentos", html);
        return mapping.findForward("web13eliminardepartamento");
    }
}
