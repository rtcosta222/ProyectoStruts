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
import org.apache.struts.action.DynaActionForm;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class Action08InsertarDepartamento extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    RepositoryDepartamentos repo;
    
    public Action08InsertarDepartamento() {
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
        String z_dnombre = formulario.get("dnombre").toString();
        String z_loc = formulario.get("loc").toString();
        
        this.repo.insertarDepartamento(z_deptno, z_dnombre, z_loc);
        
        ArrayList<Departamento> depts = this.repo.getDepartamentos();
        String html = "";
        for(Departamento d: depts) {
            html += "<tr><td>" + d.getNumero()+ "</td>"
                   + "<td>" + d.getNombre()+ "</td>"
                   + "<td>" + d.getLocalidad()+ "</td></tr>";
        }
        request.setAttribute("datosdept", html);
        return mapping.getInputForward();
    }
}
