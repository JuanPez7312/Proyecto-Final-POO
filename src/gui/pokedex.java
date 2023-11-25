package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class pokedex extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int d;
	private int r;

	public pokedex(int c, int q) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1546, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(207,210,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 358, 355);
		ImageIcon nekuoarc = new ImageIcon("src/img/Eslaim.png");
		if (c==1) {
			if (q<30) {
				nekuoarc = new ImageIcon("src/img/Eslaim.png");
			} else if (q<100) {
				nekuoarc = new ImageIcon("src/img/MedEslaim.png");
			} else if (q==100) {
				nekuoarc = new ImageIcon("src/img/BigEslaim.png");
			}
		} else if (c==2) {
			if (q<30) {
				nekuoarc = new ImageIcon("src/img/Tooki.png");
			} else if (q<100) {
				nekuoarc = new ImageIcon("src/img/Tookitan.png");
			} else if (q==100) {
				nekuoarc = new ImageIcon("src/img/Tankootan.png");
			}
		} else if (c==3) {
			if (q<30) {
				nekuoarc = new ImageIcon("src/img/Payasito.png");
			} else if (q<100) {
				nekuoarc = new ImageIcon("src/img/2Payasitos.png");
			} else if (q==100) {
				nekuoarc = new ImageIcon("src/img/4Payasitos.png");
			}
		} else if (c==4) {
			if (q<30) {
				nekuoarc = new ImageIcon("src/img/Topez.png");
			} else if (q<100) {
				nekuoarc = new ImageIcon("src/img/Topaz.png");
			} else if (q==100) {
				nekuoarc = new ImageIcon("src/img/MechaTopaz.png");
			}
		} else if (c==5) {
			if (q<30) {
				nekuoarc = new ImageIcon("src/img/Polpo.png");
			} else if (q<100) {
				nekuoarc = new ImageIcon("src/img/Tolto.png");
			} else if (q==100) {
				nekuoarc = new ImageIcon("src/img/PolpoTolto.png");
			}
		}
		Image imagenIns = nekuoarc.getImage();
		Image newitarc = imagenIns.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon finalerc = new ImageIcon(newitarc);
		lblNewLabel.setIcon(finalerc);
		contentPane.add(lblNewLabel);
		
		JLabel[] lblNewLabel1 = new JLabel[13];
		for(int i=0;i<lblNewLabel1.length;i++) {
			lblNewLabel1[i]=new JLabel();
			lblNewLabel1[i].setBounds(0+(120*i), 365, 149, 149);
			ImageIcon garfol = new ImageIcon("src/img/Fondo.gif");
			Image ImgIns= garfol.getImage();
			Image newImg=ImgIns.getScaledInstance(lblNewLabel1[i].getWidth(), lblNewLabel1[i].getHeight(), Image.SCALE_FAST);
			ImageIcon finalImage=new ImageIcon(newImg);
			lblNewLabel1[i].setIcon(finalImage);
			contentPane.add(lblNewLabel1[i]);
		}
	
		d=c;	
		r=q;
	}

}
