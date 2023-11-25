package gui;
import javax.swing.*;
import java.awt.*;

public class TransparentScrollPaneExample extends JFrame {

    public TransparentScrollPaneExample() {
        setTitle("Transparent JScrollPane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Crear un JTextArea para demostrar el uso del JScrollPane
        JTextArea textArea = new JTextArea("Contenido del JTextArea");

        // Crear un JScrollPane transparente y agregar el JTextArea
        JScrollPane scrollPane = new TransparentScrollPane(textArea);

        // Añadir el JScrollPane al contenedor principal
        getContentPane().add(scrollPane);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Clase personalizada que extiende JScrollPane
    private static class TransparentScrollPane extends JScrollPane {
        public TransparentScrollPane(Component view) {
            super(view);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // Dibujar el fondo transparente
            g.setColor(new Color(0, 0, 0, 0));
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TransparentScrollPaneExample();
            }
        });
    }
}