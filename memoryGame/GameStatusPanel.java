package ng;


import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class GameStatusPanel extends JPanel {
    public GameOn gameManneger;
    private JLabel labelCurrentPlayer;
    private JLabel labelPlayer1Score;
    private JLabel labelPlayer2Score;
    private JButton btnRestart;
    private GamePanel gp; 

    public GameStatusPanel(GameOn gameManneger) {
        this.gameManneger = gameManneger;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(230, 216, 250)); 
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.labelCurrentPlayer = new JLabel();
        this.labelCurrentPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.labelPlayer1Score = new JLabel();
        this.labelPlayer1Score.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.labelPlayer2Score = new JLabel();
        this.labelPlayer2Score.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.btnRestart = new JButton("Restart Game"); 
        this.btnRestart.setFont(new Font("Arial", Font.BOLD, 22));
        this.btnRestart.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(labelCurrentPlayer);
        this.add(labelPlayer1Score);
        this.add(labelPlayer2Score);
        this.add(btnRestart);
        
        this.btnRestart.addActionListener(e -> {
            this.gameManneger.restartGame(1);
            if (this.gp != null) {
                this.gp.restartBoard(); 
            }
            this.Refresh(); 
        });
        
        this.Refresh();
    }
    
    // הפונקציה שהייתה חסרה!
    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }
    
    public void Refresh() {
        if(this.gameManneger.getCurrent() == 1) {
            this.labelCurrentPlayer.setText("Turn: " + gameManneger.getP1().getName());
            this.labelCurrentPlayer.setForeground(Color.RED); 
            this.labelCurrentPlayer.setFont(new Font("Arial", Font.BOLD, 42));
        } else {
            this.labelCurrentPlayer.setText("Turn: " + gameManneger.getP2().getName());
            this.labelCurrentPlayer.setForeground(Color.RED); 
            this.labelCurrentPlayer.setFont(new Font("Arial", Font.BOLD, 42));
        }
        this.labelPlayer1Score.setText(gameManneger.getP1().getName() + " Score: " + gameManneger.getP1().getCore());
        this.labelPlayer1Score.setFont(new Font("Arial", Font.BOLD, 22));
        this.labelPlayer2Score.setText(gameManneger.getP2().getName() + " Score: " + gameManneger.getP2().getCore());
        this.labelPlayer2Score.setFont(new Font("Arial", Font.BOLD, 22));
    }
}