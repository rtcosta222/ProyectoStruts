/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BeanHospitales;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import repositories.RepositoryHospital;

/**
 *
 * @author lscar
 */
public class Raction08GetHospitales extends org.apache.struts.action.Action {

    RepositoryHospital repo;
    BeanHospitales bean;
    
    public Raction08GetHospitales() {
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
        
        String html = this.bean.getHospitales();
        request.setAttribute("allhosps", html);
        return mapping.getInputForward();
    }
}
