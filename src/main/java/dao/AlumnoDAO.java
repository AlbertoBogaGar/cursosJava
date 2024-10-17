package dao;

import java.util.List;

import model.Alumnos;

public interface AlumnoDAO {

	List<Alumnos> getAll();

	boolean insert(Alumnos alumnos);

	boolean update(Alumnos alumnos);

	boolean delete(int cod);

}
