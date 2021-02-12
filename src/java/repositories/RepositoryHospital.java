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
import models.Hospital;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class RepositoryHospital {
    
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String z_path = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection connection = DriverManager.getConnection(z_path, "system", "oracle");
        return connection;
    }
    
    public Hospital getHospital(int hcod) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from hospital where hospital_cod=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, hcod);
        ResultSet z_rs = z_pst.executeQuery();
        Hospital z_hospital = new Hospital();
        if(z_rs.next()) {
            z_hospital = new Hospital(z_rs.getInt("HOSPITAL_COD"),
                                      z_rs.getString("NOMBRE"),
                                      z_rs.getString("DIRECCION"),
                                      z_rs.getString("TELEFONO"),
                                      z_rs.getInt("NUM_CAMA"));
            z_rs.close();
            z_conn.close();
            return z_hospital;
        } else {
            z_rs.close();
            z_conn.close();
            return null;
        }
    }
    
    public void insertHospital(int cod, String nombre, String dir, String tel, int ncamas) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "insert into hospital values(?,?,?,?,?)";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, cod);
        z_pst.setString(2, nombre);
        z_pst.setString(3, dir);
        z_pst.setString(4, tel);
        z_pst.setInt(5, ncamas);
        z_pst.executeUpdate();
        z_conn.close();
    }
    
    public ArrayList<Hospital> getHospitales() throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from hospital order by hospital_cod";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<Hospital> hospitales = new ArrayList<>();
        while (z_rs.next()) {
            Hospital hosp = new Hospital(z_rs.getInt("HOSPITAL_COD"),
                                         z_rs.getString("NOMBRE"),
                                         z_rs.getString("DIRECCION"),
                                         z_rs.getString("TELEFONO"),
                                         z_rs.getInt("NUM_CAMA"));
            hospitales.add(hosp);
        }
        z_rs.close();
        z_conn.close();
        return hospitales;
    }
}
