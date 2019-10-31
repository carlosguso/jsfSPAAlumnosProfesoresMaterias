/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosguso.ejercicio.dao;

import carlosguso.ejercicio.model.AlumnosMaterias;
import carlosguso.ejercicio.model.Materias;
import carlosguso.ejercicio.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlosguso
 */
public class MateriaDAO {
    public List<Materias> getMateriasProfesor(int profesorId) {
        List<Materias> materias = new ArrayList<>();
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Materias where profesores.identificador = :idProfesor");
            query.setInteger("idProfesor", profesorId);
            materias = query.list();
            System.out.println("Materias query size: " + materias.size());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return materias;
    }
}
