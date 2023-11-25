package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logica.Usuario;

public class CrearListas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tituloLista;

	/**
	 * Create the frame.
	 */
	public CrearListas(Usuario us) {
		setTitle("ADMINISTRATUM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 960, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(207, 210, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titulo = new JLabel("");
		titulo.setBounds(223, 10, 500, 128);
		ImageIcon nekuoarc = new ImageIcon("multimedia/imgs/Title.png");
		Image imagenIns = nekuoarc.getImage();
		Image newitarc = imagenIns.getScaledInstance(titulo.getWidth(), titulo.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon finalerc = new ImageIcon(newitarc);
		titulo.setIcon(finalerc);
		contentPane.add(titulo);

		JLabel error = new JLabel("");
		error.setOpaque(true);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setFont(null);
		Border borde = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(3, 3, 3, 3));
		error.setBorder(borde);
		error.setBounds(223, 488, 711, 40);
		contentPane.add(error);
		error.setVisible(false);

		JLabel saludo = new JLabel("Creemos tu lista de tareas");
		saludo.setForeground(new Color(255, 255, 255));
		saludo.setHorizontalAlignment(SwingConstants.CENTER);
		saludo.setBounds(152, 154, 642, 40);
		contentPane.add(saludo);

		tituloLista = new JTextField("Titulo De La Lista De Tareas");
		tituloLista.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLista.setBounds(180, 226, 586, 74);
		tituloLista.setBackground(new Color(207, 210, 220));
		Border borde1 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(3, 3, 3, 3));
		tituloLista.setBorder(borde1);
		contentPane.add(tituloLista);
		tituloLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tituloLista.getText().equals("Titulo De La Lista De Tareas"))
					tituloLista.setText("");
			}
		});
		tituloLista.setColumns(10);

		JButton agregarTareas = new JButton("Agregar tareas");
		agregarTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tituloLista.getText().equals(""))
					tituloLista.setText("Titulo De La Lista De Tareas");
				
				if(tituloLista.getText().equals("Titulo De La Lista De Tareas")) {
					error.setText("Ponle un nombre a tu lista de tareas");
					error.setVisible(true);
				}else {
					error.setVisible(false);
					JOptionPane.showMessageDialog(null, "Ingresa a creador de tareas");
				}
			}
		});
		agregarTareas.setBackground(new Color(207, 210, 220));
		agregarTareas.setBounds(283, 383, 372, 74);
		agregarTareas.setActionCommand("add");
		contentPane.add(agregarTareas);

		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Administrador ad = new Administrador(us);
				ad.setVisible(true);
			}
		});
		volver.setForeground(new Color(255, 255, 255));
		volver.setFont(null);
		volver.setBackground(new Color(255, 0, 0));
		volver.setBounds(58, 55, 122, 40);
		volver.setActionCommand("volver");
		contentPane.add(volver);

		try {
			// Ruta al archivo de la fuente externa
			String kartPath = "multimedia/fuentes/KartDS.ttf";
			// Carga el archivo de fuente en un flujo de entrada
			try (InputStream kartStream = new FileInputStream(new String(kartPath))) {
				// Crea la fuente desde el flujo de entrada
				Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);
				// Deriva una nueva fuente con el estilo deseado
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 32);

				error.setFont(kartFontBold);
				tituloLista.setFont(kartFontBold);
			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		try {
			// Ruta al archivo de la fuente externa
			String kartPath = "multimedia/fuentes/Mincra.ttf";
			// Carga el archivo de fuente en un flujo de entrada
			try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

				// Crea la fuente desde el flujo de entrada
				Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

				// Deriva una nueva fuente con el estilo deseado
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 20);

				saludo.setFont(kartFontBold);
				volver.setFont(kartFontBold);
				agregarTareas.setFont(kartFontBold);
			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 946, 563);
		ImageIcon fondoImg = new ImageIcon("multimedia/imgs/Fondo.gif");
		Image fondoImgIns = fondoImg.getImage();
		Image fondoNewImg = fondoImgIns.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_FAST);
		ImageIcon fondoFinalImage = new ImageIcon(fondoNewImg);
		fondo.setIcon(fondoFinalImage);
		fondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tituloLista.getText().equals(""))
					tituloLista.setText("Titulo De La Lista De Tareas");
			}
		});
		contentPane.add(fondo);

	}

}
