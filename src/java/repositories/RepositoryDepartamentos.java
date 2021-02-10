/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Departamento;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class RepositoryDepartamentos {
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String path = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = DriverManager.getConnection(path, "system", "oracle");
        return conn;
    }
    
    public ArrayList<Departamento> getDepartamentos() throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from dept";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<Departamento> lista = new ArrayList<>();
        while (z_rs.next()) {
            Departamento dept = new Departamento(z_rs.getInt("DEPT_NO"), 
                                                    z_rs.getString("DNOMBRE"),
                                                    z_rs.getString("LOC"));
            lista.add(dept);
        }
        z_rs.close();
        z_conn.close();
        return lista;
                
    }
}
