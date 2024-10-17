package repository;

import java.util.List;

import dao.EvaluacionesDAO;
import dao.EvaluacionesDAOMySQL;
import model.Evaluaciones;

public class EvaluacionesRepository {
	private static EvaluacionesRepository instance;

	public static synchronized EvaluacionesRepository getInstance() {
		if (instance == null) {
			instance = new EvaluacionesRepository();
		}
		return instance;

	}

	private EvaluacionesDAO dao;
	
	private EvaluacionesRepository() {
		dao=new EvaluacionesDAOMySQL();
	}

	public List<Evaluaciones> getAll() {
		return dao.getAll();
	}

	public List<Evaluaciones> getByCod(int cod) {
		return dao.getByCod(cod);
	}
}
