package memoryGame;
import javax.swing.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartPanel extends JPanel {

	
	
//	public StartPanel(GameOn game , GameStatusPanel gamestatus) {
//		
//		this.game.setUpdateCallback(() -> {
////	        BoardRefresh();
//	        gamestatus.Refresh();
//	    });
//	}
//	
//	Scanner s = new Scanner (System.in);
//	
//	public int i;
//    public String n1;
//	public String n2;
//	
//	Player p1 = new Player(n1);
//	Player p2 = new Player(n2);
//	GameOn game = new GameOn(p1, p2);
//	
//	public void setNamePlayer() {
//		i = 0 ;
//		n1 = null;
//		n2 = null;
//		while(i<2) {
//			System.out.println("enter 1 name");
//			this.n1 = s.next();
//			System.out.println("enter 2 name");
//			this.n2 = s.next();
//			i++;
//		}
//	}
	
	

	

	
	private GameFrame frame;
	    private GameOn game;
	    private GameStatusPanel gamestatus;

	    public StartPanel(GameOn game, GameStatusPanel gamestatus , GameFrame frame) {

	        this.game = game;
	        this.gamestatus = gamestatus;
	        this.frame = frame;
	        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	        JLabel label1 = new JLabel("Player 1 name:");
	        JTextField player1Field = new JTextField(15);

	        JLabel label2 = new JLabel("Player 2 name:");
	        JTextField player2Field = new JTextField(15);

	        JButton startButton = new JButton("Start Game");

	        add(label1);
	        add(player1Field);
	        add(label2);
	        add(player2Field);
	        add(startButton);

//	        startButton.addActionListener(e -> {
//
	            String n1 = player1Field.getText();
	            String n2 = player2Field.getText();
//
//	            game.setPlayers(n1, n2); // תצטרך לממש מתודה כזו
////	            game.setP1(n1);
////	            game.setP2(n2);
//	            gamestatus.Refresh();
//
//	            
//	            gamestatus.Refresh();

//	            frame.show("game"); // 👈 מעבר למסך משחק
	            startButton.addActionListener(e -> {
	                game.setPlayers(n1, n2);
	                gamestatus.Refresh();
	                frame.showStartScreen("game");
	            });
	            
	            // מעבר מסך אם אתה משתמש ב-CardLayout
	            // cardLayout.show(mainPanel, "game");
//	        });
	    }
	
	
	    
	
	
	
}
