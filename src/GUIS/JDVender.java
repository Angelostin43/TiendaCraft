package GUIS;

import arreglos.*;
import clases.*;
import arreglos.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JDVender extends JDialog implements ActionListener {
	private JLabel lblCodigoCliente;
	private JTextField txtCodigoCliente;
	private JLabel lblCodigoVendedor;
	private JTextField txtCodigoVendedor;
	private JLabel lblCodigoProducto;
	private JTextField txtCodigoProducto;
	private JLabel lblUnidad;
	private JTextField txtUnidad;
	private JButton btnProcesar;
	private JScrollPane scrollPane_1;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDVender dialog = new JDVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDVender() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/vender.png"));
		setResizable(true);
		setTitle("Ventas de Productos");
		setBounds(100, 100, 450, 345);
		getContentPane().setLayout(null);
		
		lblCodigoCliente = new JLabel("Código del cliente");
		lblCodigoCliente.setBounds(10, 11, 179, 14);
		getContentPane().add(lblCodigoCliente);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(158, 11, 86, 22);
		getContentPane().add(txtCodigoCliente);
		
		lblCodigoVendedor = new JLabel("Código del vendedor");
		lblCodigoVendedor.setBounds(10, 36, 160, 14);
		getContentPane().add(lblCodigoVendedor);
		
		txtCodigoVendedor = new JTextField();
		txtCodigoVendedor.setBounds(158, 36, 86, 22);
		getContentPane().add(txtCodigoVendedor);
		
		lblCodigoProducto = new JLabel("Código del producto");
		lblCodigoProducto.setBounds(10, 61, 160, 14);
		getContentPane().add(lblCodigoProducto);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setBounds(158, 61, 86, 22);
		getContentPane().add(txtCodigoProducto);
		
		lblUnidad = new JLabel("Unidades a vender");
		lblUnidad.setBounds(10, 86, 160, 14);
		getContentPane().add(lblUnidad);
		
		txtUnidad = new JTextField();
		txtUnidad.setBounds(158, 87, 86, 20);
		getContentPane().add(txtUnidad);
		txtUnidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 414, 167);
		getContentPane().add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		scrollPane.setViewportView(txtArea);
	}
	
	ArregloClientes ac = new ArregloClientes();
	ArregloVendedores av = new ArregloVendedores();
	ArregloProductos ap = new ArregloProductos();
	ArregloFactura af = new ArregloFactura();
	private JScrollPane scrollPane;
	private JTextArea txtArea;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int numVentas = 0;
		numVentas ++;
		
		if(ac.buscar(leerCodCliente()) == null) {
			mensaje("Ingrese un codigo de cliente existente");
			return;
		}
		
		if(av.buscar(leerCodVendedor()) == null) {
			mensaje("Ingrese un codigo de vendedor existente");
			return;
		}
		
        if(ap.buscar(leerCodProducto()) == null) {
        	mensaje("Ingrese un codigo de producto existente");
			return;
		}

        int codFactura = af.numeroCorrelativo();
        int codVendedor = leerCodVendedor();
        int codProducto = leerCodProducto();
        int unidades = leerUnidades();
        double precio = ap.buscar(codProducto).getPrecio();
       
        Factura nuevo = new Factura(unidades,codVendedor,codFactura,codProducto,precio);
        af.adicionar(nuevo);
        
		listar();
	}
	
	
	//Métodos tipo void (sin parámetros)
	void imprimir(String s) {
		txtArea.append(s+ "\n");;
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar() {
		txtArea.setText("");
		int codProducto = leerCodProducto();
		Producto prod = ap.buscar(codProducto);
		imprimir("Código de cliente           : " + leerCodCliente());
		imprimir("Código de vendedor        : " + leerCodVendedor());
		imprimir("Código de producto          : " + codProducto);
		imprimir("Descripción del producto : " + prod.getDescripcion());
		imprimir("Precio del producto          : " + prod.getPrecio());
		imprimir("Importe de Compra          : " + ObtenerImpcom());
		imprimir("Importe del IGV               : " + ObtenerDestoIGV());
		imprimir("Importe total a Pagar       : " + ObtenerImppag());
	}
	
	//Metodos tipo return (sin parametro)
	int leerCodCliente() {
		return Integer.parseInt(txtCodigoCliente.getText().trim());
	}
	
	int leerCodVendedor() {
		return Integer.parseInt(txtCodigoVendedor.getText().trim());
	}
	
	int leerCodProducto() {
		return Integer.parseInt(txtCodigoProducto.getText().trim());
	}
	
	int leerUnidades() {
		return Integer.parseInt(txtUnidad.getText().trim());
	}
		
	double ObtenerImpcom() {
		return leerUnidades() * ap.buscar(leerCodProducto()).getPrecio();
	}
		
	double ObtenerDestoIGV() {
		return ObtenerImpcom() * 0.18;
	}
		
	double ObtenerImppag() {
		return ObtenerImpcom() + ObtenerDestoIGV();
	}
}