package model;

import java.util.Objects;

public class Evaluaciones {
	private int cod;
	private String nom_alu;
	private String ape;
	private String nom_cur;
	private int nota;
	private String observaciones;
	public Evaluaciones(String nom_alu, String ape, String nom_cur, int nota, String observaciones) {
		
		this.nom_alu = nom_alu;
		this.ape = ape;
		this.nom_cur = nom_cur;
		this.nota = nota;
		this.observaciones = observaciones;
	}
	
	public Evaluaciones(int cod, String nom_alu, String ape, String nom_cur, int nota, String observaciones) {
		
		this.cod = cod;
		this.nom_alu = nom_alu;
		this.ape = ape;
		this.nom_cur = nom_cur;
		this.nota = nota;
		this.observaciones = observaciones;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNom_alu() {
		return nom_alu;
	}
	public void setNom_alu(String nom_alu) {
		this.nom_alu = nom_alu;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public String getNom_cur() {
		return nom_cur;
	}
	public void setNom_cur(String nom_cur) {
		this.nom_cur = nom_cur;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ape, cod, nom_alu, nom_cur, nota, observaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluaciones other = (Evaluaciones) obj;
		return Objects.equals(ape, other.ape) && cod == other.cod && Objects.equals(nom_alu, other.nom_alu)
				&& Objects.equals(nom_cur, other.nom_cur) && nota == other.nota
				&& Objects.equals(observaciones, other.observaciones);
	}

	@Override
	public String toString() {
		return "nom_alu=" + nom_alu + ", ape=" + ape + ", nom_cur=" + nom_cur + ", nota=" + nota
				+ ", observaciones=" + observaciones + "\n";
	}
	
	
	
	
}
