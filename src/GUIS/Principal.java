package GUIS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class Principal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnAyuda;
	private JButton btnSalir;
	private JButton btnMantenimiento;
	private JButton btnVentas;
	private JButton btnReportes;
	private JButton btnVendedores;
	private JButton btnClientes;
	private JButton btnProductos;
	private JButton btnVender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
			/**
			 * UIManager.setLookAndFeel(new FlatLightLaf());
			 * UIManager.setLookAndFeel(new FlatDarkLaf());
			 * UIManager.setLookAndFeel(new FlatIntelliJLaf());
			 * UIManager.setLookAndFeel(new FlatDarculaLaf());
			 * UIManager.setLookAndFeel(new FlatMacLightLaf());
			 * UIManager.setLookAndFeel(new FlatMacDarkLaf());
			 */
			
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JButton btnTiposReportes;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblBannerMante;
	private JLabel lblBannerVenta;
	private JLabel lblBannerReport;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/Icono.jpg"));
		setTitle("TiendaCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 763);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
        panel.setBounds(0, 0, 711, 193);
        contentPane.add(panel);
        panel.setLayout(null);
		
		btnMantenimiento = new JButton("Mantenimiento");
		btnMantenimiento.setForeground(Color.WHITE);
        btnMantenimiento.setBackground(new Color(0, 102, 153)); 
        btnMantenimiento.addActionListener(this);
        btnMantenimiento.setBorderPainted(false);
        btnMantenimiento.setFocusPainted(false);
		btnMantenimiento.setBounds(36, 0, 126, 193);
		btnMantenimiento.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnMantenimiento);
		estiloIcono(btnMantenimiento, "Imagenes/ajustes.png", 50, 50);
		
		btnVentas = new JButton("Ventas");
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setBackground(new Color(0, 102, 153)); 
		btnVentas.addActionListener(this);
		btnVentas.setBorderPainted(false);
		btnVentas.setFocusPainted(false);
		btnVentas.setBounds(164, 0, 131, 193);
		btnVentas.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnVentas);
		estiloIcono(btnVentas, "Imagenes/bolsa-de-la-compra.png", 50, 50);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setForeground(Color.WHITE);
		btnReportes.setBackground(new Color(0, 102, 153)); 
		btnReportes.addActionListener(this);
		btnReportes.setBorderPainted(false);
		btnReportes.setFocusPainted(false);
		btnReportes.setBounds(293, 0, 126, 193);
		btnReportes.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnReportes);
		estiloIcono(btnReportes, "Imagenes/comprobacion-de-lista.png", 50, 50);
		
		btnAyuda = new JButton("Ayuda");
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setBackground(new Color(0, 102, 153)); 
		btnAyuda.addActionListener(this);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setFocusPainted(false);
		btnAyuda.setBounds(423, 0, 126, 193);
		btnAyuda.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnAyuda);
		estiloIcono(btnAyuda, "Imagenes/usuarios.png", 50, 50);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(0, 102, 153));
		btnSalir.addActionListener(this);
		btnSalir.setBorderPainted(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setBounds(553, 0, 126, 193);
		btnSalir.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnSalir);
		estiloIcono(btnSalir, "Imagenes/puerta-abierta.png", 50, 50);
		
		panel2 = new JPanel();
	    panel2.setBackground(Color.DARK_GRAY);
	    panel2.setBounds(0, 193, 711, 531);
	    contentPane.add(panel2);
	    panel2.setLayout(null);
	    panel2.setVisible(false);
		
		btnVendedores = new JButton("Vendedores");
		btnVendedores.addActionListener(this);
		btnVendedores.setBounds(128, 75, 166, 149);
		btnVendedores.setBorderPainted(false);
		btnVendedores.setFocusPainted(false);
		estiloIcono(btnVendedores, "Imagenes/Vendedores.png", 35, 35);

		panel2.add(btnVendedores);
		
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(this);
		btnClientes.setBounds(425, 75, 166, 149);
		btnClientes.setBorderPainted(false);
		btnClientes.setFocusPainted(false);
		estiloIcono(btnClientes, "Imagenes/cliente.png", 35, 35);
	
		panel2.add(btnClientes);
		
		btnProductos = new JButton("Productos");
		btnProductos.addActionListener(this);
		btnProductos.setBounds(287, 308, 166, 149);
		btnProductos.setBorderPainted(false);
		btnProductos.setFocusPainted(false);
		estiloIcono(btnProductos, "Imagenes/productos.png", 35, 35);

		panel2.add(btnProductos);
		
	    btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds((panel2.getWidth() - 166) / 2, (panel2.getHeight() - 149) / 2, 166, 149);
		btnVender.setBorderPainted(false);
		btnVender.setFocusPainted(false);
		estiloIcono(btnVender, "Imagenes/vender.png", 35, 35);

		panel2.add(btnVender);
		
		btnTiposReportes = new JButton("Reportes");
		btnTiposReportes.addActionListener(this);
		btnTiposReportes.setBounds(272, 191, 166, 163);
		btnTiposReportes.setBorderPainted(false);
		btnTiposReportes.setFocusPainted(false);
		estiloIcono(btnTiposReportes, "Imagenes/Reporte.png", 35, 35);
		
		panel2.add(btnTiposReportes);
		
		lblBannerMante = new JLabel("New label");
		lblBannerMante.setIcon(new ImageIcon("Imagenes/bannerMante.png"));
		lblBannerMante.setBounds(0, 0, 711, 531);
		lblBannerMante.setVisible(false);
		panel2.add(lblBannerMante);
		
		lblBannerVenta = new JLabel("New label");
		lblBannerVenta.setIcon(new ImageIcon("Imagenes/bannerVenta.png"));
		lblBannerVenta.setBounds(0, 0, 711, 531);
		lblBannerVenta.setVisible(false);
		panel2.add(lblBannerVenta);
		
		lblBannerReport = new JLabel("New label");
		lblBannerReport.setIcon(new ImageIcon("Imagenes/bannerReport.png"));
		lblBannerReport.setBounds(0, 0, 711, 531);
		lblBannerReport.setVisible(false);
		panel2.add(lblBannerReport);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("Imagenes/Icono.png"));
		lblNewLabel_10.setBounds(645, 474, 66, 57);
		panel2.add(lblNewLabel_10);

		panel3 = new JPanel();
		panel3.setBackground(Color.DARK_GRAY);
		panel3.setBounds(0, 193, 711, 531);
		contentPane.add(panel3);
		panel3.setLayout(null);
		panel3.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Realizado Por:");
		lblNewLabel.setBounds(273, 72, 152, 30);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panel3.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Angelo Pool Llanos Querol");
		lblNewLabel_1.setBounds(226, 120, 319, 26);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		panel3.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("Imagenes/Mancha.png"));
		lblNewLabel_4.setBounds(10, -28, 654, 263);
		panel3.add(lblNewLabel_4);
		
		ImageIcon icon = new ImageIcon("Gifs/gato.gif");
		lblNewLabel_5 = new JLabel(icon);
		lblNewLabel_5.setBounds(198, 233, 347, 287);
		panel3.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("Imagenes/NocheEstrellada.jpg"));
		lblNewLabel_6.setBounds(0, 0, 711, 531);
		panel3.add(lblNewLabel_6);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("Imagenes/Fondo.png"));
		lblNewLabel_8.setBounds(0, 193, 711, 531);
		contentPane.add(lblNewLabel_8);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnVendedores) {
	        actionPerformedBtnVendedores(e);
	    }
	    if (e.getSource() == btnClientes) {
	        actionPerformedBtnClientes(e);
	    }
	    if (e.getSource() == btnProductos) {
	        actionPerformedBtnProductos(e);
	    }
	    if (e.getSource() == btnMantenimiento) {
	        actionPerformedBtnMantenimineto(e);
	    }
	    if (e.getSource() == btnVender) {
	        actionPerformedBtnVender(e);
	    }
	    if (e.getSource() == btnVentas) {
	        actionPerformedBtnVentas(e);
	    }
	    if (e.getSource() == btnReportes) {
	        actionPerformedBtnReportes(e);
	    }
	    if (e.getSource() == btnTiposReportes) {
	        actionPerformedBtnTiposReportes(e);
	    }
	    if (e.getSource() == btnAyuda) {
	        actionPerformedBtnAyuda(e);
	    }
	}

	private void actionPerformedBtnMantenimineto(ActionEvent e) {
		panel2.setVisible(true);
        btnVendedores.setVisible(true);
        btnClientes.setVisible(true);
        btnProductos.setVisible(true);
        btnVender.setVisible(false);
        btnTiposReportes.setVisible(false);
        panel3.setVisible(false);
        lblBannerMante.setVisible(true);
        lblBannerVenta.setVisible(false);
        lblBannerReport.setVisible(false);
 
        
        btnMantenimiento.setBackground(new Color(51, 153, 204));
        btnVentas.setBackground(new Color(0, 102, 153));
        btnReportes.setBackground(new Color(0, 102, 153));
        btnAyuda.setBackground(new Color(0, 102, 153));
        btnSalir.setBackground(new Color(0, 102, 153));
	}
	
	private void actionPerformedBtnVentas(ActionEvent e) {
		panel2.setVisible(true);
        btnVendedores.setVisible(false);
        btnClientes.setVisible(false);
        btnProductos.setVisible(false);
        btnVender.setVisible(true);
        btnTiposReportes.setVisible(false);
        panel3.setVisible(false);
        lblBannerMante.setVisible(false);
        lblBannerVenta.setVisible(true);
        lblBannerReport.setVisible(false);

  
        btnMantenimiento.setBackground(new Color(0, 102, 153));
        btnVentas.setBackground(new Color(51, 153, 204));
        btnReportes.setBackground(new Color(0, 102, 153));
        btnAyuda.setBackground(new Color(0, 102, 153));
        btnSalir.setBackground(new Color(0, 102, 153));
	}
	
	private void actionPerformedBtnReportes(ActionEvent e) {
		panel2.setVisible(true);
		btnVendedores.setVisible(false);
        btnClientes.setVisible(false);
        btnProductos.setVisible(false);
        btnVender.setVisible(false);
        btnTiposReportes.setVisible(true);
        panel3.setVisible(false);
        lblBannerMante.setVisible(false);
        lblBannerVenta.setVisible(false);
        lblBannerReport.setVisible(true);
        
        btnMantenimiento.setBackground(new Color(0, 102, 153));
        btnVentas.setBackground(new Color(0, 102, 153));
        btnReportes.setBackground(new Color(51, 153, 204));
        btnAyuda.setBackground(new Color(0, 102, 153));
        btnSalir.setBackground(new Color(0, 102, 153));
	}

	private void actionPerformedBtnAyuda(ActionEvent e) {
		panel2.setVisible(false);
		panel3.setVisible(true);
		
		btnMantenimiento.setBackground(new Color(0, 102, 153));
        btnVentas.setBackground(new Color(0, 102, 153));
        btnReportes.setBackground(new Color(0, 102, 153));
        btnAyuda.setBackground(new Color(51, 153, 204));
        btnSalir.setBackground(new Color(0, 102, 153));
	}
	
	private void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
		btnMantenimiento.setBackground(new Color(0, 102, 153));
        btnVentas.setBackground(new Color(0, 102, 153));
        btnReportes.setBackground(new Color(0, 102, 153));
        btnAyuda.setBackground(new Color(0, 102, 153));
        btnSalir.setBackground(new Color(51, 153, 204));
	}
	
	private void actionPerformedBtnVendedores(ActionEvent e) {
		JDVendedores jd = new JDVendedores();
		jd.setLocationRelativeTo(this);
		jd.setModal(true);
		jd.setVisible(true);
	}

	private void actionPerformedBtnClientes(ActionEvent e) {
		JDClientes jd = new JDClientes();
		jd.setLocationRelativeTo(this);
		jd.setModal(true);
		jd.setVisible(true);
	}

	private void actionPerformedBtnProductos(ActionEvent e) {
		JDProductos jd = new JDProductos();
		jd.setLocationRelativeTo(this);
		jd.setModal(true);
		jd.setVisible(true);
	}
	
	private void actionPerformedBtnVender(ActionEvent e) {
		JDVender jd = new JDVender();
		jd.setLocationRelativeTo(this);
		jd.setModal(true);
		jd.setVisible(true);
	}
	
    private void actionPerformedBtnTiposReportes(ActionEvent e) {
    	JDGenerarReportes jd = new JDGenerarReportes();
		jd.setLocationRelativeTo(this);
		jd.setModal(true);
		jd.setVisible(true);
	}

	
	

	//Metodos Complementarios
	private static Image escalarImagen(Image imagen, int i, int j) {
        return imagen.getScaledInstance(i, j, Image.SCALE_SMOOTH);
    }
	
	private static void estiloIcono(JButton boton, String rutaIcono, int i, int j) {
        ImageIcon icono = new ImageIcon(rutaIcono);
        Image escalarImagen = escalarImagen(icono.getImage(), i, j);
        boton.setIcon(new ImageIcon(escalarImagen));
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
