/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosguso.ejercicio.bean;

import carlosguso.ejercicio.dao.AlumnoDAO;
import carlosguso.ejercicio.model.Alumnos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author carlosguso
 */
@Named(value = "alumnosBean")
@RequestScoped
public class AlumnosBean implements Serializable {

    /**
     * @return the listaAlumnos
     */
    public List<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    /**
     * @param listaAlumnos the listaAlumnos to set
     */
    public void setListaAlumnos(List<Alumnos> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
   
    private List<Alumnos> listaAlumnos = new ArrayList<>();
    private Alumno alumno;
    
    
    public void getAlumnos() {
        System.out.println("Alumnos bean tirggered");
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        this.setListaAlumnos(alumnoDAO.getAlumnos());
    }
   

    /**
     * Creates a new instance of AlumnosBean
     */
    public AlumnosBean() {
     //this.getAlumnos();
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this+" collected");
        super.finalize();
    }
    
    public static class Alumno {

        /**
         * @return the identificador
         */
        public int getIdentificador() {
            return identificador;
        }

        /**
         * @param identificador the identificador to set
         */
        public void setIdentificador(int identificador) {
            this.identificador = identificador;
        }

        /**
         * @return the nombre
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * @param nombre the nombre to set
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * @return the sexo
         */
        public String getSexo() {
            return sexo;
        }

        /**
         * @param sexo the sexo to set
         */
        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        /**
         * @return the edad
         */
        public Integer getEdad() {
            return edad;
        }

        /**
         * @param edad the edad to set
         */
        public void setEdad(Integer edad) {
            this.edad = edad;
        }
        
        private int identificador;
        private String nombre;
        private String sexo;
        private Integer edad;
        
        public Alumno() {
            
        }
    }
    
    
}
