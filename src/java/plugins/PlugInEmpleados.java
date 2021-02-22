/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import models.Empleado;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import repositories.RepositoryEmpleados;

/**
 *
 * @author lscar
 */
public class PlugInEmpleados implements PlugIn{

    RepositoryEmpleados repo;
    
    public PlugInEmpleados() {
        this.repo = new RepositoryEmpleados();
    }
    
    @Override
    public void destroy() {
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        try {
            ArrayList<Empleado> z_empleados = this.repo.getEmpleados();
            servlet.getServletContext().setAttribute("LISTEMPLEADOS", z_empleados);
            ArrayList<String> z_oficios = this.repo.getOficios();
            servlet.getServletContext().setAttribute("LISTOFICIOS", z_oficios);
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex);
            throw new ServletException("Error SQL: " + ex);
        }
    }    
}
