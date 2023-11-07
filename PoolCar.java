package objetos1.Ejercicio_21;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoolCar {
	
	private List<Usuario> usuarios;
	private List<Viaje> viajes;
	
	public PoolCar() {
		this.usuarios = new ArrayList<>();
		this.viajes = new ArrayList<>();
	}
	
	public Conductor darDeAltaConductor(String unNombre, Vehiculo unVehiculo) {
		Conductor conductor = new Conductor(unNombre, unVehiculo);
		this.usuarios.add(conductor);
		return conductor;
	}
	
	public Pasajero darDeAltaPasajero(String unNombre) {
		Pasajero pasajero = new Pasajero(unNombre);
		this.usuarios.add(pasajero);
		return pasajero;
	}
	
	public void cargarSaldo(Usuario unUsuario, double monto) {
		if(this.usuarios.contains(unUsuario)) {
			unUsuario.cargarMonto(monto);
		}
	}
	
	public Viaje darDeAltaViaje(String origen, String destino, double costoTotal, Vehiculo unVehiculo, LocalDate fecha) {
		Viaje viaje = new Viaje(origen, destino, costoTotal, unVehiculo, fecha);
		this.viajes.add(viaje);
		return viaje;
	}
	
	public List<Viaje> listarViajesDiaSiguiente(){
		return this.viajes.stream()
				.filter(viaje -> viaje.comienzaMañana())
				.collect(Collectors.toList());
	}
	
	public void procesarViajes() {
		this.listarViajesDiaSiguiente().forEach(viaje -> viaje.procesarViaje());
	}
	
	public List<Usuario> getUsuariosRegistrados(){
		return this.usuarios.stream()
				.sorted((usu1, usu2) -> Double.compare(usu1.getSaldo(), usu2.getSaldo()))
				.collect(Collectors.toList());
	}
	
	public void cargarMontoDeReglao(double monto) {
		this.usuarios.forEach(usuario -> usuario.cargarSaldoDeRegalo(monto));
	}
	
	public void registrarPasajeroParaUnViaje(Pasajero unPasajero, Viaje unViaje) {
		if(this.usuarios.contains(unPasajero) && (this.viajes.contains(unViaje))) {
			unViaje.registrarPasajero(unPasajero);
		}
	}
}
