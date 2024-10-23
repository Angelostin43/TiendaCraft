package clases;


public class Factura {
	private int unidades;
	private int codigoVendedor;
	private int codigoFactura;
	private int codigoProducto;
	private double precio;
	
	public Factura(int unidades, int codigoVendedor, int codigoFactura, int codigoProducto, double precio) {
		this.codigoFactura = codigoFactura;
		this.codigoProducto = codigoProducto;
		this.codigoVendedor = codigoVendedor;
		this.unidades = unidades;
		this.precio = precio;
	}

	public int getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}	
	
	
	
}
