package ng;


import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.*;

public class EndPanel extends JPanel {
    private GameOn go;
    private JLabel winnerLabel;
    
    public EndPanel(GameOn game, GameFrame frame) {
        this.go = game;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(230, 216, 250)); 
        
        winnerLabel = new JLabel("");
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        winnerLabel.setForeground(Color.RED);
        winnerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton newGameBtn = new JButton("New Game (Change Players)");
        newGameBtn.setFont(new Font("Arial", Font.BOLD, 20));
        newGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton hardLevelBtn = new JButton("Next Level (Harder)");
        hardLevelBtn.setFont(new Font("Arial", Font.BOLD, 20));
        hardLevelBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(Box.createVerticalStrut(200));
        add(winnerLabel);
        add(Box.createVerticalStrut(50));
        add(newGameBtn);
        add(Box.createVerticalStrut(20));
        add(hardLevelBtn);
        
        newGameBtn.addActionListener(e -> {
            frame.showScreen("start"); 
        });
        
        hardLevelBtn.addActionListener(e -> {
            go.restartGame(2); 
            frame.startGame();
        });
    }
    
    public void refreshEndScreen() {
        int score1 = go.getP1().getCore();
        int score2 = go.getP2().getCore();
        
        if (score1 > score2) {
            winnerLabel.setText(" " + go.getP1().getName() + " Wins! (" + score1 + " pts)");
        } else if (score2 > score1) {
            winnerLabel.setText(" " + go.getP2().getName() + " Wins! (" + score2 + " pts)");
        } else {
            winnerLabel.setText(" It's a Tie! (" + score1 + " pts each)");
        }
    }
}