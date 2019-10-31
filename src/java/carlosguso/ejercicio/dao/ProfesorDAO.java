/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosguso.ejercicio.dao;

import carlosguso.ejercicio.model.Profesores;
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
public class ProfesorDAO {
    public List<Profesores> getProfesores() {
        List<Profesores> profesores = new ArrayList<>();
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Profesores");
            profesores = query.list();
            System.out.println("Profesor query size: " + profesores.size());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return profesores;
    }
    
    public List<Profesores> getProfesoresImpartenAlumno(int idAlumno) {
        List<Profesores> profesores = new ArrayList<>();
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Profesores where identificador in \n" +
            "(select profesores.identificador from Materias where identificador in \n" +
            "(select id.idMateria from AlumnosMaterias where id.idAlumno = :idAlumno))");
            query.setInteger("idAlumno", idAlumno);
            profesores = query.list();
            System.out.println("Profesor query size: " + profesores.size());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return profesores;
    }
}
