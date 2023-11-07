package objetos1.Ejercicio_21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pasajero extends Usuario{
	
	private List<Viaje> viajes;
	
	public Pasajero(String nombre) {
		super(nombre);
		this.viajes = new ArrayList<>();
	}

	public void cargarMonto(double monto) {
		if(this.viajes.isEmpty() || comprobarViajes()) {
			super.cargarSaldo(monto - (monto * 0.1));
		}
	}
	
	private boolean comprobarViajes() {
		return this.viajes.stream()
		.filter(viaje -> viaje.calcularComision())
		.collect(Collectors.toList())
		.isEmpty();
	}

	public void descontarMonto(double monto) {
		double bonificacion = 0;
		if(!this.viajes.isEmpty()) {
			bonificacion = 500;
		}
		super.descontarSaldo(monto - bonificacion);
	}

}
