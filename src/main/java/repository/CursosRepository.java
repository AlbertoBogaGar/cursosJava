package repository;

import java.util.List;

import dao.CursosDAO;
import dao.CursosDAOMySQL;
import model.Cursos;

public class CursosRepository {
	private static CursosRepository instance;

	public static synchronized CursosRepository getInstance() {
		if (instance == null) {
			instance = new CursosRepository();
		}
		return instance;

	}

	private CursosDAO dao;
	
	private CursosRepository() {
		dao=new CursosDAOMySQL();
	}

	public List<Cursos> getAll() {
		return dao.getAll();
	}
}
