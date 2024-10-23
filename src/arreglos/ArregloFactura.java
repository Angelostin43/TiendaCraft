package arreglos;

import clases.Factura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloFactura {
	private ArrayList <Factura> Factura;
	
	public ArregloFactura() {
		Factura = new ArrayList <Factura>();
		cargarFactura();
	}
	
	public void adicionar(Factura f) {
		Factura.add(f);
		grabarFactura();
	}
	
	public int tamanio() {
		return Factura.size();
	}
	
	public Factura obtener(int i) {
		return Factura.get(i);
	}
	
    public void eliminar(Factura f) {
    	Factura.remove(f);
		grabarFactura();
	}
	
	public Factura buscar(int cod) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigoFactura() == cod)
				return obtener(i);
		return null;
	}
	
	private void grabarFactura() {
		try {
			PrintWriter pw;
			String linea;
			Factura f;
			pw = new PrintWriter(new FileWriter("Facturas.txt"));
			for(int i=0;i<tamanio();i++) {
				f = obtener(i);
				linea = f.getUnidades() + ";" +
						f.getCodigoVendedor() + ";" +
						f.getCodigoFactura() + ";" +
				        f.getCodigoProducto() + ";" +
				        f.getPrecio();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	
	private void cargarFactura() {
		try {
			BufferedReader br;
			String[] s;
			String linea;
			double precio;
			int unidades,codigoVendedor,codigoFactura,codigoProducto;
			br = new BufferedReader(new FileReader("Facturas.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				unidades = Integer.parseInt(s[0].trim());
				codigoVendedor = Integer.parseInt(s[1].trim());
				codigoFactura = Integer.parseInt(s[2].trim());
				codigoProducto = Integer.parseInt(s[3].trim());
				precio = Double.parseDouble(s[4].trim());
				adicionar(new Factura(unidades,codigoVendedor,codigoFactura,codigoProducto,precio));
			}
			br.close();
		}
		catch(Exception e) {	
		}
	}
	
	public void actualizarTxt() {
		grabarFactura();
	}
	
	public int numeroCorrelativo() {
		if (tamanio() == 0)
			return 4001;
		else
			return obtener(tamanio()-1).getCodigoFactura() + 1;
	}
}

