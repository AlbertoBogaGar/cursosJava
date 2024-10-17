package service;

import java.util.List;

import model.Evaluaciones;
import repository.EvaluacionesRepository;

public class EvaluacionesService {

	//SELECT ALL
		public List<Evaluaciones> getAll(){
			return EvaluacionesRepository.getInstance().getAll();
		}
		public List<Evaluaciones> getByCod(int cod){
			return EvaluacionesRepository.getInstance().getByCod(cod);
		}
}
