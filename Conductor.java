package objetos1.Ejercicio_21;

public class Conductor extends Usuario{
	
	private Vehiculo vehiculo;
	
	public Conductor(String nombre, Vehiculo unVehiculo) {
		super(nombre);
		this.vehiculo=unVehiculo;
	}

	public void cargarMonto(double monto) {
		double comision = 0.10;
		if(this.vehiculo.menosDe5DeAntiguedad()) {
			comision = 0.01;
		}
		super.cargarSaldo(monto - (monto * comision));
	}

	public void descontarMonto(double monto) {
		super.descontarSaldo(monto - this.vehiculo.bonificacion());
	}

}
