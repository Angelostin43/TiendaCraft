package GUIS;

import clases.Cliente;
import clases.Producto;
import arreglos.ArregloProductos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class JDProductos extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JButton btnIngresar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDProductos dialog = new JDProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDProductos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/productos.png"));
		setTitle("Mantenimiento Productos");
		setBounds(100, 100, 503, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 467, 186);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		 modelo.addColumn("Codigo");
		 modelo.addColumn("Descripcion");
		 modelo.addColumn("Precio");
		 table.setModel(modelo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(287, 11, 89, 23);
		btnIngresar.addActionListener(this);
		contentPanel.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(287, 45, 89, 23);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(388, 11, 89, 23);
		btnConsultar.addActionListener(this);
		contentPanel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(388, 45, 89, 23);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPanel.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("3001");
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(78, 11, 86, 20);
		contentPanel.add(txtCodigo);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setBounds(10, 61, 105, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEnabled(false);
		txtDescripcion.setBounds(88, 46, 168, 45);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setBounds(10, 111, 105, 14);
		contentPanel.add(lblNewLabel_2);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setBounds(78, 108, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(183, 105, 89, 23);
		btnAceptar.addActionListener(this);
		contentPanel.add(btnAceptar);
		
		listar();
	}
	
	ArregloProductos ap = new ArregloProductos();
	
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

	private void actionPerformedbtnIngresar(ActionEvent e) {
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitar(true);
		txtDescripcion.requestFocus();
	}

	private void actionPerformedbtnModificar(ActionEvent e) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (ap.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitar(false);
			mensaje("No hay Productos");	
		}
		else {
			editar();
			btnAceptar.setEnabled(true);
			habilitar(true);
			txtDescripcion.requestFocus();
		}
	}

	private void actionPerformedbtnAceptar(ActionEvent e) {
    	String descripcion = leerDescripcion();
    	double precio = leerPrecio();
    	int codigo = leerCodigo();
    	if (btnIngresar.isEnabled() == false) {
			Producto nuevo = new Producto(codigo,descripcion,precio);
			ap.adicionar(nuevo);
			btnIngresar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			Producto p = ap.buscar(codigo);
			p.setDescripcion(descripcion);
			p.setPrecio(precio);
			ap.actualizarTxt();
			btnModificar.setEnabled(true);
			btnAceptar.setEnabled(false);
		}
		if (btnConsultar.isEnabled() == false) {
			Producto c = ap.buscar(codigo);
			JOptionPane.showMessageDialog(this, 
			"Producto : " + c + "\n" +
			"Codigo     : " + codigo + "\n" +
			"Descripcion   : " + c.getDescripcion() + "\n" +
			"Precio          : " + c.getPrecio());
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
		if(ap.tamanio() <= 0) {
			btnConsultar.setEnabled(true);
			mensaje("No hay Productos");
		}else {
			btnAceptar.setEnabled(true);
			txtCodigo.setEnabled(true);
			txtCodigo.setEditable(true);
		}
	}

	private void actionPerformedbtnEliminar(ActionEvent e) {
		btnAceptar.setEnabled(false);
		if (ap.tamanio() == 0)
			mensaje("No existen productos");
		else {
			try {
			boolean productoEncontrado = false;
			do {
				String codigoString = JOptionPane.showInputDialog("Ingrese el codigo del producto a eliminar:");
				int codigo = Integer.parseInt(codigoString);
				Producto productoAEliminar = ap.buscar(codigo);

				if (productoAEliminar != null) {
					ap.eliminar(productoAEliminar);
					productoEncontrado = true;
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el código ingresado.",
						"Producto no encontrado", JOptionPane.WARNING_MESSAGE);
				}
			} while (!productoEncontrado);
			listar();
			}catch(Exception n) {
				mensaje("No ingreso ningun Codigo");
			}
		}
	}
	
	//Metodos
	
	void habilitar(boolean b) {
		txtDescripcion.setEnabled(b);
		txtPrecio.setEnabled(b);
	}
	
	void editar() {
		int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        Producto p = ap.obtener(selectedRow);
	        txtCodigo.setText("" + p.getCodigoProducto());
	        txtDescripcion.setText(p.getDescripcion());
	        txtPrecio.setText("" + p.getPrecio());
	    } else {
	        limpieza();
	    }
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (modelo.getRowCount() == ap.tamanio() - 1)
			posFila = ap.tamanio() - 1;
		if (posFila == ap.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Producto p;
		for(int i=0;i<ap.tamanio();i++) {
			p = ap.obtener(i);
			Object[] fila = {
					p.getCodigoProducto(),
					p.getDescripcion(),
					"S/" +p.getPrecio() };
			modelo.addRow(fila);
		}
		if (ap.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void limpieza() {
		txtCodigo.setText("" + ap.numeroCorrelativo());
		txtDescripcion.setText("");
		txtPrecio.setText("");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	String leerDescripcion() {
		return txtDescripcion.getText().trim();
	}
	
	Double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
}
