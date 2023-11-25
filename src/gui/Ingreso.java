package gui;

import javax.swing.JFrame;

import logica.Usuario;

@SuppressWarnings("serial")
public class Ingreso extends JFrame{

	private JFrame frame;
	protected Usuario us = new Usuario();

	/**
	 * Create the application.
	 */
	public Ingreso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
