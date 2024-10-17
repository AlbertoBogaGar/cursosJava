package repository;

import java.util.List;

import dao.AlumnoDAO;
import dao.AlumnoDAOMySQL;
import model.Alumnos;

public class AlumnoRepository {
	private static AlumnoRepository instance;

	public static synchronized AlumnoRepository getInstance() {
		if (instance == null) {
			instance = new AlumnoRepository();
		}
		return instance;

	}

	private AlumnoDAO dao;
	
	private AlumnoRepository() {
		dao=new AlumnoDAOMySQL();
	}

	public List<Alumnos> getAll() {
		return dao.getAll();
	}

	public boolean insert(Alumnos alumnos) {
		return dao.insert(alumnos);
	}

	public boolean update(Alumnos alumnos) {
		return dao.update(alumnos);

	}

	public boolean delete(int cod) {
		return dao.delete(cod);
	}
}
