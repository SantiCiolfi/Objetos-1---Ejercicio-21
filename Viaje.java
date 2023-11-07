package objetos1.Ejercicio_21;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
	
	private String origen;
	private String destino;
	private double costoTotal;
	private Vehiculo vehiculo;
	private LocalDate fechaDelViaje;
	private List<Usuario> pasajeros;
	
	public Viaje(String origen, String destino, double costoTotal, Vehiculo unVehiculo, LocalDate fechaDelViaje) {
		this.origen = origen;
		this.destino = destino;
		this.costoTotal = costoTotal;
		this.vehiculo = unVehiculo;
		this.fechaDelViaje = fechaDelViaje;
		this.pasajeros = new ArrayList<>();
		this.registrarPasajero(unVehiculo.getConductor());
	}
	
	public void registrarPasajero(Usuario unUsuario) {
		if(this.hayEspacio() && (this.registroHabilitado()) && (this.verificarSaldo(unUsuario))) {
			this.pasajeros.add(unUsuario);
		}
	}
	
	private boolean hayEspacio() {
		return this.vehiculo.hayEspacio(this.pasajeros.size());
	}
	
	private boolean registroHabilitado() {
		return this.compararFechas() >= 2;
	}
	
	private boolean verificarSaldo(Usuario unUsuario) {
		return unUsuario.verificarSaldo();
	}
	
	private long compararFechas() {
		long dias;
		dias = ChronoUnit.DAYS.between(LocalDate.now(), fechaDelViaje);
		return dias;
	}
	
	public boolean calcularComision() {
		return this.compararFechas() < 30;
	}
	
	public boolean comienzaMañana() {
		return this.compararFechas() == 1;
	}
	
	public void procesarViaje() {
		double costoIndividual = this.costoTotal / this.pasajeros.size();
		this.pasajeros.forEach(pasajero -> pasajero.descontarMonto(costoIndividual));
	}
}
