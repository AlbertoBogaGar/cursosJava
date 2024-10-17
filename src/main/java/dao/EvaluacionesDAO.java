package dao;

import java.util.List;

import model.Evaluaciones;

public interface EvaluacionesDAO {

	List<Evaluaciones> getAll();

	List<Evaluaciones> getByCod(int cod);

}
