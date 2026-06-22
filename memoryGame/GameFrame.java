package ng;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    public GameOn gm;
    public StartPanel sp;
    public GameStatusPanel gsp;
    public GamePanel gp;
    public EndPanel ep;
    
    public CardLayout cardLayout;
    public JPanel mainPanel;
    public JPanel gameContainer;

    public GameFrame() {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        gm = new GameOn(p1, p2);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        gsp = new GameStatusPanel(gm);
        gp = new GamePanel(gm, gsp);
        gsp.setGamePanel(gp);
        
        sp = new StartPanel(gm, this);
        ep = new EndPanel(gm, this);
        
        gm.setGameOverCallback(() -> {
            ep.refreshEndScreen();
            showScreen("end");
        });
        
        gameContainer = new JPanel(new BorderLayout());
        gameContainer.add(gsp, BorderLayout.NORTH);
        gameContainer.add(gp, BorderLayout.CENTER);
        
        mainPanel.add(sp, "start");
        mainPanel.add(gameContainer, "game");
        mainPanel.add(ep, "end");
        
        this.setTitle("Memory Game Pro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.showScreen("start");
    }
    
    public void startGame() {
        gp.restartBoard(); 
        gsp.Refresh(); 
        showScreen("game");
    }
    
    public void showScreen(String name) {
        cardLayout.show(mainPanel, name);
    }
}