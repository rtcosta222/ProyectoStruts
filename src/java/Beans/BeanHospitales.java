/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Hospital;
import repositories.RepositoryHospital;

/**
 *
 * @author lscar
 */
public class BeanHospitales {
    
    RepositoryHospital repo;
    
    public BeanHospitales() {
        this.repo = new RepositoryHospital();
    }
    
    public String getHospitales() throws SQLException {
        ArrayList<Hospital> hospitales = repo.getHospitales();
        String html = "";
        for(Hospital h: hospitales) {
            html += "<tr>";
            html += "<td>" + h.getCod() + "</td><td>"
                           + h.getNombre() + "</td><td>" 
                           + h.getDir() + "</td><td>"
                           + h.getTel() + "</td><td>"
                           + h.getNumcama() + "</td>";
            html += "</tr>";
        }
        return html;
    }
    
}
