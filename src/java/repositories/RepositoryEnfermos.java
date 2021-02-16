/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Enfermo;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class RepositoryEnfermos {
    
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String path = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = DriverManager.getConnection(path, "system", "oracle");
        return conn;
    }
    
    public ArrayList<Enfermo> getEnfermos() throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from enfermo";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<Enfermo> z_enfermos = new ArrayList<>();
        while (z_rs.next()) {
            Enfermo z_enfermo = new Enfermo(z_rs.getInt("INSCRIPCION"), 
                                                 z_rs.getString("APELLIDO"),
                                                 z_rs.getString("DIRECCION"),
                                                 z_rs.getString("FECHA_NAC"),
                                                 z_rs.getString("SEXO"),
                                                 z_rs.getInt("NSS"));
            z_enfermos.add(z_enfermo);
        }
        z_rs.close();
        z_conn.close();
        return z_enfermos;
    }
    
    public void eliminarEnfermo(int inscripcion) throws SQLException {
        Connection z_conn = this.getConnection();
        String sql = "delete from enfermo where inscripcion=?";
        PreparedStatement pst = z_conn.prepareStatement(sql);
        pst.setInt(1, inscripcion);
        pst.executeUpdate();
        z_conn.close();
    }
}
