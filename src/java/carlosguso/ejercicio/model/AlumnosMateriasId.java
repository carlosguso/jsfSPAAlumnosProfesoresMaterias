package carlosguso.ejercicio.model;
// Generated 29-oct-2019 14:27:56 by Hibernate Tools 4.3.1



/**
 * AlumnosMateriasId generated by hbm2java
 */
public class AlumnosMateriasId  implements java.io.Serializable {


     private int idAlumno;
     private int idMateria;

    public AlumnosMateriasId() {
    }

    public AlumnosMateriasId(int idAlumno, int idMateria) {
       this.idAlumno = idAlumno;
       this.idMateria = idMateria;
    }
   
    public int getIdAlumno() {
        return this.idAlumno;
    }
    
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    public int getIdMateria() {
        return this.idMateria;
    }
    
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlumnosMateriasId) ) return false;
		 AlumnosMateriasId castOther = ( AlumnosMateriasId ) other; 
         
		 return (this.getIdAlumno()==castOther.getIdAlumno())
 && (this.getIdMateria()==castOther.getIdMateria());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdAlumno();
         result = 37 * result + this.getIdMateria();
         return result;
   }   


}


