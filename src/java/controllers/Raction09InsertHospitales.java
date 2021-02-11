/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import forms.Rform09InsertHospitales;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Hospital;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import repositories.RepositoryHospital;

/**
 *
 * @author lscar
 */
public class Raction09InsertHospitales extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    RepositoryHospital repo;
    
    public Raction09InsertHospitales() {
        this.repo = new RepositoryHospital();
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
        
        Rform09InsertHospitales formulario = (Rform09InsertHospitales) form;
        int hcod = formulario.getHcod();
        String hnom = formulario.getHnom().toString();
        String hdir = formulario.getHdir().toString();
        String htel = formulario.getHtel().toString();
        int hncamas = formulario.getHnc();
        this.repo.insertHospital(hcod, hnom, hdir, htel, hncamas);
        
        ArrayList<Hospital> hospitales = repo.getHospitales();
        String html = "";
        for(Hospital h: hospitales) {
            html += "<tr>";
            html += "<td>" + h.getCod() + "</td><td>"
                           + h.getNombre() + "</td><td>" 
                           + h.getDir() + "</td><td>"
                           + h.getTel() + "</td><td>"
                           + h.getNumcama() + "</td>";
            html += "</tr>";
        }
        request.setAttribute("allhosps", html);
        return mapping.getInputForward();
    }
}
