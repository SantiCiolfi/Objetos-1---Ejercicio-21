package objetos1.Ejercicio_21;

import java.time.LocalDate;

public class Vehiculo {
	
	private Conductor conductor;
	private String descripcion;
	private int capacidad;
	private int anioFabricacion;
	private double valorEnMercado;
	
	public Vehiculo(Conductor conductor, String descripcion, int capacidad, int anioFabricacion,double valorEnMercado) {
		this.conductor = conductor;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.anioFabricacion = anioFabricacion;
		this.valorEnMercado = valorEnMercado;
	}
	
	public boolean hayEspacio(int pasajerosActuales) {
		return this.capacidad > pasajerosActuales;
	}
	
	public boolean menosDe5DeAntiguedad() {
		return this.anioFabricacion < 5;
	}
	
	public Conductor getConductor() {
		return this.conductor;
	}
	
	public double bonificacion() {
		return this.valorEnMercado * 0.001;
	}
}
