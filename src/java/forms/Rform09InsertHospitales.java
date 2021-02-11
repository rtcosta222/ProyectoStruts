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
import repositories.RepositoryHospital;

/**
 *
 * @author lscar
 */
public class Rform09InsertHospitales extends org.apache.struts.action.ActionForm {
    
    private int hcod;
    private String hnom;
    private String hdir;
    private String htel;
    private int hnc;
    RepositoryHospital repo;

    public int getHcod() {
        return hcod;
    }

    public void setHcod(int hcod) {
        this.hcod = hcod;
    }

    public String getHnom() {
        return hnom;
    }

    public void setHnom(String hnom) {
        this.hnom = hnom;
    }

    public String getHdir() {
        return hdir;
    }

    public void setHdir(String hdir) {
        this.hdir = hdir;
    }

    public String getHtel() {
        return htel;
    }

    public void setHtel(String htel) {
        this.htel = htel;
    }

    public int getHnc() {
        return hnc;
    }

    public void setHnc(int hnc) {
        this.hnc = hnc;
    }

    public Rform09InsertHospitales() {
        this.repo = new RepositoryHospital();
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
        try {
            if (this.repo.buscarHospital(getHcod()) == true) {
                errors.add("numero", new ActionMessage("error.hcod.duplicated"));
            } else if (getHnom() == null || getHnom().length() < 1) {
                errors.add("nombre", new ActionMessage("error.hname.required"));
            } else if (getHdir() == null || getHdir().length() < 1) {
                errors.add("direccion", new ActionMessage("error.hdir.required"));
            } else if (getHtel() == null || getHtel().length() < 1) {
                errors.add("telefono", new ActionMessage("error.htel.required"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rform09InsertHospitales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return errors;
    }
}
