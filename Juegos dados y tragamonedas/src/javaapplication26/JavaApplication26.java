import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameMenuGUI extends JFrame {
    private JButton diceGameButton;
    private JButton slotMachineGameButton;

    public GameMenuGUI() {
        super("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        diceGameButton = new JButton("Dice Game");
        slotMachineGameButton = new JButton("Slot Machine Game");

        diceGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiceGame diceGame = new DiceGame();
                diceGame.startGame();
            }
        });

        slotMachineGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SlotMachineGame slotMachineGame = new SlotMachineGame();
                slotMachineGame.startGame();
            }
        });

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(diceGameButton);
        panel.add(slotMachineGameButton);

        getContentPane().add(panel);

        setSize(200, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMenuGUI();
            }
        });
    }

    class DiceGame extends JFrame implements ActionListener {
        private JButton rollButton;
        private JLabel resultLabel1;
        private JLabel resultLabel2;

        public DiceGame() {
            super("Dice Game");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            rollButton = new JButton("Roll Dice");
            rollButton.addActionListener(this);

            resultLabel1 = new JLabel();
            resultLabel2 = new JLabel();

            JPanel panel = new JPanel(new GridLayout(3, 1));
            panel.add(rollButton);
            panel.add(resultLabel1);
            panel.add(resultLabel2);

            getContentPane().add(panel);

            setSize(200, 150);
            setLocationRelativeTo(null);
        }

        public void startGame() {
            resultLabel1.setText("");
            resultLabel2.setText("");
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int diceResult1 = random.nextInt(6) + 1;
            int diceResult2 = random.nextInt(6) + 1;
            resultLabel1.setText("Dice 1 Rolled: " + diceResult1);
            resultLabel2.setText("Dice 2 Rolled: " + diceResult2);
        }
    }

    class SlotMachineGame extends JFrame implements ActionListener {
        private JButton spinButton;
        private JLabel resultLabel;

        public SlotMachineGame() {
            super("Slot Machine");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            spinButton = new JButton("Spin");
            spinButton.addActionListener(this);

            resultLabel = new JLabel();

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(spinButton, BorderLayout.CENTER);
            panel.add(resultLabel, BorderLayout.NORTH);

            getContentPane().add(panel);

            setSize(200, 150);
            setLocationRelativeTo(null);
        }

        public void startGame() {
            resultLabel.setText("");
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomValue1 = random.nextInt(10);
            int randomValue2 = random.nextInt(10);
            int randomValue3 = random.nextInt(10);

            resultLabel.setText("Result: " + randomValue1 + " - " + randomValue2 + " - " + randomValue3);

            if (randomValue1 == randomValue2 && randomValue2 == randomValue3) {
                JOptionPane.showMessageDialog(this, "GANASTE!!");
            }
        }
    }
}
