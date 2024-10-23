package GUIS;

import clases.Cliente;
import arreglos.ArregloClientes;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JDClientes extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField txtCodigo;
	private JTextField txtNombre;
		private JTextField txtApellido;
		private JTextField txtTelefono;
	private JTextField txtDni;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDClientes dialog = new JDClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/cliente.png"));
		setTitle("Mantenimiento Clientes");
		setBounds(100, 100, 647, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		scrollPane.setBounds(10, 139, 611, 184);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		 modelo = new DefaultTableModel();
		 modelo.addColumn("Codigo");
		 modelo.addColumn("Nombre");
		 modelo.addColumn("Apellido");
		 modelo.addColumn("Telefono");
		 modelo.addColumn("DNI");
		 table.setModel(modelo);
		 
		 btnConsultar = new JButton("Consultar");
		 btnConsultar.setBounds(532, 15, 89, 23);
		 btnConsultar.addActionListener(this);
		 contentPanel.add(btnConsultar);
		 
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.setBounds(532, 49, 89, 23);
		 btnEliminar.addActionListener(this);
		 contentPanel.add(btnEliminar);
		 
		 btnIngresar = new JButton("Ingresar");
		 btnIngresar.setBounds(431, 15, 89, 23);
		 btnIngresar.addActionListener(this);
		 contentPanel.add(btnIngresar);
		 
		 btnModificar = new JButton("Modificar");
		 btnModificar.setBounds(431, 49, 89, 23);
		 btnModificar.addActionListener(this);
		 contentPanel.add(btnModificar);
		 
		 JLabel lblNewLabel = new JLabel("Codigo:");
		 lblNewLabel.setBounds(10, 15, 46, 14);
		 contentPanel.add(lblNewLabel);
		 
		 txtCodigo = new JTextField();
		 txtCodigo.setBounds(78, 15, 86, 20);
		 txtCodigo.setEditable(false);
		 txtCodigo.setText("1001");
		 contentPanel.add(txtCodigo);
		 txtCodigo.setColumns(10);
		 
		 JLabel lblNewLabel_1 = new JLabel("Nombre:");
		 lblNewLabel_1.setBounds(10, 49, 71, 14);
		 contentPanel.add(lblNewLabel_1);
		 
		 txtNombre = new JTextField();
		 txtNombre.setBounds(78, 50, 86, 20);
		 txtNombre.setEnabled(false);
		 contentPanel.add(txtNombre);
		 txtNombre.setColumns(10);
		 
		 JLabel lblNewLabel_2 = new JLabel("Apellido:");
		 lblNewLabel_2.setBounds(180, 49, 78, 14);
		 contentPanel.add(lblNewLabel_2);
		 
		 txtApellido = new JTextField();
		 txtApellido.setBounds(235, 46, 86, 20);
		 txtApellido.setEnabled(false);
		 contentPanel.add(txtApellido);
		 txtApellido.setColumns(10);
		 
		 JLabel lblNewLabel_3 = new JLabel("Telefono:");
		 lblNewLabel_3.setBounds(10, 83, 71, 14);
		 contentPanel.add(lblNewLabel_3);
		 
		 txtTelefono = new JTextField();
		 txtTelefono.setBounds(78, 80, 86, 20);
		 txtTelefono.setEnabled(false);
		 contentPanel.add(txtTelefono);
		 txtTelefono.setColumns(10);
		 
		 txtDni = new JTextField();
		 txtDni.setBounds(78, 108, 86, 20);
		 txtDni.setEnabled(false);
		 contentPanel.add(txtDni);
		 txtDni.setColumns(10);
		 
		 JLabel lblNewLabel_4 = new JLabel("DNI:");
		 lblNewLabel_4.setBounds(10, 111, 46, 14);
		 contentPanel.add(lblNewLabel_4);
		 
		 btnAceptar = new JButton("Aceptar");
		 btnAceptar.setBounds(180, 107, 89, 23);
		 btnAceptar.addActionListener(this);
		 btnAceptar.setEnabled(false);
		 contentPanel.add(btnAceptar);
		 
		 listar();
	}
	
	ArregloClientes ar = new ArregloClientes();

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnIngresar) {
			actionPerformedbtnIngresar(e);
		}
	    if (e.getSource() == btnModificar) {
	        actionPerformedbtnModificar(e);
	    }
	    if (e.getSource() == btnAceptar) {
	        actionPerformedbtnAceptar(e);
	    }
	    if (e.getSource() == btnConsultar) {
	        actionPerformedbtnConsultar(e);
	    }
	    if (e.getSource() == btnEliminar) {
	        actionPerformedbtnEliminar(e);
	    }
	}
    
    protected void actionPerformedbtnIngresar(ActionEvent e) {
    	btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitar(true);
		txtNombre.requestFocus();
 	}
	
    private void actionPerformedbtnModificar(ActionEvent e) {
    	btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (ar.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitar(false);
			mensaje("No hay Clientes");	
		}
		else {
			editar();
			btnAceptar.setEnabled(true);
			habilitar(true);
			txtNombre.requestFocus();
		}

	}
   
	private void actionPerformedbtnAceptar(ActionEvent e) {	
		String nombre = leerNombres();
    	String apellido = leerApellido();
    	String telefono = leerTelefono();
    	String Dni = leerDni();
    	int codigo = leerCodigo();
    	if (btnIngresar.isEnabled() == false) {
			Cliente nuevo = new Cliente(codigo,nombre,apellido,telefono,Dni);
			ar.adicionar(nuevo);
			btnIngresar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			Cliente c = ar.buscar(codigo);
			c.setNombres(nombre);
			c.setApellido(apellido);
			c.setTelefono(telefono);
			c.setDni(Dni);
			ar.actualizarTxt();
			btnModificar.setEnabled(true);
			btnAceptar.setEnabled(false);
		}
		if (btnConsultar.isEnabled() == false) {
			Cliente c = ar.buscar(codigo);
			JOptionPane.showMessageDialog(this, 
			"Cliente : " + c + "\n" +
			"Codigo     : " + codigo + "\n" +
			"Nombre   : " + c.getNombres() + "\n" +
			"Apellido   : " + c.getApellido() + "\n" +
			"Telefono : " + c.getTelefono() + "\n" +
			"Dni           : " + c.getDni());
			btnConsultar.setEnabled(true);
			txtCodigo.setEnabled(false);
			txtCodigo.setEditable(false);
		}
		listar();
		habilitar(false);
	}

	private void actionPerformedbtnConsultar(ActionEvent e) {
		habilitar(false);
		btnConsultar.setEnabled(false);
		if(ar.tamanio() <= 0) {
			btnConsultar.setEnabled(true);
			mensaje("No hay Clientes");
		}else {
			btnAceptar.setEnabled(true);
			txtCodigo.setEnabled(true);
			txtCodigo.setEditable(true);
		}
	}
	
	private void actionPerformedbtnEliminar(ActionEvent e) {	
		btnAceptar.setEnabled(false);
		if (ar.tamanio() == 0)
			mensaje("No existen clientes");
		else {
			try {
			boolean clienteEncontrado = false;
			do {
				String codigoString = JOptionPane.showInputDialog("Ingrese el codigo del cliente a eliminar:");
				int codigo = Integer.parseInt(codigoString);
				Cliente clienteAEliminar = ar.buscar(codigo);

				if (clienteAEliminar != null) {
					ar.eliminar(clienteAEliminar);
					clienteEncontrado = true;
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el código ingresado.",
						"Cliente no encontrado", JOptionPane.WARNING_MESSAGE);
				}
			} while (!clienteEncontrado);
			listar();
			}catch(Exception n) {
				mensaje("No ingreso ningun Codigo");
			}
		}
	}
	
	//Metodos 
	
	void habilitar(boolean b) {
		txtNombre.setEnabled(b);
		txtApellido.setEnabled(b);
		txtTelefono.setEnabled(b);
		txtDni.setEnabled(b);
	}
	
	void editar() {
		int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        Cliente c = ar.obtener(selectedRow);
	        txtCodigo.setText("" + c.getCodigoCliente());
	        txtNombre.setText(c.getNombres());
	        txtApellido.setText(c.getApellido());
	        txtTelefono.setText(c.getTelefono());
	        txtDni.setText(c.getDni());
	    } else {
	        limpieza();
	    }
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (modelo.getRowCount() == ar.tamanio() - 1)
			posFila = ar.tamanio() - 1;
		if (posFila == ar.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Cliente c;
		for(int i=0;i<ar.tamanio();i++) {
			c = ar.obtener(i);
			Object[] fila = {
					c.getCodigoCliente(),
					c.getNombres(),
					c.getApellido(),
					c.getTelefono(),
					c.getDni() };
			modelo.addRow(fila);
		}
		if (ar.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void limpieza() {
		txtCodigo.setText("" + ar.numeroCorrelativo());
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	String leerNombres() {
		return txtNombre.getText().trim();
	}
	
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	
	String leerDni() {
		return txtDni.getText().trim();
	}
	
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
}
