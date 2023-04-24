package training.lab8.ej1;

public class Acero {
	public String nombre;
	public double kgHierro;
	public double kGCarbono;
	
	public Acero(String nombre, double kgHierro, double kGCarbono) {
		super();
		this.nombre = nombre;
		this.kgHierro = kgHierro;
		this.kGCarbono = kGCarbono;
	}
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getKgHierro() {
		return kgHierro;
	}



	public void setKgHierro(double kgHierro) {
		this.kgHierro = kgHierro;
	}



	public double getKGCarbono() {
		return kGCarbono;
	}



	public void setKGCarbono(double kGCarbono) {
		this.kGCarbono = kGCarbono;
	}



	public String clasificacionAcero() {
		double totalKg = this.kGCarbono + this.kgHierro;
		double porcentajeCarbono = (this.kGCarbono/totalKg) * 100;
		
		System.out.println("Porcentaje: " + porcentajeCarbono);
		
		if(porcentajeCarbono>40) {
			return "Acero Duro";
		}else {
			return "Acero Dulce";
		}
		
	}
}
