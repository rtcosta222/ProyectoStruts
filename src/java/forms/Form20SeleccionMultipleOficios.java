/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author lscar
 */
public class Form20SeleccionMultipleOficios extends org.apache.struts.action.ActionForm {

    private String[] oficios;

    public Form20SeleccionMultipleOficios() {
        super();
    }
        
    public String[] getOficios() {
        return oficios;
    }

    public void setOficios(String[] oficios) {
        this.oficios = oficios;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        return errors;
    }
}
