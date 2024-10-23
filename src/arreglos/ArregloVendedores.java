package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Vendedor;

public class ArregloVendedores {
	private ArrayList <Vendedor> Vendedor;
	
	public ArregloVendedores() {
		Vendedor = new ArrayList <Vendedor>();
		cargarVendedores();	
	}
	
	public void adicionar(Vendedor v) {
		Vendedor.add(v);
		grabarVendedores();
	}
	
	public int tamanio() {
		return Vendedor.size();
	}
	
	public Vendedor obtener(int i) {
		return Vendedor.get(i);
	}
	
    public void eliminar(Vendedor v) {
    	Vendedor.remove(v);
		grabarVendedores();
	}
	
	public Vendedor buscar(int cod) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigoVendedor() == cod)
				return obtener(i);
		return null;
	}
	
	private void grabarVendedores() {
		try {
			PrintWriter pw;
			String linea;
			Vendedor c;
			pw = new PrintWriter(new FileWriter("Vendedores.txt"));
			for(int i=0;i<tamanio();i++) {
				c = obtener(i);
				linea = c.getCodigoVendedor() + ";" +
				        c.getCategoria() + ";" +
				        c.getNombres() + ";" +
				        c.getApellido() + ";" +
				        c.getTelefono() + ";" +
				        c.getDni();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	
	private void cargarVendedores() {
		try {
			BufferedReader br;
			String linea, nombres, apellido, telefono , dni;
			String[] s;
			int codigoVendedor,categoria;
			br = new BufferedReader(new FileReader("Vendedores.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoVendedor = Integer.parseInt(s[0].trim());
				categoria = Integer.parseInt(s[1].trim());
				nombres = s[2].trim();
				apellido = s[3].trim();
				telefono = s[4].trim();
				dni = s[5];
				adicionar(new Vendedor(codigoVendedor,categoria,nombres,apellido,telefono,dni));
			}
			br.close();
		}
		catch(Exception e) {	
		}
	}
	
	public void actualizarTxt() {
		grabarVendedores();
	}
	
	public int numeroCorrelativo() {
		if (tamanio() == 0)
			return 2001;
		else
			return obtener(tamanio()-1).getCodigoVendedor() + 1;
	}
}
