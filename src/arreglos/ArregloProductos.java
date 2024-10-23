package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Producto;

public class ArregloProductos {
	private ArrayList <Producto> Producto;
	
	public ArregloProductos() {
		Producto = new ArrayList <Producto>();
		cargarProducto();
	}
	
	public void adicionar(Producto p) {
		Producto.add(p);
		grabarProducto();
	}
	
	public int tamanio() {
		return Producto.size();
	}
	
	public Producto obtener(int i) {
		return Producto.get(i);
	}
	
    public void eliminar(Producto p) {
    	Producto.remove(p);
		grabarProducto();
	}
	
	public Producto buscar(int cod) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigoProducto() == cod)
				return obtener(i);
		return null;
	}
	
	private void grabarProducto() {
		try {
			PrintWriter pw;
			String linea;
			Producto p;
			pw = new PrintWriter(new FileWriter("Productos.txt"));
			for(int i=0;i<tamanio();i++) {
				p = obtener(i);
				linea = p.getCodigoProducto() + ";" +
				        p.getDescripcion() + ";" +
				        p.getPrecio();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	
	private void cargarProducto() {
		try {
			BufferedReader br;
			String[] s;
			String linea, descripcion;
			double precio;
			int codigoProducto;
			br = new BufferedReader(new FileReader("Productos.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt(s[0].trim());
				descripcion = s[1].trim();
				precio = Double.parseDouble(s[2].trim());
				adicionar(new Producto(codigoProducto,descripcion,precio));
			}
			br.close();
		}
		catch(Exception e) {	
		}
	}
	
	public void actualizarTxt() {
		grabarProducto();
	}
	
	public int numeroCorrelativo() {
		if (tamanio() == 0)
			return 3001;
		else
			return obtener(tamanio()-1).getCodigoProducto() + 1;
	}
}
