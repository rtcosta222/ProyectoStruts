/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import models.Empleado;
import repositories.RepositoryEmpleados;

/**
 *
 * @author lscar
 */
public class BeanEmpleados {
    
    RepositoryEmpleados repo;
    
    public BeanEmpleados() {
        this.repo = new RepositoryEmpleados();
    }
    public String getDetallesEmp(int empno) throws SQLException {
        Empleado emp = this.repo.getDetallesEmp(empno);
        String html = "<h1 style='color:blue'>Apellido: " + emp.getApellido() + "</h1>";
        html += "<h2 style='color:red'>Oficio: " + emp.getOficio()+ "</h2>";
        html += "<h2 style='color:green'>Salario: " + emp.getSalario()+ "</h2>";
        return html;
    }
}
