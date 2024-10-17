package init;

import java.sql.Date;
import java.time.LocalDate;

import model.Alumnos;
import service.AlumnoService;
import service.CursosService;
import service.EvaluacionesService;
import util.DBConnection;

public class Init {
	public static void main(String[] args) {
		AlumnoService as = new AlumnoService();
		CursosService cs=new CursosService();
		EvaluacionesService es = new EvaluacionesService();
		/*System.out.println(as.getAll());
		System.out.println(as.insert(new Alumnos(10, "Adrian", "Sanchez", "65", Date.valueOf(LocalDate.now()))));
		System.out.println(as.update(new Alumnos(10, "Adrian", "Sanchez", "65", Date.valueOf(LocalDate.of(2003,10,4)))));
		System.out.println(as.delete(10));
		System.out.println(cs.getAll());
		System.out.println(es.getAll());
		System.out.println(es.getByCod(3));*/
		
		as.escribirAlumnos();
		DBConnection.getInstance().destroyConnection();
	}
}
