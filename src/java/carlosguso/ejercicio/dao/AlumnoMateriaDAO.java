/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosguso.ejercicio.dao;

import carlosguso.ejercicio.model.AlumnosMaterias;
import carlosguso.ejercicio.model.Materias;
import carlosguso.ejercicio.model.Profesores;
import carlosguso.ejercicio.util.NewHibernateUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlosguso
 */
public class AlumnoMateriaDAO {
    public List<AlumnosMaterias> getMateriasAlumno(int idAlumno) {
        List<AlumnosMaterias> materias = new ArrayList<>();
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from AlumnosMaterias where id.idAlumno = :idAlumno");
            query.setInteger("idAlumno", idAlumno);
            materias = query.list();
            System.out.println("AlunoMaterias query size: " + materias.size());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return materias;
    }
    
    public List<Long> getAlumnosMateriaCantidad(int idProfesor) {
        List<Long> cantidad = new ArrayList<>();
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(id.idAlumno) from AlumnosMaterias where id.idMateria in (select identificador from Materias where profesores.identificador = :id) group by id.idMateria");
            query.setInteger("id", idProfesor);
            cantidad = query.list();
            System.out.println("AlumnosMateriasProfesor query size: " + cantidad.size());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cantidad;
    }
}
