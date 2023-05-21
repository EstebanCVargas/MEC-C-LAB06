import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

public class JuegoInterfazGrafica extends JFrame implements ActionListener {
    private JButton juegoDadosButton;
    private JButton juegoTragamonedasButton;
    private Random random;
    private ImageIcon[] tragamonedasImages;

    public JuegoInterfazGrafica() {
        setTitle("Juegos de Azar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(3, 1));

        JLabel tituloLabel = new JLabel("Menú de Juegos", SwingConstants.CENTER);
        juegoDadosButton = new JButton("Juego Dados");
        juegoTragamonedasButton = new JButton("Juego Tragamonedas");

        add(tituloLabel);
        add(juegoDadosButton);
        add(juegoTragamonedasButton);

        juegoDadosButton.addActionListener(this);
        juegoTragamonedasButton.addActionListener(this);

        random = new Random();
        loadTragamonedasImages();
    }

    private void loadTragamonedasImages() {
        tragamonedasImages = new ImageIcon[3];
        for (int i = 0; i < 3; i++) {
            String imagePath = "/tragamonedas/" + (i + 1) + ".png";
            URL imageURL = getClass().getResource(imagePath);
            if (imageURL != null) {
                tragamonedasImages[i] = new ImageIcon(imageURL);
            } else {
                System.out.println("Error al cargar la imagen: " + imagePath);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JuegoInterfazGrafica juego = new JuegoInterfazGrafica();
            juego.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == juegoDadosButton) {
            abrirJuegoDados();
        } else if (e.getSource() == juegoTragamonedasButton) {
            abrirJuegoTragamonedas();
        }
    }

    private void abrirJuegoDados() {
        JDialog juegoDadosDialog = new JDialog(this, "Juego Dados", true);
        juegoDadosDialog.setSize(300, 200);
        juegoDadosDialog.setLayout(new GridLayout(5, 1));

        ImageIcon[] dados = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            String imagePath = "/dados/" + (i + 1) + ".png";
            URL imageURL = getClass().getResource(imagePath);
            if (imageURL != null) {
                dados[i] = new ImageIcon(imageURL);
            } else {
                System.out.println("Error al cargar la imagen: " + imagePath);
            }
        }

        JLabel dado1TextLabel = new JLabel("Dado 1:");
        JLabel dado2TextLabel = new JLabel("Dado 2:");
        JLabel dado1Label = new JLabel();
        JLabel dado2Label = new JLabel();
        JLabel resultadoLabel = new JLabel();

        JButton tirarDadosButton = new JButton("Tirar Dados");
        tirarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroDado1 = random.nextInt(6);
                int numeroDado2 = random.nextInt(6);
                dado1Label.setIcon(dados[numeroDado1]);
                dado2Label.setIcon(dados[numeroDado2]);
                int resultado = numeroDado1 + numeroDado2 + 2; // Suma de los resultados de los dados
                resultadoLabel.setText("Resultado: " + resultado);
            }
        });

        juegoDadosDialog.add(dado1TextLabel);
        juegoDadosDialog.add(dado1Label);
        juegoDadosDialog.add(dado2TextLabel);
        juegoDadosDialog.add(dado2Label);
        juegoDadosDialog.add(tirarDadosButton);
        juegoDadosDialog.add(resultadoLabel);

        juegoDadosDialog.setVisible(true);
    }

    private void abrirJuegoTragamonedas() {
        JDialog juegoTragamonedasDialog = new JDialog(this, "Juego Tragamonedas", true);
        juegoTragamonedasDialog.setSize(300, 200);
        juegoTragamonedasDialog.setLayout(new GridLayout(4, 1));

        JLabel imagen1Label = new JLabel();
        JLabel imagen2Label = new JLabel();
        JLabel imagen3Label = new JLabel();
        JLabel resultadoLabel = new JLabel();

        JButton girarButton = new JButton("Girar");
        girarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imagen1 = tragamonedasImages[random.nextInt(3)];
                ImageIcon imagen2 = tragamonedasImages[random.nextInt(3)];
                ImageIcon imagen3 = tragamonedasImages[random.nextInt(3)];

                imagen1Label.setIcon(imagen1);
                imagen2Label.setIcon(imagen2);
                imagen3Label.setIcon(imagen3);

                if (imagen1 == imagen2 && imagen2 == imagen3) {
                    resultadoLabel.setText("¡Ganaste!");
                } else {
                    resultadoLabel.setText("¡Intenta de nuevo!");
                }
            }
        });

        juegoTragamonedasDialog.add(imagen1Label);
        juegoTragamonedasDialog.add(imagen2Label);
        juegoTragamonedasDialog.add(imagen3Label);
        juegoTragamonedasDialog.add(girarButton);
        juegoTragamonedasDialog.add(resultadoLabel);

        juegoTragamonedasDialog.setVisible(true);
    }
}
