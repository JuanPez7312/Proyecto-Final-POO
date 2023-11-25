package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logica.Usuario;

public class Administrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Administrador(Usuario us) {
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

		JLabel saludo = new JLabel("Que deseas hacer hoy");
		saludo.setForeground(new Color(255, 255, 255));
		saludo.setHorizontalAlignment(SwingConstants.CENTER);
		saludo.setBounds(152, 168, 642, 40);
		contentPane.add(saludo);

		JButton vermascota = new JButton("Ver Mascota");
		vermascota.setBackground(new Color(207, 210, 220));
		vermascota.setBounds(132, 421, 275, 51);
		vermascota.setActionCommand("Ver");
		Border borde = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		vermascota.setBorder(borde);
		contentPane.add(vermascota);

		JButton cerrarse = new JButton("Cerrar Sesion");
		cerrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Ingreso in = new Ingreso();
				in.setVisible(true);
			}
		});
		cerrarse.setForeground(new Color(255, 255, 255));
		cerrarse.setBackground(new Color(255, 0, 0));
		cerrarse.setBounds(539, 421, 275, 51);

		cerrarse.setActionCommand("Cerrar");
		Border borde1 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		cerrarse.setBorder(borde1);
		contentPane.add(cerrarse);

		JButton crear = new JButton("Crear Lista");
		crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CrearListas cl = new CrearListas(us);
				cl.setVisible(true);
			}
		});
		crear.setFont(null);
		crear.setBackground(new Color(207, 210, 220));
		crear.setBounds(132, 277, 275, 51);
		crear.setActionCommand("CrearLista");
		Border borde2 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		crear.setBorder(borde2);
		contentPane.add(crear);

		JButton ver = new JButton("Ver Listas De Tareas");
		ver.setFont(null);
		ver.setBackground(new Color(207, 210, 220));
		ver.setBounds(539, 277, 275, 51);

		ver.setActionCommand("VerLista");
		Border borde11 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		ver.setBorder(borde11);
		contentPane.add(ver);

		try {
			// Ruta al archivo de la fuente externa
			String kartPath = "multimedia/fuentes/KartDS.ttf";
			// Carga el archivo de fuente en un flujo de entrada
			try (InputStream kartStream = new FileInputStream(new String(kartPath))) {
				// Crea la fuente desde el flujo de entrada
				Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);
				// Deriva una nueva fuente con el estilo deseado
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 32);

				saludo.setFont(kartFontBold);
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

				vermascota.setFont(kartFontBold);
				cerrarse.setFont(kartFontBold);
				ver.setFont(kartFontBold);
				crear.setFont(kartFontBold);
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
		contentPane.add(fondo);

	}
}
