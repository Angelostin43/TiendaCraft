package clases;

public class Persona {
	protected String nombres;
	protected String apellido;
	protected String telefono;
	protected String dni;

	public Persona(String nombres, String apellido, String telefono, String dni) {
		this.nombres = nombres;
		this.apellido = apellido;
		this.telefono = telefono;
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
