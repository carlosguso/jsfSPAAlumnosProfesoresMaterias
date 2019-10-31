package carlosguso.ejercicio.model;
// Generated 29-oct-2019 14:27:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Profesores generated by hbm2java
 */
public class Profesores  implements java.io.Serializable {


     private int identificador;
     private String nombre;
     private String cedula;
     private Set materiases = new HashSet(0);

    public Profesores() {
    }

	
    public Profesores(int identificador) {
        this.identificador = identificador;
    }
    public Profesores(int identificador, String nombre, String cedula, Set materiases) {
       this.identificador = identificador;
       this.nombre = nombre;
       this.cedula = cedula;
       this.materiases = materiases;
    }
   
    public int getIdentificador() {
        return this.identificador;
    }
    
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Set getMateriases() {
        return this.materiases;
    }
    
    public void setMateriases(Set materiases) {
        this.materiases = materiases;
    }




}


