/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author lscar
 */
public class Form081InsertarDepartamento extends org.apache.struts.action.ActionForm {
    
    private int deptno;
    private String dnombre;
    private String loc;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String nombre) {
        this.dnombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
 
    public Form081InsertarDepartamento() {
        super();
        // TODO Auto-generated constructor stub
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
        if (getDnombre() == null || getDnombre().length() < 1) {
            errors.add("nombre", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        } else if (getLoc() == null || getLoc().length() < 1) {
            errors.add("loc", new ActionMessage("error.loc.required"));
        }
        return errors;
    }
}
