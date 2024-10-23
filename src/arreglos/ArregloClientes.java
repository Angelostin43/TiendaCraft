package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Cliente;

public class ArregloClientes {
	private ArrayList <Cliente> Cliente;
	
	public ArregloClientes() {
		Cliente = new ArrayList <Cliente>();
		cargarClientes();
	}
	
	public void adicionar(Cliente c) {
		Cliente.add(c);
		grabarClientes();
	}
	
	public int tamanio() {
		return Cliente.size();
	}
	
	public Cliente obtener(int i) {
		return Cliente.get(i);
	}
	
    public void eliminar(Cliente c) {
		Cliente.remove(c);
		grabarClientes();
	}
	
	public Cliente buscar(int cod) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodigoCliente() == cod)
				return obtener(i);
		return null;
	}
	
	private void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente c;
			pw = new PrintWriter(new FileWriter("Clientes.txt"));
			for(int i=0;i<tamanio();i++) {
				c = obtener(i);
				linea = c.getCodigoCliente() + ";" +
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
	
	private void cargarClientes() {
		try {
			BufferedReader br;
			String linea, nombres, apellido, telefono , dni;
			String[] s;
			int codigoCliente;
			br = new BufferedReader(new FileReader("Clientes.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoCliente = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellido = s[2].trim();
				telefono = s[3].trim();
				dni = s[4];
				adicionar(new Cliente(codigoCliente,nombres,apellido,telefono,dni));
			}
			br.close();
		}
		catch(Exception e) {	
		}
	}
	
	public void actualizarTxt() {
		grabarClientes();
	}
	
	public int numeroCorrelativo() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigoCliente() + 1;
	}
}
