package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textClave;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Ingreso");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(207, 210, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("");
		titulo.setBounds(243, 10, 500, 128);
		ImageIcon nekuoarc = new ImageIcon("src/multimedia/imgs/Title.png");
		Image imagenIns = nekuoarc.getImage();
		Image newitarc = imagenIns.getScaledInstance(titulo.getWidth(), titulo.getHeight(),
				Image.SCALE_DEFAULT);
		ImageIcon finalerc = new ImageIcon(newitarc);
		titulo.setIcon(finalerc);
		contentPane.add(titulo);

		JLabel error = new JLabel("");
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setBounds(740, 473, 236, 80);
		contentPane.add(error);
		
		JLabel saludo = new JLabel("Bienvenido, Inicia sesion para empezar");
		saludo.setOpaque(true);
		saludo.setHorizontalAlignment(SwingConstants.CENTER);
		saludo.setBackground(new Color(207, 210, 220));
		Border borde1 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		saludo.setBorder(borde1);
		saludo.setBounds(172, 154, 642, 40);
		contentPane.add(saludo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setOpaque(true);
		lblUsuario.setBackground(new Color(207, 210, 220));
		Border borde2 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lblUsuario.setBorder(borde2);
		lblUsuario.setBounds(203, 226, 188, 45);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setOpaque(true);
		lblClave.setBackground(new Color(207, 210, 220));
		Border borde3 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lblClave.setBorder(borde3);
		lblClave.setBounds(203, 306, 188, 45);
		contentPane.add(lblClave);
		
		textUsuario = new JTextField();
		textUsuario.setOpaque(true);
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setBackground(new Color(207, 210, 220));
		Border borde4 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textUsuario.setBorder(borde4);
		textUsuario.setBounds(594, 226, 188, 45);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textClave = new JTextField();
		textClave.setOpaque(true);
		textClave.setHorizontalAlignment(SwingConstants.CENTER);
		textClave.setBackground(new Color(207, 210, 220));
		Border borde5 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textClave.setBorder(borde5);
		textClave.setBounds(594, 306, 188, 45);
		contentPane.add(textClave);
		textClave.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(207, 210, 220));
		btnIngresar.setBounds(578, 421, 154, 51);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrace = new JButton("Registrarse");
		btnRegistrace.setBackground(new Color(207, 210, 220));
		btnRegistrace.setBounds(212, 421, 154, 51);
		contentPane.add(btnRegistrace);
		
		//Para poder usar las fuentes externas
		
		try {
			// Ruta al archivo de la fuente externa
			String kartPath = "src/multimedia/fuentes/KartDS.ttf";
			// Carga el archivo de fuente en un flujo de entrada
			try (InputStream kartStream = new FileInputStream(new String(kartPath))) {
				
				// Crea la fuente desde el flujo de entrada
				Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);
				// Deriva una nueva fuente con el estilo deseado
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 32);
				
				// Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
				error.setFont(kartFontBold);
				lblClave.setFont(kartFontBold);
				lblUsuario.setFont(kartFontBold);
				
			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		
		try {
			// Ruta al archivo de la fuente externa
			String kartPath = "src/multimedia/fuentes/Mincra.ttf";
			// Carga el archivo de fuente en un flujo de entrada
			try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

				// Crea la fuente desde el flujo de entrada
				Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

				// Deriva una nueva fuente con el estilo deseado
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 24);

				// Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
				saludo.setFont(kartFontBold);
				textUsuario.setFont(kartFontBold);
				textClave.setFont(kartFontBold);
				btnRegistrace.setFont(kartFontBold);
				btnIngresar.setFont(kartFontBold);

			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		// FONDO
		JLabel Fondolbl = new JLabel("");
		Fondolbl.setBounds(0, 0, 984, 563);
		ImageIcon fondoImg = new ImageIcon("src/multimedia/imgs/Fondo.gif");
		Image fondoImgIns = fondoImg.getImage();
		Image fondoNewImg = fondoImgIns.getScaledInstance(Fondolbl.getWidth(), Fondolbl.getHeight(), Image.SCALE_FAST);
		ImageIcon fondoFinalImage = new ImageIcon(fondoNewImg);
		Fondolbl.setIcon(fondoFinalImage);
		contentPane.add(Fondolbl);

	}
}
