/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosguso.ejercicio.bean;

import carlosguso.ejercicio.dao.AlumnoDAO;
import carlosguso.ejercicio.dao.AlumnoMateriaDAO;
import carlosguso.ejercicio.dao.MateriaDAO;
import carlosguso.ejercicio.dao.ProfesorDAO;
import carlosguso.ejercicio.model.Alumnos;
import carlosguso.ejercicio.model.Materias;
import carlosguso.ejercicio.model.Profesores;
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
@Named(value = "tableBean")
@SessionScoped
public class TableBean implements Serializable {

    /**
     * @return the mcd
     */
    public List<MateriasCantidadDatos> getMcd() {
        return mcd;
    }

    /**
     * @param mcd the mcd to set
     */
    public void setMcd(List<MateriasCantidadDatos> mcd) {
        this.mcd = mcd;
    }

    /**
     * @return the alumnosMaterias
     */
    public List<Integer> getAlumnosMaterias() {
        return alumnosMaterias;
    }

    /**
     * @param alumnosMaterias the alumnosMaterias to set
     */
    public void setAlumnosMaterias(List<Integer> alumnosMaterias) {
        this.alumnosMaterias = alumnosMaterias;
    }

   
    private List<Profesores> listaProfesores = new ArrayList<>();
    private Profesores profesor = null;
    private List<Alumnos> listaAlumnos = new ArrayList<>();
    private Alumnos alumno = null;
    
    private List<Profesores> profesoresAlumnos = new ArrayList<>();
    private List<Materias> profesoresMaterias = new ArrayList<>();
    private List<Integer> alumnosMaterias = new ArrayList<>();
    private List<MateriasCantidadDatos> mcd = new ArrayList<>();
    
    
     public void getProfesores() {
        System.out.println("Profesor bean tirggered");
        ProfesorDAO profesorDAO = new ProfesorDAO();
        this.setListaProfesores(profesorDAO.getProfesores());
        this.setListaAlumnos(new ArrayList<>());
        System.out.println(listaProfesores.get(0));
    }
     
    public void getAlumnos() {
        System.out.println("Alumnos bean tirggered");
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        this.setListaAlumnos(alumnoDAO.getAlumnos());
        this.setListaProfesores(new ArrayList<>());
    }
    
    public void getData(int id) {
        System.out.println("Table bean triggered");
        if(this.getListaProfesores().size() == 0) {
            this.setAlumno(listaAlumnos.get(id-1));
            this.setProfesor(null);
            ProfesorDAO profesorDAO = new ProfesorDAO();
            this.setProfesoresAlumnos(profesorDAO.getProfesoresImpartenAlumno(id));
            System.out.println("Profesores alumnos tamaño: " + this.profesoresAlumnos.size());
            
        } else {
            this.setProfesor(listaProfesores.get(id-1));
            this.setAlumno(null);
            
            MateriaDAO materiasDAO = new MateriaDAO();
            AlumnoMateriaDAO alumnomateriasDAO = new AlumnoMateriaDAO();
            List<Materias> m = materiasDAO.getMateriasProfesor(id);
            //this.setProfesoresMaterias(materiasDAO.getMateriasProfesor(id));
            //this.setAlumnosMaterias(alumnomateriasDAO.getAlumnosMateriaCantidad(id));
            List<Long> c = alumnomateriasDAO.getAlumnosMateriaCantidad(id);
            
            for(int i = 0; i < m.size(); i++){
                MateriasCantidadDatos holder = new MateriasCantidadDatos(m.get(i).getNombre(), (int)(long)c.get(i));
                this.getMcd().add(holder);
            }
            for(MateriasCantidadDatos x : this.mcd) {
                System.out.println("Materia: " + x.getNombreMateria());
                System.out.println("Cantidad: " + x.getCantidad());
            }
        }
    }

    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
    }
    
    /**
     * @return the listaProfesores
     */
    public List<Profesores> getListaProfesores() {
        return listaProfesores;
    }

    /**
     * @param listaProfesores the listaProfesores to set
     */
    public void setListaProfesores(List<Profesores> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    /**
     * @return the profesor
     */
    public Profesores getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

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
    public Alumnos getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }
    
     /**
     * @return the profesoresAlumnos
     */
    public List<Profesores> getProfesoresAlumnos() {
        return profesoresAlumnos;
    }

    /**
     * @param profesoresAlumnos the profesoresAlumnos to set
     */
    public void setProfesoresAlumnos(List<Profesores> profesoresAlumnos) {
        this.profesoresAlumnos = profesoresAlumnos;
    }

    /**
     * @return the profesoresMaterias
     */
    public List<Materias> getProfesoresMaterias() {
        return profesoresMaterias;
    }

    /**
     * @param profesoresMaterias the profesoresMaterias to set
     */
    public void setProfesoresMaterias(List<Materias> profesoresMaterias) {
        this.profesoresMaterias = profesoresMaterias;
    }
    
    
    
    //Helper class for displaying data in the table.
    public static class MateriasCantidadDatos {

        /**
         * @return the nombreMateria
         */
        public String getNombreMateria() {
            return nombreMateria;
        }

        /**
         * @param nombreMateria the nombreMateria to set
         */
        public void setNombreMateria(String nombreMateria) {
            this.nombreMateria = nombreMateria;
        }

        /**
         * @return the cantidad
         */
        public Integer getCantidad() {
            return cantidad;
        }

        /**
         * @param cantidad the cantidad to set
         */
        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }
        private String nombreMateria;
        private Integer cantidad;
        
        public MateriasCantidadDatos(String m, Integer i) {
            this.setNombreMateria(m);
            this.setCantidad(i);
        }
    }
}
