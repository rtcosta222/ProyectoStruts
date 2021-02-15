/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Departamento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class Action09MenuDepartamentosDinamico extends org.apache.struts.action.Action {

    RepositoryDepartamentos repo;
    
    public Action09MenuDepartamentosDinamico () {
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
    public ActionForward execute(ActionMapping mapping, 
                                ActionForm form,
                                HttpServletRequest request, 
                                HttpServletResponse response) throws Exception {
        
        ArrayList<Departamento> depts = this.repo.getDepartamentos();
        request.setAttribute("deptsname", depts);
        return mapping.findForward("webmenudeptsdinamico");
    }
}
