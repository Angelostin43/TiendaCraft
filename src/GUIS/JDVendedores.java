package GUIS;


import clases.Vendedor;

import arreglos.ArregloVendedores;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class JDVendedores extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JButton btnIngresar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox cmbCategoria;
	private JButton btnAceptar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDVendedores dialog = new JDVendedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDVendedores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/Vendedores.png"));
		setTitle("Mantenimiento Vendedores");
		setBounds(100, 100, 647, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 611, 184);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		 modelo.addColumn("Codigo");
		 modelo.addColumn("Categoria");
		 modelo.addColumn("Nombre");
		 modelo.addColumn("Apellido");
		 modelo.addColumn("Telefono");
		 modelo.addColumn("DNI");
		 table.setModel(modelo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(532, 11, 89, 23);
		contentPanel.add(btnConsultar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(433, 11, 89, 23);
		contentPanel.add(btnIngresar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(532, 46, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(433, 46, 89, 23);
		contentPanel.add(btnModificar);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("2001");
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(78, 11, 86, 20);
		contentPanel.add(txtCodigo);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 45, 71, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(78, 46, 86, 20);
		contentPanel.add(txtNombre);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(174, 46, 78, 14);
		contentPanel.add(lblNewLabel_2);
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(235, 42, 86, 20);
		contentPanel.add(txtApellido);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setBounds(10, 79, 71, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(78, 76, 86, 20);
		contentPanel.add(txtTelefono);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setBounds(10, 107, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		txtDni = new JTextField();
		txtDni.setEnabled(false);
		txtDni.setColumns(10);
		txtDni.setBounds(78, 104, 86, 20);
		contentPanel.add(txtDni);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(180, 103, 89, 23);
		contentPanel.add(btnAceptar);
		
		JLabel lblNewLabel_5 = new JLabel("Categoria:");
		lblNewLabel_5.setBounds(174, 15, 86, 14);
		contentPanel.add(lblNewLabel_5);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setEnabled(false);
		cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cmbCategoria.setBounds(235, 11, 86, 22);
		contentPanel.add(cmbCategoria);
		listar();
	}
	
	ArregloVendedores av = new ArregloVendedores();

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

	private void actionPerformedbtnEliminar(ActionEvent e) {
		btnAceptar.setEnabled(false);
		if (av.tamanio() == 0)
			mensaje("No existen vendedores");
		else {
			try {
			boolean vendedorEncontrado = false;
			do {
				String codigoString = JOptionPane.showInputDialog("Ingrese el codigo del vendedor a eliminar:");
				int codigo = Integer.parseInt(codigoString);
				Vendedor vendedorAEliminar = av.buscar(codigo);

				if (vendedorAEliminar != null) {
					av.eliminar(vendedorAEliminar);
					vendedorEncontrado = true;
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró ningún vendedor con el código ingresado.",
						"Vendedor no encontrado", JOptionPane.WARNING_MESSAGE);
				}
			} while (!vendedorEncontrado);
			listar();
			}catch(Exception n) {
				mensaje("No ingreso ningun Codigo");
			}
		}	
	}

	private void actionPerformedbtnConsultar(ActionEvent e) {
		habilitar(false);
		btnConsultar.setEnabled(false);
		if(av.tamanio() <= 0) {
			btnConsultar.setEnabled(true);
			mensaje("No hay Vendedores");
		}else {
			btnAceptar.setEnabled(true);
			txtCodigo.setEnabled(true);
			txtCodigo.setEditable(true);
		}
	}

	private void actionPerformedbtnAceptar(ActionEvent e) {
		String nombre = leerNombres();
    	String apellido = leerApellido();
    	String telefono = leerTelefono();
    	String Dni = leerDni();
    	int codigo = leerCodigo();
    	int categoria = leerCategoria();
    	if (btnIngresar.isEnabled() == false) {
    		Vendedor nuevo = new Vendedor(codigo,categoria,nombre,apellido,telefono,Dni);
			av.adicionar(nuevo);
			btnIngresar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			Vendedor v = av.buscar(codigo);
			v.setNombres(nombre);
			v.setCategoria(categoria);
			v.setApellido(apellido);
			v.setTelefono(telefono);
			v.setDni(Dni);
			av.actualizarTxt();
			btnModificar.setEnabled(true);
			btnAceptar.setEnabled(false);
		}
		if (btnConsultar.isEnabled() == false) {
			Vendedor v = av.buscar(codigo);
			JOptionPane.showMessageDialog(this, 
			"Vendedor : " + v + "\n" +
			"Codigo     : " + codigo + "\n" +
			"Categoria     : " + categoria + "\n" +
			"Nombre   : " + v.getNombres() + "\n" +
			"Apellido   : " + v.getApellido() + "\n" +
			"Telefono : " + v.getTelefono() + "\n" +
			"Dni           : " + v.getDni());
			btnConsultar.setEnabled(true);
			txtCodigo.setEnabled(false);
			txtCodigo.setEditable(false);
		}
		listar();
		habilitar(false);
	}

	private void actionPerformedbtnModificar(ActionEvent e) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (av.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitar(false);
			mensaje("No hay Vendedores");	
		}
		else {
			editar();
			btnAceptar.setEnabled(true);
			habilitar(true);
			txtNombre.requestFocus();
		}
	}

	private void actionPerformedbtnIngresar(ActionEvent e) {
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		cmbCategoria.setEnabled(true);
		limpieza();
		habilitar(true);
		txtNombre.requestFocus();	
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
	    	Vendedor c = av.obtener(selectedRow);
	        txtCodigo.setText("" + c.getCodigoVendedor());
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
		if (modelo.getRowCount() == av.tamanio() - 1)
			posFila = av.tamanio() - 1;
		if (posFila == av.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Vendedor v;
		for(int i=0;i<av.tamanio();i++) {
			v = av.obtener(i);
			Object[] fila = {
					v.getCodigoVendedor(),
					v.getCategoria(),
					v.getNombres(),
					v.getApellido(),
					v.getTelefono(),
					v.getDni() };
			modelo.addRow(fila);
		}
		if (av.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void limpieza() {
		txtCodigo.setText("" + av.numeroCorrelativo());
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
	
	int leerCategoria() {
		 return Integer.parseInt(cmbCategoria.getSelectedItem().toString());
	}
}
