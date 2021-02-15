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
import models.Empleado;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class RepositoryEmpleados {
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String path = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = DriverManager.getConnection(path, "system", "oracle");
        return conn;
    }
    
    public ArrayList<Empleado> getEmpleadoOficio(String oficio) throws SQLException {
        Connection cn = this.getConnection();
        String z_sql = "select * from emp where upper(oficio)=upper(?)";
        PreparedStatement z_pst = cn.prepareStatement(z_sql);
        z_pst.setString(1, oficio);
        ResultSet z_rs = z_pst.executeQuery();
        ArrayList<Empleado> listaempleadosporoficio = new ArrayList<>(); 
        while (z_rs.next()) {
            Empleado emp = new Empleado(z_rs.getInt("EMP_NO"),
                                        z_rs.getString("APELLIDO"),
                                        z_rs.getString("OFICIO"),
                                        z_rs.getInt("SALARIO"));
            listaempleadosporoficio.add(emp);   
        }
        z_rs.close();
        cn.close();
        return listaempleadosporoficio;
    }
    
    public ArrayList<Empleado> getEmpleados() throws SQLException {
        Connection cn = this.getConnection();
        String z_sql = "select * from emp";
        Statement z_st = cn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<Empleado> listaempleados = new ArrayList<>(); 
        while (z_rs.next()) {
            Empleado empleado = new Empleado(z_rs.getInt("EMP_NO"),
                                        z_rs.getString("APELLIDO"),
                                        z_rs.getString("OFICIO"),
                                        z_rs.getInt("SALARIO"));
            listaempleados.add(empleado);   
        }
        z_rs.close();
        cn.close();
        return listaempleados;
    }
    
    public Empleado getDetallesEmp(int empno) throws SQLException {
        Connection cn = this.getConnection();
        String z_sql = "select * from emp where emp_no=?";
        PreparedStatement z_pst = cn.prepareStatement(z_sql);
        z_pst.setInt(1, empno);
        ResultSet z_rs = z_pst.executeQuery();
        Empleado empleado = new Empleado();
        if(z_rs.next()) {
            empleado = new Empleado(z_rs.getInt("EMP_NO"),
                                z_rs.getString("APELLIDO"),
                                z_rs.getString("OFICIO"),
                                z_rs.getInt("SALARIO"));
        }
        z_rs.close();
        cn.close();
        return empleado;  
    }
}
