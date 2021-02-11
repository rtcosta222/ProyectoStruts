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
public class Hospital {
    private int cod;
    private String nombre;
    private String dir;
    private String tel;
    private int numcama;
    
    public Hospital() {
    }
    
    public Hospital(int hcod, String hnombre, String hdir, String htel, int ncama) {
        this.cod = hcod;
        this.nombre = hnombre;
        this.dir = hdir;
        this.tel = htel;
        this.numcama = ncama;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getNumcama() {
        return numcama;
    }

    public void setNumcama(int numcama) {
        this.numcama = numcama;
    }
}
