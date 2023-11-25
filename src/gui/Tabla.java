package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import logica.ListaTareas;
import logica.Usuario;
import modelosListas.TablaModelListas;

public class Tabla {

	private JFrame frmTabla;
	private JTable table;
	public Usuario us = new Usuario(); // Temporal, necesito que esta tabla extienda de la principal que tendra como
								// atributo protegido el usuario que se esta manejando

	public Tabla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTabla = new JFrame();
		frmTabla.setTitle("Tabla");
		frmTabla.setBounds(100, 100, 585, 300);
		frmTabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTabla.getContentPane().setLayout(new BorderLayout()); // Usa un administrador de diseño

		try {
			//TEMPORAL
			// Creacion de usuario y listas de tareas para probar si aparecen correctamente
			// los titulos

			ListaTareas l1 = new ListaTareas();
			l1.setTitulo("Lista 1");
			ListaTareas l2 = new ListaTareas();
			l2.setTitulo("Lista 2");
			ListaTareas l3 = new ListaTareas();
			l3.setTitulo("Lista 3");
			ListaTareas l4 = new ListaTareas();
			l4.setTitulo("Lista 4");
			ListaTareas l5 = new ListaTareas();
			l5.setTitulo("Lista 5");
			ListaTareas l6 = new ListaTareas();
			l6.setTitulo("Lista 6");
			ArrayList<ListaTareas> listas = new ArrayList<ListaTareas>();
			listas.add(l1);
			listas.add(l2);
			listas.add(l3);
			listas.add(l4);
			listas.add(l5);
			listas.add(l6);
			us.setListas(listas);

			// Fin prueba

			TablaModelListas modelo = new TablaModelListas(us);
			table = new JTable(modelo);

			// Crear un renderizador para centrar el texto
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);

			// Establecer el renderizador para todas las columnas
			for (int i = 0; i < table.getColumnCount(); i++) {
				table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}

			table.setRowHeight(50); // Cambia este valor para ajustar la altura

			JScrollPane scrollPane = new JScrollPane(table);
			frmTabla.getContentPane().add(scrollPane, BorderLayout.CENTER); // Agrega solo el panel de desplazamiento

			// Agregar un MouseListener para detectar el doble clic
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						JTable target = (JTable) e.getSource();
						int row = target.getSelectedRow();
						int column = target.getSelectedColumn();
						// Aquí puedes realizar la acción que desees con la celda seleccionada
						JOptionPane.showMessageDialog(null,
								"Doble clic en la celda: " + target.getValueAt(row, column));
					}
				}
			});

			frmTabla.setVisible(true); // Asegúrate de hacer visible el marco

		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "No hay registros");
		}

		// Crea un boton que me permite volver a la ventana principal
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(new Color(255, 255, 255));
		btnRegresar.setBackground(new Color(0, 0, 0));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTabla.setVisible(false);

			}
		});
		frmTabla.getContentPane().add(btnRegresar, BorderLayout.SOUTH);
	}

}
