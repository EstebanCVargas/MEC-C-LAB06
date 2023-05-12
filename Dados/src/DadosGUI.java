import java.awt.event.*;
import javax.swing.*;

public class DadosGUI {
  public static void main(String[] args) {
    // Crear una ventana
    JFrame frame = new JFrame("Juego de Dados");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);

    // Crear dos etiquetas para mostrar los resultados de cada dado
    JLabel resultado1 = new JLabel("Dado 1: ");
    resultado1.setBounds(60, 50, 80, 20);
    frame.add(resultado1);

    JLabel resultado2 = new JLabel("Dado 2: ");
    resultado2.setBounds(160, 50, 80, 20);
    frame.add(resultado2);

    // Crear dos botones para lanzar los dados
    JButton boton1 = new JButton("Lanzar Dado 1");
    boton1.setBounds(30, 100, 120, 30);
    JButton boton2 = new JButton("Lanzar Dado 2");
    boton2.setBounds(150, 100, 120, 30);

    // Agregar un listener a cada botón para mostrar el resultado correspondiente
    boton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Generar un número aleatorio entre 1 y 6
        int numero = (int)(Math.random() * 6) + 1;
        // Actualizar la etiqueta con el resultado
        resultado1.setText("Dado 1: " + numero);
      }
    });

    boton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Generar un número aleatorio entre 1 y 6
        int numero = (int)(Math.random() * 6) + 1;
        // Actualizar la etiqueta con el resultado
        resultado2.setText("Dado 2: " + numero);
      }
    });

    // Agregar los botones a la ventana
    frame.add(boton1);
    frame.add(boton2);

    // Mostrar la ventana
    frame.setLayout(null);
    frame.setVisible(true);
  }
}

