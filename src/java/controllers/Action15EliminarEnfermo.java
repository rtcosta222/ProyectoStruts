/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanDepartamentos;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Enfermo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import repositories.RepositoryDepartamentos;
import repositories.RepositoryEnfermos;

/**
 *
 * @author lscar
 */
public class Action15EliminarEnfermo extends org.apache.struts.action.Action {

    RepositoryEnfermos repo;
    
    public Action15EliminarEnfermo(){
        this.repo = new RepositoryEnfermos();
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
        String ui = formulario.get("inscripcion").toString();
        int z_inscripcion = Integer.parseInt(ui);
        this.repo.eliminarEnfermo(z_inscripcion);

        ArrayList<Enfermo> z_enfermos = this.repo.getEnfermos();
        request.setAttribute("LISTAENFERMOS", z_enfermos);
        return mapping.findForward("web16eliminarenfermos");
    }
}
