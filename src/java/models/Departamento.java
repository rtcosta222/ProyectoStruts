/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author lscar
 */
public class Departamento {
    // Atributes
    private int numero;
    private String nombre;
    private String localidad;
    
    // Constructors
    public Departamento() {    
    }
    
    public Departamento(int deptno, String dnombre, String loc) {
        this.numero = deptno;
        this.nombre = dnombre;
        this.localidad = loc;
    }
    
    // Methods
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
