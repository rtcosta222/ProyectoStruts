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
import models.Departamento;
import models.Empleado;
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
    
    public ArrayList<String> getDeptsName() throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select dnombre from dept";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<String> deptnombres = new ArrayList<>();
        while (z_rs.next()) {
            String z_deptnombre = z_rs.getString("DNOMBRE");
            deptnombres.add(z_deptnombre);
        }
        z_rs.close();
        z_conn.close();
        return deptnombres;
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
    
    public Departamento getDepartamento(int deptno) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from dept where dept_no=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, deptno);
        ResultSet z_rs = z_pst.executeQuery();
        Departamento z_dept = null;
        if(z_rs.next()) {
            z_dept = new Departamento(z_rs.getInt("DEPT_NO"),
                                      z_rs.getString("DNOMBRE"),
                                      z_rs.getString("LOC"));
        }
        z_rs.close();
        z_conn.close();
        return z_dept;
    }
    
    public void insertarDepartamento(int deptno, String dnombre, String loc) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "insert into dept values(?,?,?)";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, deptno);
        z_pst.setString(2, dnombre);
        z_pst.setString(3, loc);
        z_pst.executeUpdate();
        z_conn.close();
    }
    
    public void eliminarDEpartamento(int iddepartamento) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "delete from dept where dept_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, iddepartamento);
        pst.executeUpdate();
        cn.close();
    }
}
