package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logica.Mascota;

@SuppressWarnings("serial")
public class Eleccion extends Ingreso {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nombreIngreso;

	/**
	 * Create the frame.
	 */
	public Eleccion() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Administratum");
		Image icono = Toolkit.getDefaultToolkit().getImage("src/multimedia/imgs/LogoAdmin.png");
		setIconImage(icono);
		setBounds(100, 40, 1099, 695);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TITULO
		JLabel Eligelbl = new JLabel("ELIGE UNA CRIATURA");
		Eligelbl.setOpaque(true);
		Eligelbl.setBackground(new Color(207, 210, 220));
		Border bordeElige = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 10), // Borde
																												// un
																												// color
																												// y el
																												// grosor
				BorderFactory.createEmptyBorder(5, 5, 5, 5) // Luego miro como funciona esto
		);
		Eligelbl.setBorder(bordeElige);
		Eligelbl.setHorizontalAlignment(SwingConstants.CENTER);
		Eligelbl.setBounds(161, 0, 762, 79);
		contentPane.add(Eligelbl);

		try {// Esto me permite usar fuentes personalizadas que bien gracias dios
			String kartPath = "src/multimedia/fuentes/KartDS.ttf";
			try (InputStream kartStream = new FileInputStream(new File(kartPath))) {
				Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);
				Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 50);
				Eligelbl.setFont(kartFontBold);

			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		// BOTONES movimiento pestañas
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setBounds(19, 24, 132, 30);
		contentPane.add(btnVolver);

		// ROUNDBOTONES
		JRadioButton rdbtnSlim = new JRadioButton("Slim");
		rdbtnSlim.setActionCommand("0");
		buttonGroup.add(rdbtnSlim);
		rdbtnSlim.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSlim.setBounds(189, 250, 117, 42);
		contentPane.add(rdbtnSlim);

		JRadioButton rdbtnTooki = new JRadioButton("Tooki");
		rdbtnTooki.setActionCommand("1");
		buttonGroup.add(rdbtnTooki);
		rdbtnTooki.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTooki.setBounds(481, 250, 117, 42);
		contentPane.add(rdbtnTooki);

		JRadioButton rdbtnPyaso = new JRadioButton("Payasito");
		rdbtnPyaso.setActionCommand("2");
		buttonGroup.add(rdbtnPyaso);
		rdbtnPyaso.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPyaso.setBounds(779, 250, 117, 42);
		contentPane.add(rdbtnPyaso);

		JRadioButton rdbtnTopez = new JRadioButton("Topez");
		rdbtnTopez.setActionCommand("3");
		buttonGroup.add(rdbtnTopez);
		rdbtnTopez.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTopez.setBounds(294, 454, 117, 42);
		contentPane.add(rdbtnTopez);

		JRadioButton rdbtnPolpo = new JRadioButton("Polpo");
		rdbtnPolpo.setActionCommand("4");
		buttonGroup.add(rdbtnPolpo);
		rdbtnPolpo.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPolpo.setBounds(685, 454, 117, 42);
		contentPane.add(rdbtnPolpo);

		// ERRORMENSAJE
		JLabel error = new JLabel("");
		error.setOpaque(true);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setFont(null);
		Border borde = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		error.setBorder(borde);
		error.setBackground(new Color(207, 210, 220));
		error.setBounds(642, 603, 417, 42);
		contentPane.add(error);
		error.setVisible(false);

		nombreIngreso = new JTextField();
		nombreIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		nombreIngreso.setBounds(375, 518, 474, 57);
		contentPane.add(nombreIngreso);
		nombreIngreso.setColumns(10);

		//Boton para finalizar la eleccion
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el JRadioButton seleccionado del ButtonGroup
				ButtonModel selectedModel = buttonGroup.getSelection();
				String mascotas[] = { "Slim", "Tooki", "Payasito", "Topez", "Polpo" }; //creamos una lista para el id

				// En caso de que no halla ninguna seleccion
				if (selectedModel == null) {
					error.setText("No escogiste ninguna mascota");
					error.setVisible(true);
				} else {
					error.setVisible(false);
					Mascota mas = new Mascota(); //creamos la mascota
					String selectedText = selectedModel.getActionCommand();
					us.setId("0");//TEMPORAL
					mas.setNivel(0);//como es recien ingresado el nivel de la mascota es 0
					mas.setId(mascotas[Integer.parseInt(selectedText)] + "-" + us.getId()); //establecemos el id como tipoMascota-idUsuario
					if (nombreIngreso.getText().equals("")) { //si el JText del nombre esta vacio
						error.setText("Ponle un nombre a tu " + mascotas[Integer.parseInt(selectedText)]); //mensaje de error
						error.setVisible(true);
					} else {
						//establecemos nombre
						mas.setNombre(nombreIngreso.getText());
						us.setMascota(mas);
						
						//aca ira la parte para continuar a la creacion de listas
					}
					

				}

			}
		});
		btnContinuar.setBounds(889, 531, 150, 30);
		contentPane.add(btnContinuar);

		// INGRESARNOMBRE yatusae
		JLabel nombrelbl = new JLabel("Ingrese el nombre de su mascota :");
		nombrelbl.setOpaque(true);
		nombrelbl.setHorizontalAlignment(SwingConstants.CENTER);
		nombrelbl.setBackground(new Color(207, 210, 220));
		Border bordeNombre = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		nombrelbl.setBorder(bordeNombre);
		nombrelbl.setBounds(10, 518, 355, 57);
		contentPane.add(nombrelbl);

		try {// Esto me permite usar fuentes personalizadas que bien gracias dios
			String mincraPath = "src/multimedia/fuentes/Mincra.ttf";
			try (InputStream mincraStream = new FileInputStream(new File(mincraPath))) {

				Font mincraFont = Font.createFont(Font.TRUETYPE_FONT, mincraStream);
				Font mincraFontBold = mincraFont.deriveFont(Font.PLAIN, 16);

				btnVolver.setFont(mincraFontBold);
				btnContinuar.setFont(mincraFontBold);
				rdbtnSlim.setFont(mincraFontBold);
				rdbtnTooki.setFont(mincraFontBold);
				rdbtnPyaso.setFont(mincraFontBold);
				rdbtnTopez.setFont(mincraFontBold);
				rdbtnPolpo.setFont(mincraFontBold);
				nombrelbl.setFont(mincraFontBold);
				nombreIngreso.setFont(mincraFontBold);
				error.setFont(mincraFontBold);

			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		// CRIATURAS eleccion iconos
		JLabel Slimlbl = new JLabel("");
		Slimlbl.setBounds(137, -21, 240, 240);
		ImageIcon slimImg = new ImageIcon("src/multimedia/imgs/Eslaim.png");
		Image slimImgIns = slimImg.getImage();
		Image slimNewImg = slimImgIns.getScaledInstance(Slimlbl.getWidth(), Slimlbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon slimFinalImage = new ImageIcon(slimNewImg);
		Slimlbl.setIcon(slimFinalImage);
		contentPane.add(Slimlbl);

		JLabel Tookilbl = new JLabel("");
		Tookilbl.setBounds(404, -21, 240, 240);
		ImageIcon tookiImg = new ImageIcon("src/multimedia/imgs/Tooki.png");
		Image tookiImgIns = tookiImg.getImage();
		Image tookiNewImg = tookiImgIns.getScaledInstance(Tookilbl.getWidth(), Tookilbl.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon tookiFinalImage = new ImageIcon(tookiNewImg);
		Tookilbl.setIcon(tookiFinalImage);
		contentPane.add(Tookilbl);

		JLabel Payasolbl = new JLabel("");
		Payasolbl.setBounds(723, -21, 240, 240);
		ImageIcon pyasoImg = new ImageIcon("src/multimedia/imgs/Payasito.png");
		Image pyasoImgIns = pyasoImg.getImage();
		Image pyasoNewImg = pyasoImgIns.getScaledInstance(Payasolbl.getWidth(), Payasolbl.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon pyasoFinalImage = new ImageIcon(pyasoNewImg);
		Payasolbl.setIcon(pyasoFinalImage);
		contentPane.add(Payasolbl);

		JLabel Topezlbl = new JLabel("");
		Topezlbl.setBounds(235, 195, 240, 240);
		ImageIcon topezImg = new ImageIcon("src/multimedia/imgs/Topez.png");
		Image topezImgIns = topezImg.getImage();
		Image topezNewImg = topezImgIns.getScaledInstance(Topezlbl.getWidth(), Topezlbl.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon topezFinalImage = new ImageIcon(topezNewImg);
		Topezlbl.setIcon(topezFinalImage);
		contentPane.add(Topezlbl);

		JLabel Polpolbl = new JLabel("");
		Polpolbl.setBounds(634, 195, 240, 240);
		ImageIcon polpoImg = new ImageIcon("src/multimedia/imgs/Polpo.png");
		Image polpoImgIns = polpoImg.getImage();
		Image polpoNewImg = polpoImgIns.getScaledInstance(Polpolbl.getWidth(), Polpolbl.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon polpoFinalImage = new ImageIcon(polpoNewImg);
		Polpolbl.setIcon(polpoFinalImage);
		contentPane.add(Polpolbl);

		// DECORADO cosas la vrd nose no son importantes
		JLabel decora1lbl = new JLabel("");
		decora1lbl.setOpaque(true);
		decora1lbl.setBackground(new Color(207, 210, 220));

		Border bordeDecora1 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 10),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		decora1lbl.setBorder(bordeDecora1);

		decora1lbl.setBounds(116, 106, 849, 126);
		contentPane.add(decora1lbl);

		JLabel decora2lbl = new JLabel("");
		decora2lbl.setOpaque(true);
		decora2lbl.setBackground(new Color(207, 210, 220));
		Border bordeDecora2 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 10),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		decora2lbl.setBorder(bordeDecora2);
		decora2lbl.setBounds(217, 321, 681, 126);
		contentPane.add(decora2lbl);

		// FONDO
		JLabel Fondolbl = new JLabel("");
		Fondolbl.setBounds(-10, -95, 1093, 751);
		ImageIcon fondoImg = new ImageIcon("src/multimedia/imgs/Fondo.gif");
		Image fondoImgIns = fondoImg.getImage();
		Image fondoNewImg = fondoImgIns.getScaledInstance(Fondolbl.getWidth(), Fondolbl.getHeight(), Image.SCALE_FAST);
		ImageIcon fondoFinalImage = new ImageIcon(fondoNewImg);
		Fondolbl.setIcon(fondoFinalImage);
		contentPane.add(Fondolbl);

	}
}
