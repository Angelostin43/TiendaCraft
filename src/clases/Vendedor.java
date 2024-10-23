package clases;

public class Vendedor extends Persona{
	protected int codigoVendedor;
	private int categoria;
	
	public Vendedor(int codigoVendedor, int categoria, String nombres,String apellido,String telefono, String dni) {
		super(nombres,apellido,telefono,dni);
		this.codigoVendedor = codigoVendedor;
		this.categoria = categoria;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
}
