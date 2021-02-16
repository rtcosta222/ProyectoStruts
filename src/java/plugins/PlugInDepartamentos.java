/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import models.Departamento;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class PlugInDepartamentos implements PlugIn {

    RepositoryDepartamentos repo;
    
    public PlugInDepartamentos() {
        this.repo = new RepositoryDepartamentos();
    }
    
    @Override
    public void destroy() {

    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        try {
            ArrayList<Departamento> departamentos = this.repo.getDepartamentos();
            servlet.getServletContext().setAttribute("LISTDEPARTAMENTOS", departamentos);
        } catch (SQLException ex) {
            System.out.println("Error SQL " + ex);
        }    
    }
}
