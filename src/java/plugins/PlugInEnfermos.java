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
import models.Enfermo;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import repositories.RepositoryEnfermos;
/**
 *
 * @author lscar
 */
public class PlugInEnfermos implements PlugIn{

    RepositoryEnfermos repo;
    
    public PlugInEnfermos() {
        this.repo = new RepositoryEnfermos();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        try {
            ArrayList<Enfermo> z_enfermos = this.repo.getEnfermos();
            servlet.getServletContext().setAttribute("LISTAENFERMOS", z_enfermos);
        } catch (SQLException ex) {
            System.out.println("Error SQL " + ex);
            // Alternativa: throw new ServletException(ex.toString());
        } 
    }
    
    
}
