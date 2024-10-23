package clases;

public class Cliente extends Persona{
	private int codigoCliente;
	
	public Cliente(int codigoCliente ,String nombres,String apellido,String telefono, String dni) {
		super(nombres,apellido,telefono,dni);
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}
