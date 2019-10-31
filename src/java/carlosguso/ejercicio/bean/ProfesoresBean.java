/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosguso.ejercicio.bean;

import carlosguso.ejercicio.dao.ProfesorDAO;
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
@Named(value = "profesoresBean")
@RequestScoped
public class ProfesoresBean implements Serializable {
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
    
    private List<Profesores> listaProfesores = new ArrayList<>();
    private Profesores profesor;
    
    public void getProfesores() {
        System.out.println("Profesor bean tirggered");
        ProfesorDAO profesorDAO = new ProfesorDAO();
        this.setListaProfesores(profesorDAO.getProfesores());
    }

    /**
     * Creates a new instance of ProfesoresBean
     */
    public ProfesoresBean() {
        //this.getProfesores();
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this+" collected");
        super.finalize();
    }
    
    
}
