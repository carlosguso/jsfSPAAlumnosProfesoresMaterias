/*Database creation*/
CREATE DATABASE ejercicio;
USE ejercicio;

/*DDL*/
CREATE TABLE profesores (
    identificador int(4),
    nombre varchar(50),
    cedula varchar(10),
    CONSTRAINT Pk_profesores PRIMARY KEY (identificador)
);

CREATE TABLE materias (
    identificador int(4),
    nombre varchar(50),
    profesor int(4),
    CONSTRAINT Pk_materias PRIMARY KEY (identificador),
    CONSTRAINT FK_ProfesorMateria FOREIGN KEY (profesor) REFERENCES profesores(identificador)
);

CREATE TABLE alumnos (
    identificador int(4),
    nombre varchar(50),
    sexo varchar(1),
    CONSTRAINT Pk_alumnos PRIMARY KEY (identificador)
);

/*DML*/
INSERT INTO profesores (identificador, nombre, cedula) VALUES 
(1, "Jaime Rodriguez", "12cet6551s"),
(2, "Salvador Hernandez", "uw678o0j21"),
(3, "Silvia Olmedo", "yy56w8asm2");

INSERT INTO materias (identificador, nombre, profesor) VALUES 
(1, "fisica", 1),
(2, "quimica", 3),
(3, "algebra", 2),
(4, "ingles", 2),
(5, "frances", 1);

INSERT INTO alumnos (identificador, nombre, sexo) VALUES 
(1, "Yael Quintero", "H"),
(2, "Rene Coss", "H"),
(3, "Brenda Avila", "M"),
(4, "Carlos Cervera", "H"),
(5, "Aldair Villaruel", "H"),
(6, "Andrea Abundis", "M"),
(7, "Diego Gomez", "H"),
(8, "Daniela Perez", "M"),
(9, "Laura Ramirez", "M"),
(10, "Paulo Padilla", "H"),
(11, "Carlos Gutierrez", "H"),
(12, "Isaac Lopez", "H");

ALTER TABLE alumnos ADD COLUMN edad int(2);
UPDATE alumnos SET edad = 11;

CREATE TABLE alumnos_materias (
    idAlumno int(4),
    idMateria int(4),
    CONSTRAINT Pk_alumnos_materias PRIMARY KEY (idAlumno, idMateria)
);

INSERT INTO alumnos_materias VALUES 
(1, 2),(1, 3),(1, 4),
(2, 1),(2, 3),(2, 5),
(3, 1),(3, 4),
(4, 2),(4, 3),
(5, 5),(5, 1),
(6, 5),(6, 3),(6, 1),
(7, 2),(7, 3),
(8, 4),(8, 1),
(9, 5),(9, 1),(9, 3),
(10, 1),(10, 3),(10,2),
(11, 3),(11, 1),(11,5),
(12, 3),(12, 4);

/*Obtener nombre y cedula de los profesores que imparten a cierto alumno*/
select nombre, cedula from profesores where identificador in 
(select profesor from materias where identificador in 
(select idMateria from alumnos_materias where idAlumno = 1));

/*Obtener nombre, sexo y edad de los alumnos a los que les impoarte cierto profesor*/
select identificador, nombre, edad, sexo  from alumnos where identificador in 
(select idAlumno from alumnos_materias where idMateria in 
(select identificador from materias where profesor = 1));

/**Obtener materias que imparte cierto profesor*/
select * from materias where profesor = 1;

/*Mostrat materia que imparte cierto profesor y cuanto alumnos tiene en cada una*/
select count(idAlumno) as alumnosMAteria from alumnos_materias where idMateria in (select identificador from materias where profesor = 1) group by idMateria;
