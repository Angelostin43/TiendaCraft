package GUIS;

import arreglos.*;
import clases.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Font;

public class JDGenerarReportes extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox cboTipR;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDGenerarReportes dialog = new JDGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDGenerarReportes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/Reporte.png"));
		setTitle("Reportes");
		setBounds(100, 100, 557, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTipoReporte = new JLabel("Tipo de Reporte");
			lblTipoReporte.setBounds(10, 11, 91, 14);
			contentPanel.add(lblTipoReporte);
		}
		{
			cboTipR = new JComboBox();
			cboTipR.addActionListener(this);
			cboTipR.setModel(new DefaultComboBoxModel(new String[] {"Reporte General por Productos","Reporte General por Vendedores",
					"Reporte por vendedor","Reporte por producto","Reporte de precios"}));
			cboTipR.setBounds(111, 7, 321, 22);
			contentPanel.add(cboTipR);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(442, 82, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 116, 521, 306);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				txtS.setEditable(false);
				txtS.setFont(new Font("MS PGothic", Font.PLAIN, 14));
				scrollPane.setViewportView(txtS);
			}
		}
		
		JLabel lblNewLabel = new JLabel("Vendedor");
		lblNewLabel.setBounds(10, 47, 91, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Producto");
		lblNewLabel_1.setBounds(10, 82, 58, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtVendedor = new JTextField();
		txtVendedor.setEditable(false);
		txtVendedor.setBounds(73, 44, 86, 20);
		contentPanel.add(txtVendedor);
		txtVendedor.setColumns(10);
		
		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setBounds(73, 79, 86, 20);
		contentPanel.add(txtProducto);
		txtProducto.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(442, 43, 89, 23);
		contentPanel.add(btnProcesar);
	}

    ArregloProductos ap = new ArregloProductos();
    ArregloVendedores av = new ArregloVendedores();
    ArregloFactura af = new ArregloFactura();
    private JTextField txtVendedor;
    private JTextField txtProducto;
    private JButton btnCerrar;
    private JButton btnProcesar;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipR) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	
	void imprimir(String cad) {
		txtS.append(cad+ "\n");
	}
	
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	
	
	
	protected void actionPerformedComboBox(ActionEvent e) {
		switch (cboTipR.getSelectedIndex()) {
		case 0:
			txtVendedor.setEditable(false);
			txtProducto.setEditable(false);
			break;
		case 1:
			txtVendedor.setEditable(false);
			txtProducto.setEditable(false);
			break;
		case 2:
			txtVendedor.setEditable(true);
			txtProducto.setEditable(false);
			break;
		case 3:
			txtVendedor.setEditable(false);
			txtProducto.setEditable(true);
			break;
		case 4:
			txtVendedor.setEditable(false);
			txtProducto.setEditable(false);
			break;
		}
	}
	
	private void imprimirReporteGeneralPorProductos() {
	    int codigoProductoAnterior = -1;
	    int ventasProducto = 0;
	    int unidadesVendidasProducto = 0;
	    double importeTotalProducto = 0.0;
	    int cont = 1;

	    for (int i = 0; i < af.tamanio(); i++) {
	        int codigoProducto = af.obtener(i).getCodigoProducto();
	        if (codigoProducto != codigoProductoAnterior) {
	            if (ventasProducto > 0) {
	            	imprimir("");
	            	imprimir("[--------------("+ cont +")--------------]");
	                imprimir("Código de producto: " + codigoProductoAnterior);
	                imprimir("Número de ventas efectuadas: " + ventasProducto);
	                imprimir("Unidades vendidas acumuladas: " + unidadesVendidasProducto);
	                imprimir("Importe total acumulado: " + importeTotalProducto); 
	                imprimir("[------------------------------]");
	                cont ++;
	            }
	          
	            ventasProducto = 1;
	            unidadesVendidasProducto = af.obtener(i).getUnidades();
	            importeTotalProducto = af.obtener(i).getUnidades() * af.obtener(i).getPrecio();
	        } else {
	        
	            ventasProducto++;
	            unidadesVendidasProducto += af.obtener(i).getUnidades();
	            importeTotalProducto += af.obtener(i).getUnidades() * af.obtener(i).getPrecio();
	        }
	        codigoProductoAnterior = codigoProducto;
	    }


	    if (ventasProducto > 0) {
	    	imprimir("");
	    	imprimir("[--------------("+ cont +")--------------]");
	        imprimir("Código de producto: " + codigoProductoAnterior);
	        imprimir("Número de ventas efectuadas: " + ventasProducto);
	        imprimir("Unidades vendidas acumuladas: " + unidadesVendidasProducto);
	        imprimir("Importe total acumulado: " + importeTotalProducto);
	        imprimir("[------------------------------]");
	        cont ++;
	    }
	}

	private void imprimirReporteGeneralPorVendedores() {
	    int codigoVendedorAnterior = -1;
	    int ventasVendedor = 0;
	    int unidadesVendidasVendedor = 0;
	    double importeTotalVendedor = 0.0;
	    int cont = 1;

	    for (int i = 0; i < af.tamanio(); i++) {
	        int codigoVendedor = af.obtener(i).getCodigoVendedor();
	        if (codigoVendedor != codigoVendedorAnterior) {
	            if (ventasVendedor > 0) {
	            	imprimir("");
	            	imprimir("[--------------("+ cont +")--------------]");
	                imprimir("Código de vendedor: " + codigoVendedorAnterior);
	                imprimir("Número de ventas efectuadas: " + ventasVendedor);
	                imprimir("Unidades vendidas acumuladas: " + unidadesVendidasVendedor);
	                imprimir("Importe total acumulado: " + importeTotalVendedor);  
	                imprimir("[------------------------------]");
	                cont ++;
	            }
	        
	            ventasVendedor = 1;
	            unidadesVendidasVendedor = af.obtener(i).getUnidades();
	            importeTotalVendedor = af.obtener(i).getUnidades() * af.obtener(i).getPrecio();
	        } else {
	            
	            ventasVendedor++;
	            unidadesVendidasVendedor += af.obtener(i).getUnidades();
	            importeTotalVendedor += af.obtener(i).getUnidades() * af.obtener(i).getPrecio();
	        }
	        codigoVendedorAnterior = codigoVendedor;
	    }


	    if (ventasVendedor > 0) {
	    	imprimir("");
	    	imprimir("[--------------("+ cont +")--------------]");
	        imprimir("Código de vendedor: " + codigoVendedorAnterior);
	        imprimir("Número de ventas efectuadas: " + ventasVendedor);
	        imprimir("Unidades vendidas acumuladas: " + unidadesVendidasVendedor);
	        imprimir("Importe total acumulado: " + importeTotalVendedor);
	        imprimir("[------------------------------]");
	        cont ++;
	    }
	}


    private void imprimirReportePorVendedor(int codigoVendedor) {
    	int cont = 1;
    	txtS.setText("Reporte de todas las ventas por el vendedor: " + av.buscar(leercodVendedor()).getNombres() +"\n");
        for (int i = 0; i < af.tamanio(); i++) {
            if (af.obtener(i).getCodigoVendedor() == codigoVendedor) {
            	imprimir("");
            	imprimir("[--------------("+ cont +")--------------]");
                imprimir("Código de factura : " + af.obtener(i).getCodigoFactura());
                imprimir("Código de producto: " + af.obtener(i).getCodigoProducto());
                imprimir("Unidades vendidas : " + af.obtener(i).getUnidades());
                imprimir("Precio unitario   : " + af.obtener(i).getPrecio());
                imprimir("[------------------------------]");
                cont ++;
            }
        }
    }

    private void imprimirReportePorProducto(int codigoProducto) {
    	int cont = 1;
    	txtS.setText("Reporte de todas las ventas por producto: " + ap.buscar(leercodProducto()).getDescripcion() + "\n");
        for (int i = 0; i < af.tamanio(); i++) {
            if (af.obtener(i).getCodigoProducto() == codigoProducto) {
            	imprimir("");
            	imprimir("[--------------("+ cont +")--------------]");
                imprimir("Código de factura : " + af.obtener(i).getCodigoFactura());
                imprimir("Código de vendedor: " + af.obtener(i).getCodigoVendedor());
                imprimir("Unidades vendidas : " + af.obtener(i).getUnidades());
                imprimir("Precio unitario   : " + af.obtener(i).getPrecio());
                imprimir("[------------------------------]");
                cont ++;
            }
        }
    }

    private void imprimirReporteDePrecios() {
        double sumaPrecios = 0.0;
        double precioMayor = Double.MIN_VALUE;
        double precioMenor = Double.MAX_VALUE;

        for (int i = 0; i < ap.tamanio(); i++) {
            double precio = ap.obtener(i).getPrecio();
            sumaPrecios += precio;
            precioMayor = Math.max(precioMayor, precio);
            precioMenor = Math.min(precioMenor, precio);
        }

        double precioPromedio = sumaPrecios / af.tamanio();

        imprimir("[------------------------------]");
        imprimir("Precio promedio: " + precioPromedio);
        imprimir("Precio mayor: " + precioMayor);
        imprimir("Precio menor: " + precioMenor);
        imprimir("[------------------------------]");
    }

    private void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
    
    private void actionPerformedBtnProcesar(ActionEvent e) {
    	switch (cboTipR.getSelectedIndex()) {
		case 0:
			txtS.setText("Reporte general por productos:" + "\n");
			imprimir("");
			imprimirReporteGeneralPorProductos();
			break;
		case 1:
			txtS.setText("Reporte general por Vendedores:" + "\n");
			imprimir("");
			imprimirReporteGeneralPorVendedores();
			break;
		case 2:
			imprimirReportePorVendedor(Integer.parseInt(txtVendedor.getText()));
			txtVendedor.setText("");
			break;
		case 3:
			imprimirReportePorProducto(Integer.parseInt(txtProducto.getText()));
			txtProducto.setText("");
			break;
		case 4:
			txtS.setText("Reporte de precios:" + "\n");
			imprimir("");
			imprimirReporteDePrecios();
			break;
		}
	}
    
    public int leercodVendedor() {
    	return Integer.parseInt(txtVendedor.getText().trim());
    }
    
    public int leercodProducto() {
    	return Integer.parseInt(txtProducto.getText().trim());
    }
}

