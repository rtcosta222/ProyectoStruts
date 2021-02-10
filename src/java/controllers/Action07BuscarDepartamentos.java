/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Departamento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class Action07BuscarDepartamentos extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    RepositoryDepartamentos repo;
    
    public Action07BuscarDepartamentos() {
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
        
        DynaActionForm formulario = (DynaActionForm) form;
        String ui = formulario.get("deptno").toString();
        int z_deptno = Integer.parseInt(ui);
        
        Departamento dept = this.repo.getDepartamento(z_deptno);
        if(dept == null) {
            request.setAttribute("mensaje", "No existe dept " + z_deptno); 
        } else {
            String html = "";
            html += "DeptNum: " + dept.getNumero() + "  DeptNombre: " + dept.getNombre() + "  Loc.:" + dept.getLocalidad();
            request.setAttribute("dept", html);
        }
        // "buscardepartamentos está definido en struts_config.xml, etiqueta global-forwards"
        return mapping.findForward("buscardepartamentos");
    }
}
