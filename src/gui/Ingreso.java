package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logica.Revisar;
import logica.Usuario;

@SuppressWarnings("serial")
public class Ingreso extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField clave;

	/**
	 * Create the frame.
	 */
	public Ingreso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/imgs/LogoAdmin.png"));
		setTitle("ADMINISTRATUM");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(-5, 0, 1000, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(207, 210, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Border borde = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JLabel titulo = new JLabel("");
		titulo.setBounds(243, 10, 500, 128);
		ImageIcon nekuoarc = new ImageIcon("multimedia/imgs/Title.png");
		Image imagenIns = nekuoarc.getImage();
		Image newitarc = imagenIns.getScaledInstance(titulo.getWidth(), titulo.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon finalerc = new ImageIcon(newitarc);
		titulo.setIcon(finalerc);
		contentPane.add(titulo);

		JLabel error = new JLabel("");
		error.setOpaque(true);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setBackground(new Color(207, 210, 220));
		error.setBorder(borde);
		error.setBounds(310, 494, 664, 45);
		contentPane.add(error);
		error.setVisible(false);

		JLabel saludo = new JLabel("Bienvenido, inicia sesion para empezar");
		saludo.setOpaque(true);
		saludo.setHorizontalAlignment(SwingConstants.CENTER);
		saludo.setBackground(new Color(207, 210, 220));
		saludo.setBorder(borde);
		saludo.setBounds(172, 154, 642, 40);
		contentPane.add(saludo);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setOpaque(true);
		lblClave.setHorizontalAlignment(SwingConstants.CENTER);
		lblClave.setBackground(new Color(207, 210, 220));
		lblClave.setBorder(borde);
		lblClave.setBounds(216, 309, 128, 45);
		contentPane.add(lblClave);

		clave = new JPasswordField();
		clave.setOpaque(true);
		clave.setHorizontalAlignment(SwingConstants.CENTER);
		clave.setBackground(new Color(207, 210, 220));
		clave.setBounds(383, 309, 188, 45);
		clave.setBorder(borde);
		contentPane.add(clave);

		textUsuario = new JTextField("Usuario");
		textUsuario.setOpaque(true);
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setBackground(new Color(207, 210, 220));
		textUsuario.setBorder(borde);
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textUsuario.getText().equals("Usuario"))
					textUsuario.setText("");
			}
		});
		textUsuario.setBounds(383, 238, 188, 45);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textUsuario.getText().equals(""))
					textUsuario.setText("Usuario");

				if (textUsuario.getText().equals("Usuario") && String.valueOf(clave.getPassword()).equals("")) {
					error.setText("Falta el usuario y la clave");
					error.setVisible(true);
				} else if (textUsuario.getText().equals("Usuario")) {
					error.setText("Falta el usuario");
					error.setVisible(true);
				} else if (String.valueOf(clave.getPassword()).equals("")) {
					error.setText("Falta la clave");
					error.setVisible(true);
				}else if (!Revisar.revName(textUsuario.getText())) {
					error.setText("No existe ese Usuario");
					error.setVisible(true);
				} else {
					error.setVisible(false);
					Usuario us = Revisar.ingre(textUsuario.getText(), String.valueOf(clave.getPassword()));
					// buscamos el username en la base de datos
					if (us != null) {
						Administrador ad = new Administrador(us);
						ad.setVisible(true);
						setVisible(false);
					} else {
						error.setText("Clave incorrecta");
						error.setVisible(true);
					}

				}
			}
		});
		btnIngresar.setBackground(new Color(0, 0, 0));
		btnIngresar.setBounds(578, 421, 241, 51);
		contentPane.add(btnIngresar);

		JButton btnRegistrar = new JButton("Finalizar");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textUsuario.getText().equals(""))
					textUsuario.setText("Usuario");

				if (textUsuario.getText().equals("Usuario") && String.valueOf(clave.getPassword()).equals("")) {
					error.setText("Falta el usuario y la clave");
					error.setVisible(true);
				} else if (textUsuario.getText().equals("Usuario")) {
					error.setText("Falta el usuario");
					error.setVisible(true);
				} else if (String.valueOf(clave.getPassword()).equals("")) {
					error.setText("Falta la clave");
					error.setVisible(true);
				} else if (clave.getPassword().length < 4) {
					error.setText("La clave debe tener minimo 4 caracteres");
					error.setVisible(true);
					// Revisamos que el nombre de usuario no este creado
				} else if (Revisar.revName(textUsuario.getText())) {
					error.setText("El nombre de usuario ya esta en uso");
					error.setVisible(true);
				} else {
					error.setVisible(false);
					Usuario us = new Usuario(textUsuario.getText(), String.valueOf(clave.getPassword()));
					EleccionMascota el = new EleccionMascota(us);
					el.setVisible(true);
					setVisible(false);
				}

			}
		});
		btnRegistrar.setBackground(new Color(0, 0, 0));
		btnRegistrar.setBounds(360, 406, 241, 51);
		contentPane.add(btnRegistrar);
		btnRegistrar.setVisible(false);

		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = { "Sí", "No" };// Opciones
				// Muestra la ventana de confirmacion y guarda la opcion en un entero
				int confirmation = JOptionPane.showOptionDialog(contentPane, "¿Estás seguro que quieres salir?",
						"Confirmación de salida", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						options, options[0]);
				// si se retorno cero de lo anterio se cierra el programa
				if (confirmation == 0) {
					System.exit(0);
				}
			}
		});
		salir.setForeground(new Color(255, 255, 255));
		salir.setFont(null);
		salir.setBackground(new Color(255, 0, 0));
		salir.setBounds(60, 53, 128, 33);
		contentPane.add(salir);

		JButton volver = new JButton("Volver");

		JButton btnRegistrace = new JButton("Registrarce");
		btnRegistrace.setForeground(new Color(255, 255, 255));
		btnRegistrace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				error.setVisible(false);
				btnRegistrace.setVisible(false);
				btnIngresar.setVisible(false);
				saludo.setText("Vamos a registrarte");
				btnRegistrar.setVisible(true);
				salir.setVisible(false);
				volver.setVisible(true);
			}
		});
		btnRegistrace.setBackground(new Color(0, 0, 0));
		btnRegistrace.setBounds(125, 421, 241, 51);
		contentPane.add(btnRegistrace);

		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrace.setVisible(true);
				btnIngresar.setVisible(true);
				saludo.setText("Bienvenido, inicia sesion para empezar");
				btnRegistrar.setVisible(false);
				salir.setVisible(true);
				volver.setVisible(false);
			}
		});
		volver.setForeground(new Color(255, 255, 255));
		volver.setFont(null);
		volver.setBackground(new Color(255, 0, 0));
		volver.setBounds(40, 53, 163, 40);
		contentPane.add(volver);
		volver.setVisible(false);

		// Para poder usar las fuentes externas

		try {
			// Ruta al archivo de la fuente externa
			String kartPath = "multimedia/fuentes/KartDS.ttf";
			// Carga el archivo de fuente en un flujo de entrada
			try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

				// Crea la fuente desde el flujo de entrada
				Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);
				// Deriva una nueva fuente con el estilo deseado
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 32);

				// Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
				error.setFont(kartFontBold);
				textUsuario.setFont(kartFontBold);
				lblClave.setFont(kartFontBold);

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
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 24);

				// Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
				saludo.setFont(kartFontBold);
				btnRegistrace.setFont(kartFontBold);
				btnIngresar.setFont(kartFontBold);
				salir.setFont(kartFontBold);
				btnRegistrar.setFont(kartFontBold);
				volver.setFont(kartFontBold);

			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		// FONDO
		JLabel Fondolbl = new JLabel("");
		Fondolbl.setHorizontalAlignment(SwingConstants.CENTER);
		Fondolbl.setBounds(0, 0, 984, 563);
		ImageIcon fondoImg = new ImageIcon("multimedia/imgs/Fondo.gif");
		Image fondoImgIns = fondoImg.getImage();
		Image fondoNewImg = fondoImgIns.getScaledInstance(Fondolbl.getWidth(), Fondolbl.getHeight(), Image.SCALE_FAST);
		ImageIcon fondoFinalImage = new ImageIcon(fondoNewImg);
		Fondolbl.setIcon(fondoFinalImage);
		Fondolbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textUsuario.getText().equals(""))
					textUsuario.setText("Usuario");
			}
		});
		contentPane.add(Fondolbl);

	}
}
