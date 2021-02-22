/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class Form082InsertarDepartamento extends org.apache.struts.action.ActionForm {
    
    private int deptno;
    private String dnombre;
    private String loc;
    RepositoryDepartamentos repo;
    
//    public Form082InsertarDepartamento() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
    
    public Form082InsertarDepartamento() {
        this.repo = new RepositoryDepartamentos();
    }
    
    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    // De donde sale este método? The struts. Se trata de un ActionForm. Generado auto.
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
                
        try {
            if (this.repo.getDepartamento(getDeptno()) != null) {
                errors.add("numero", new ActionMessage("error.numero.duplicado"));
            } else if (getDnombre() == null || getDnombre().length() < 1) {
                errors.add("nombre", new ActionMessage("error.name.required"));
                // TODO: add 'error.name.required' key to your resources
            } else if (getLoc() == null || getLoc().length() < 1) {
                errors.add("loc", new ActionMessage("error.loc.required"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form082InsertarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return errors;
    }
}
