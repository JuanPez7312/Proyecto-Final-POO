package gui;

import java.awt.Color;
import java.awt.EventQueue;
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


public class Eleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField NombreIngreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleccion frame = new Eleccion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public Eleccion() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Administratum");
        Image icono = Toolkit.getDefaultToolkit().getImage("src/imgs/LogoAdmin.png");
        setIconImage(icono);
		setBounds(100, 40, 1099, 654);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);		
        
	//TITULO
		JLabel Eligelbl = new JLabel("ELIGE UNA CRIATURA");
		Eligelbl.setOpaque(true);
		Eligelbl.setBackground(new Color(207, 210, 220));
		Border bordeElige = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 10), // Borde un color y el grosor
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Luego miro como funciona esto
        );
		Eligelbl.setBorder(bordeElige);
		Eligelbl.setHorizontalAlignment(SwingConstants.CENTER);
		Eligelbl.setBounds(161, 0, 762, 79);
		contentPane.add(Eligelbl);
		
		try {//Esto me permite usar fuentes personalizadas que bien gracias dios
		    String kartPath = "src/fuentes/KartDS.ttf";
		    try (InputStream kartStream = new FileInputStream(new File(kartPath))) {
		        Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);
		        Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 50);
		        Eligelbl.setFont(kartFontBold);
	      
		    }
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}
		
	//BOTONES movimiento pestañas
		JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnVolver.setBounds(1, 36, 150, 30);
        contentPane.add(btnVolver);
        
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnContinuar.setBounds(889, 531, 150, 30);
        contentPane.add(btnContinuar);
        
     //ROUNDBOTONES	
  		JRadioButton rdbtnSlim = new JRadioButton("Slim");
  		buttonGroup.add(rdbtnSlim);
  		rdbtnSlim.setHorizontalAlignment(SwingConstants.CENTER);
  		rdbtnSlim.setBounds(189, 250, 117, 42);
  		contentPane.add(rdbtnSlim);
  		
  		JRadioButton rdbtnTooki = new JRadioButton("Tooki");
  		buttonGroup.add(rdbtnTooki);
  		rdbtnTooki.setHorizontalAlignment(SwingConstants.CENTER);
  		rdbtnTooki.setBounds(481, 250, 117, 42);
  		contentPane.add(rdbtnTooki);
  		
  		JRadioButton rdbtnPyaso = new JRadioButton("Payasito");
  		buttonGroup.add(rdbtnPyaso);
  		rdbtnPyaso.setHorizontalAlignment(SwingConstants.CENTER);
  		rdbtnPyaso.setBounds(779, 250, 117, 42);
  		contentPane.add(rdbtnPyaso);
  		
  		JRadioButton rdbtnTopez = new JRadioButton("Topez");
  		buttonGroup.add(rdbtnTopez);
  		rdbtnTopez.setHorizontalAlignment(SwingConstants.CENTER);
  		rdbtnTopez.setBounds(294, 454, 117, 42);
  		contentPane.add(rdbtnTopez);
  		
  		JRadioButton rdbtnPolpo = new JRadioButton("Polpo");
  		buttonGroup.add(rdbtnPolpo);
  		rdbtnPolpo.setHorizontalAlignment(SwingConstants.CENTER);
  		rdbtnPolpo.setBounds(685, 454, 117, 42);
  		contentPane.add(rdbtnPolpo);
  		
  	//INGRESARNOMBRE yatusae
  		JLabel Nombrelbl = new JLabel("Ingrese el nombre de su mascota :");
  		Nombrelbl.setOpaque(true);
  		Nombrelbl.setHorizontalAlignment(SwingConstants.CENTER);
  		Nombrelbl.setBackground(new Color(207, 210, 220));
  		Border bordeNombre = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 5), 
                BorderFactory.createEmptyBorder(5, 5, 5, 5) 
        );
  		Nombrelbl.setBorder(bordeNombre);
  		Nombrelbl.setBounds(10, 518, 355, 57);
  		contentPane.add(Nombrelbl);
  		
  		NombreIngreso = new JTextField();
  		NombreIngreso.setHorizontalAlignment(SwingConstants.CENTER);
  		NombreIngreso.setBounds(375, 518, 474, 57);
  		contentPane.add(NombreIngreso);
  		NombreIngreso.setColumns(10);
  		
  	//ERRORMENSAJE
  		JLabel Errorlbl = new JLabel("Hey soy un mensaje de error >:C");
  		Errorlbl.setOpaque(true);
  		Errorlbl.setHorizontalAlignment(SwingConstants.CENTER);
  		Errorlbl.setFont(null);
  		Errorlbl.setBackground(new Color(207, 210, 220));
  		Errorlbl.setBounds(325, 798, 431, 42);
  		contentPane.add(Errorlbl);
        
        try {//Esto me permite usar fuentes personalizadas que bien gracias dios
		    String mincraPath = "src/fuentes/Mincra.ttf";
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
		        
		        Nombrelbl.setFont(mincraFontBold);
		        NombreIngreso.setFont(mincraFontBold);

		        Errorlbl.setFont(mincraFontBold);

		    }
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}
        
    //CRIATURAS eleccion iconos
        JLabel Slimlbl = new JLabel("");
        Slimlbl.setBounds(137, -21, 240, 240);
        ImageIcon slimImg =new ImageIcon ("src/imgs/Eslaim.png");
		Image slimImgIns= slimImg.getImage();
		Image slimNewImg=slimImgIns.getScaledInstance(Slimlbl.getWidth(), Slimlbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon slimFinalImage=new ImageIcon(slimNewImg);
		Slimlbl.setIcon(slimFinalImage);
        contentPane.add(Slimlbl);
        
        JLabel Tookilbl = new JLabel("");
        Tookilbl.setBounds(404, -21, 240, 240);
        ImageIcon tookiImg =new ImageIcon ("src/imgs/Tooki.png");
		Image tookiImgIns= tookiImg.getImage();
		Image tookiNewImg=tookiImgIns.getScaledInstance(Tookilbl.getWidth(), Tookilbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon tookiFinalImage=new ImageIcon(tookiNewImg);
		Tookilbl.setIcon(tookiFinalImage);
        contentPane.add(Tookilbl);
        
        JLabel Payasolbl = new JLabel("");
        Payasolbl.setBounds(723, -21, 240, 240);
        ImageIcon pyasoImg =new ImageIcon ("src/imgs/Payasito.png");
		Image pyasoImgIns= pyasoImg.getImage();
		Image pyasoNewImg=pyasoImgIns.getScaledInstance(Payasolbl.getWidth(), Payasolbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon pyasoFinalImage=new ImageIcon(pyasoNewImg);
		Payasolbl.setIcon(pyasoFinalImage);
        contentPane.add(Payasolbl);
        
        JLabel Topezlbl = new JLabel("");
        Topezlbl.setBounds(235, 195, 240, 240);
        ImageIcon topezImg =new ImageIcon ("src/imgs/Topez.png");
		Image topezImgIns= topezImg.getImage();
		Image topezNewImg=topezImgIns.getScaledInstance(Topezlbl.getWidth(), Topezlbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon topezFinalImage=new ImageIcon(topezNewImg);
		Topezlbl.setIcon(topezFinalImage);
        contentPane.add(Topezlbl);
        
        JLabel Polpolbl = new JLabel("");
        Polpolbl.setBounds(634, 195, 240, 240);
        ImageIcon polpoImg =new ImageIcon ("src/imgs/Polpo.png");
		Image polpoImgIns= polpoImg.getImage();
		Image polpoNewImg=polpoImgIns.getScaledInstance(Polpolbl.getWidth(), Polpolbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon polpoFinalImage=new ImageIcon(polpoNewImg);
		Polpolbl.setIcon(polpoFinalImage);
        contentPane.add(Polpolbl);
		
    //DECORADO cosas la vrd nose no son importantes
        JLabel decora1lbl = new JLabel("");
  		decora1lbl.setOpaque(true);
  		decora1lbl.setBackground(new Color(207, 210, 220));
  		
  		Border bordeDecora1 = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 10), 
                BorderFactory.createEmptyBorder(5, 5, 5, 5) 
        );
  		decora1lbl.setBorder(bordeDecora1);
  		
  		decora1lbl.setBounds(116, 106, 849, 126);
  		contentPane.add(decora1lbl);
  		
  		JLabel decora2lbl = new JLabel("");
  		decora2lbl.setOpaque(true);
  		decora2lbl.setBackground(new Color(207, 210, 220));
  		Border bordeDecora2 = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 10), 
                BorderFactory.createEmptyBorder(5, 5, 5, 5) 
        );
  		decora2lbl.setBorder(bordeDecora2);
  		decora2lbl.setBounds(217, 321, 681, 126);
  		contentPane.add(decora2lbl);
        
  	
  	  
	//FONDO
  		JLabel Fondolbl = new JLabel("");
  		Fondolbl.setBounds(-10, -95, 1083, 710);
  		ImageIcon fondoImg =new ImageIcon ("src/imgs/Fondo.gif");
  		Image fondoImgIns= fondoImg.getImage();
  		Image fondoNewImg=fondoImgIns.getScaledInstance(Fondolbl.getWidth(), Fondolbl.getHeight(), Image.SCALE_FAST);
  		ImageIcon fondoFinalImage=new ImageIcon(fondoNewImg);
  		Fondolbl.setIcon(fondoFinalImage);
  		contentPane.add(Fondolbl);
  		
	}
}
