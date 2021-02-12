/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanDepartamentos;
import Beans.BeanHospitales;
import forms.Rform09InsertHospitales;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Hospital;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import repositories.RepositoryHospital;

/**
 *
 * @author lscar
 */
public class Raction09InsertHospitales extends org.apache.struts.action.Action {

    RepositoryHospital repo;
    BeanHospitales bean;
    
    public Raction09InsertHospitales() {
        this.repo = new RepositoryHospital();
        this.bean = new BeanHospitales();
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
        String hnom = formulario.getHnom();
        String hdir = formulario.getHdir();
        String htel = formulario.getHtel();
        int hncamas = formulario.getHncamas();
        this.repo.insertHospital(hcod, hnom, hdir, htel, hncamas);

        // The next line (calling the bean Hospital class) is equivalent to 
        // the next commented lines.
        String html = this.bean.getHospitales();
//        ArrayList<Hospital> hospitales = repo.getHospitales();
//        String html = "";
//        for(Hospital h: hospitales) {
//            html += "<tr>";
//            html += "<td>" + h.getCod() + "</td><td>"
//                           + h.getNombre() + "</td><td>" 
//                           + h.getDir() + "</td><td>"
//                           + h.getTel() + "</td><td>"
//                           + h.getNumcama() + "</td>";
//            html += "</tr>";
//        }
        request.setAttribute("allhosps", html);
        return mapping.getInputForward();
    }
}
