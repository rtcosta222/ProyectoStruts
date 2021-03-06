/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanDepartamentos;
import forms.Form081InsertarDepartamento;
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
public class Action081InsertarDepartamento extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    RepositoryDepartamentos repo;
    BeanDepartamentos bean;
    
    public Action081InsertarDepartamento() {
        this.repo = new RepositoryDepartamentos();
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
        
        Form081InsertarDepartamento formulario = (Form081InsertarDepartamento) form;
        int z_deptno = formulario.getDeptno();
        String z_dnombre = formulario.getDnombre();
        String z_loc = formulario.getLoc();
        this.repo.insertarDepartamento(z_deptno, z_dnombre, z_loc);
        String html = this.bean.getDepartamentos();
        request.setAttribute("datosdept", html);
        return mapping.getInputForward();
    }
}
