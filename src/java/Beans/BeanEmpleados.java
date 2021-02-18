/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import java.util.ArrayList;
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
    
        public String getEmpleadosOficio(String oficio) throws SQLException {
        ArrayList<Empleado> empleados = this.repo.getEmpleadoOficio(oficio);
        if (empleados == null) {
            String html = "<h1 style='color:red'>No hay empleados con oficio " + oficio + "</h1>";
            return html;
        } else {
            String html = "<table border='1'>";
            html += "<thead>";
            html += "<tr><th>Apellido</th><th>Oficio</th><th>Salario</th></tr>";
            html += "</thead>";
            html += "<tbody>";
            for (Empleado emp : empleados) {
                html += "<tr>";
                html += "<td>" + emp.getApellido() + "</td>";
                html += "<td>" + emp.getOficio() + "</td>";
                html += "<td>" + emp.getSalario() + "</td>";
                html += "</tr>";
            }
            html += "</tbody>";
            html += "</table>";
            return html;
        }
    }
}
