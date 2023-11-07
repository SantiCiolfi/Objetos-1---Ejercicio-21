package objetos1.Ejercicio_21;

public abstract class Usuario {
	
	private String nombre;
	private double saldo;
	
	public Usuario(String nombre) {
		this.nombre=nombre;
		this.saldo=0;
	}
	
	public boolean verificarSaldo() {
		return this.saldo > 0;
	}
	
	protected void cargarSaldo(double monto) {
		this.saldo = this.saldo + monto;
	}
	
	public void cargarSaldoDeRegalo(double monto) {
		this.saldo = this.saldo + monto;
	}
	
	protected void descontarSaldo(double monto) {
		this.saldo = this.saldo - monto;	
	}
	
	public abstract void cargarMonto(double monto);
	
	public abstract void descontarMonto (double monto);
	
	public double getSaldo() {
		return this.saldo;
	}
}
