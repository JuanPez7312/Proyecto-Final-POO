package gui;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class ideas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	private int yCoordinate = 268;
	int d;
	int r;
	private int textcouti=0,textcountin,textcounten,textcountp;
	private int yPos;
	private JPanel panel;
	public ideas(int c, int q) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1547, 822);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(207,210,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

			
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(1230, 81, 163, 66);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("volver");
		contentPane.add(btnNewButton_1);	
        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/Minecraft.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 20);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                btnNewButton_1.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Aquí puedes poner el código que se ejecutará cuando se haga clic en el JLabel
                pokedex pukimon = new pokedex(c,q);
                dispose();
            }
        });
		lblNewLabel.setBounds(127, 10, 191, 191);
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
		d=c;	
		r=q;

		JButton btnNewButton = new JButton("Nueva idea");
		btnNewButton.setBounds(80, 736, 284, 49);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("new");
		contentPane.add(btnNewButton);
        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/Minecraft.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 20);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                btnNewButton.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(1169, 736, 284, 49);
		contentPane.add(btnNewButton_2);
        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/Minecraft.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 20);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                btnNewButton_2.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
		
		JProgressBar progressBar = new JProgressBar();
		r = Math.max(0, Math.min(100, r));
		progressBar.setValue(r);
		progressBar.setStringPainted(true);
		progressBar.setBounds(443, 138, 647, 43);
		contentPane.add(progressBar);
        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/Minecraft.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 20);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                progressBar.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(443, 50, 647, 49);
		contentPane.add(lblNewLabel_3);	
        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/KartDS.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 50);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                lblNewLabel_3.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
		
		JLabel lblNewLabel_1_1 = new JLabel("Ideas");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setBackground(new Color(133, 114, 143));
		lblNewLabel_1_1.setBounds(80, 211, 284, 505);
		contentPane.add(lblNewLabel_1_1);

        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/KartDS.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 50);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                lblNewLabel_1_1.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }    
		
		JLabel lblNewLabel_2 = new JLabel("Incompleto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBackground(new Color(169,31,72));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(443, 211, 284, 505);
		lblNewLabel_2.setOpaque(true);
		contentPane.add(lblNewLabel_2);

        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/KartDS.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 50);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                lblNewLabel_2.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
		
		JLabel lblNewLabel_1 = new JLabel("Progreso");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1.setBackground(new Color(220,194,73));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(806, 211, 284, 505);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);

        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/KartDS.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 50);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                lblNewLabel_1.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
				
		JLabel lblNewLabel_2_1 = new JLabel("Completo");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBackground(new Color(55,148,110));
		lblNewLabel_2_1.setBounds(1169, 211, 284, 505);
		contentPane.add(lblNewLabel_2_1);

        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/KartDS.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 50);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                lblNewLabel_2_1.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ideas");
		lblNewLabel_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1_1_1.setBackground(new Color(0, 0, 51));
		lblNewLabel_1_1_1.setBounds(75, 206, 294, 515);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ideas");
		lblNewLabel_1_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1_1_1_1.setBackground(new Color(0, 0, 51));
		lblNewLabel_1_1_1_1.setBounds(438, 206, 294, 515);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Ideas");
		lblNewLabel_1_1_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1_2.setOpaque(true);
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1_1_1_2.setBackground(new Color(0, 0, 51));
		lblNewLabel_1_1_1_2.setBounds(801, 206, 294, 515);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Ideas");
		lblNewLabel_1_1_1_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1_3.setOpaque(true);
		lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1_1_1_3.setBackground(new Color(0, 0, 51));
		lblNewLabel_1_1_1_3.setBounds(1164, 206, 294, 515);
		contentPane.add(lblNewLabel_1_1_1_3);
		
				
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "volver":
			
			dispose();
		break;
		case "new":
			crearNuevaTextArea();
		break;
		}
	}

    private void crearNuevaTextArea() {
    	if (textcouti<0) {
    		textcouti=0;
    	}
    	int u = 88*textcouti;
    	JTextArea textArea = new JTextArea();
    	textArea.setBounds(92, yCoordinate+u, 262, 78);
    	textArea.setEditable(true);
    	textArea.setWrapStyleWord(false);
		textArea.setText("123456789012345678901");
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(92, yCoordinate+u, 262, 78);
        try {
            // Ruta al archivo de la fuente externa
            String kartPath = "src/fuentes/Minecraft.ttf";

            // Carga el archivo de fuente en un flujo de entrada
            try (InputStream kartStream = new FileInputStream(new String(kartPath))) {

                // Crea la fuente desde el flujo de entrada
                Font kartFont = Font.createFont(Font.TRUETYPE_FONT, kartStream);

                // Deriva una nueva fuente con el estilo deseado
                Font kartFontBold = kartFont.deriveFont(Font.PLAIN, 18);

                // Aplica la fuente personalizada a tu componente (por ejemplo, una etiqueta)
                textArea.setFont(kartFontBold);
            }

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        // Incrementar la coordenada vertical para la próxima JTextArea

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItemMover = new JMenuItem("Proseguir");
        JMenuItem menuItemEliminar = new JMenuItem("Eliminar");

        popupMenu.add(menuItemMover);
        popupMenu.add(menuItemEliminar);

        // Acción para mover la JTextArea a 363 en X
        menuItemMover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
            	if (scrollPane.getX() > 820) {
                	aviso();
                } else {
                	scrollPane.setLocation(scrollPane.getX()+363, scrollPane.getY());
                	textArea.setEditable(false);
                	Component[] components = contentPane.getComponents();
                    yPos = 268;
                    for (Component component : components) {
                        if (component instanceof JScrollPane) {	
                        	 component.setBounds(component.getX(), yPos, 262, 78);
                             yPos += 88;
                        }
                    }
                    setComponentZOrder(scrollPane, 2);
                   	textcouti-=1;
                }
            }
        });

        // Acción para eliminar la JTextArea
        menuItemEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	contentPane.remove(textArea);
            	contentPane.remove(scrollPane);
                updateTextAreaPositions();
                setComponentZOrder(scrollPane, 2);
                textcouti-=1;
            }
        });

        // Agrega el menú emergente al JTextArea
        textArea.setComponentPopupMenu(popupMenu);
        textcouti+=1;
        // Agrega el JTextArea al JFrame
        contentPane.add(scrollPane);
        
        setComponentZOrder(scrollPane, 2);
        // Revalidar y repintar el panel para que se muestre la nueva JTextArea
        contentPane.revalidate();
        contentPane.repaint();
    }

	private void aviso() { 
       	JOptionPane.showMessageDialog(this,"Esta idea ya se completo");
    }
	

    private void updateTextAreaPositions() {
        Component[] components = contentPane.getComponents();
        yPos = 268;
        for (Component component : components) {
            if (component instanceof JScrollPane) {
                component.setBounds(component.getX(), yPos, 262, 78);
                yPos += 88;
            }
        }
    }
}
