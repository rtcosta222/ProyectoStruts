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
    
    public void incrementarSalarioEmpleado(int empno, int incremento) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "update emp set salario=salario+? where emp_no=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, incremento);
        z_pst.setInt(2, empno);
        z_pst.executeUpdate();
        z_conn.close();
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
                                        z_rs.getInt("SALARIO"),
                                        z_rs.getInt("DEPT_NO"));
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
                                        z_rs.getInt("SALARIO"),
                                        z_rs.getInt("DEPT_NO"));
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
                                z_rs.getInt("SALARIO"),
                                z_rs.getInt("DEPT_NO"));
        }
        z_rs.close();
        cn.close();
        return empleado;  
    }
    
    public ArrayList<String> getOficios() throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select distinct oficio from emp";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<String> z_oficios = new ArrayList<>();
        while (z_rs.next()) {
            String z_oficio = z_rs.getString("OFICIO");
            z_oficios.add(z_oficio);
        }
        z_rs.close();
        z_conn.close();
        return z_oficios;
    }
    
    public ArrayList<Empleado> getEmpleadosDepartamentos(String[] datos) throws SQLException {
        Connection z_conn = this.getConnection();
        String deptnos = "";
        for(String d: datos) {
            deptnos += d + ",";
        }
        deptnos = deptnos.substring(0, deptnos.length() - 1);
        String z_sql = "select * from emp where dept_no in(" + deptnos + ")";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<Empleado> lista = new ArrayList<>();
        while(z_rs.next()) {
            Empleado emp = new Empleado(z_rs.getInt("EMP_NO"),
                                z_rs.getString("APELLIDO"),
                                z_rs.getString("OFICIO"),
                                z_rs.getInt("SALARIO"),
                                z_rs.getInt("DEPT_NO"));
            lista.add(emp);
        }
        z_rs.close();
        z_conn.close();
        return lista;
    }
    
        public ArrayList<Empleado> getEmpleadosOficios(String[] datos) throws SQLException {
        Connection z_conn = this.getConnection();
        String oficios = "";
        for(String d: datos) {
            oficios += d + "','";
        }
        oficios = oficios.substring(0, oficios.length() - 2);
        String z_sql = "select * from emp where oficio in('" + oficios + ")";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        ArrayList<Empleado> lista = new ArrayList<>();
        while(z_rs.next()) {
            Empleado emp = new Empleado(z_rs.getInt("EMP_NO"),
                                z_rs.getString("APELLIDO"),
                                z_rs.getString("OFICIO"),
                                z_rs.getInt("SALARIO"),
                                z_rs.getInt("DEPT_NO"));
            lista.add(emp);
        }
        z_rs.close();
        z_conn.close();
        return lista;
    }
}
