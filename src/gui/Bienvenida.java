package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulolbl = new JLabel("");
		Titulolbl.setBounds(303, 11, 703, 151);
		ImageIcon titleImg =new ImageIcon ("src/imgs/Title.png");
		Image titleImgIns= titleImg.getImage();
		Image titleNewImg=titleImgIns.getScaledInstance(Titulolbl.getWidth(), Titulolbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon titleFinalImage=new ImageIcon(titleNewImg);
		Titulolbl.setIcon(titleFinalImage);
		contentPane.add(Titulolbl);
	}
}
