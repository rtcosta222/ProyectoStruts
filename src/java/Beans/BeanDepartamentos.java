/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Departamento;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class BeanDepartamentos {
    
    RepositoryDepartamentos repo;
    
    public BeanDepartamentos() {
        this.repo = new RepositoryDepartamentos();
    }
    
    public String getDepartamentos() throws SQLException {
        
        ArrayList<Departamento> depts = this.repo.getDepartamentos();
        String html = "<table>";
        for(Departamento d: depts) {
            html += "<tr><td>" + d.getNumero()+ "</td>"
                   + "<td>" + d.getNombre()+ "</td>"
                   + "<td>" + d.getLocalidad()+ "</td></tr>";
        }
        html += "</table>";
        return html;
    }
    
    public String getDetallesDepartamento(int deptno) throws SQLException {
        Departamento departamento = this.repo.getDepartamento(deptno);
        String html = "<h1 style='color:blue'>Nombre: " + departamento.getNombre() + "</h1>";
        html += "<h1 style='color:red'>Localidad: " + departamento.getLocalidad() + "</h1>";
        html += "<h2 style='color:green'>Número: " + departamento.getNumero() + "</h2>";
        return html;
    }
}
