/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosguso.ejercicio.dao;

import carlosguso.ejercicio.model.Alumnos;
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
public class AlumnoDAO {
    public List<Alumnos> getAlumnos() {
        List<Alumnos> alumnos = new ArrayList<>();
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Alumnos");
            alumnos = query.list();
            System.out.println("Alumno query size: " + alumnos.size());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        /*for(Alumnos x : alumnos) {
                System.out.println(x.getIdentificador());
                System.out.println(x.getNombre());
                System.out.println(x.getSexo());
                System.out.println(x.getEdad());
                System.out.println("-------");
            }*/
        return alumnos;
    }
}
