package ng;


import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;

public class StartPanel extends JPanel {
    
    private GameOn game;
    private GameFrame frame;

    public StartPanel(GameOn game, GameFrame frame) {
        this.game = game;
        this.frame = frame;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(230, 216, 250)); 
        
        JLabel title = new JLabel("Welcome to Memory Game!");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.RED);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel label1 = new JLabel("Player 1 Name:");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField player1Field = new JTextField(15);
        player1Field.setMaximumSize(new Dimension(200, 30));
        player1Field.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel label2 = new JLabel("Player 2 Name:");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField player2Field = new JTextField(15);
        player2Field.setMaximumSize(new Dimension(200, 30));
        player2Field.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton startButton = new JButton("Start Game!");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setBackground(Color.WHITE);
        
        add(Box.createVerticalStrut(100));
        add(title);
        add(Box.createVerticalStrut(50));
        add(label1);
        add(Box.createVerticalStrut(5));
        add(player1Field);
        add(Box.createVerticalStrut(20));
        add(label2);
        add(Box.createVerticalStrut(5));
        add(player2Field);
        add(Box.createVerticalStrut(50));
        add(startButton);

        startButton.addActionListener(e -> {
            String n1 = player1Field.getText().isEmpty() ? "Player 1" : player1Field.getText();
            String n2 = player2Field.getText().isEmpty() ? "Player 2" : player2Field.getText();
            
            game.setPlayers(n1, n2);
            game.restartGame(1); 
            frame.startGame(); 
        });
    }
}