package memoryGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

//Scanner s = new Scanner (System.in);
//	
//	public int i;
//	public String n1;
//	public String n2;
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
	

	public GameFrame() {
		
//		JFrame gf = new JFrame();
		Player p1 = new Player("player 1");
		Player p2 = new Player("player 2");
		Card c = new Card(1);
		GameOn gm = new GameOn(p1, p2);
		GamePanel gp = new GamePanel(gm);
	    GameStatusPanel gsp = new GameStatusPanel(gm);
	    CardButton cb = new CardButton(c);
		
	    
		this.setTitle("memory game");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
//	    this.BorderLayout();
		this.setLayout(new BorderLayout(10,10));
		this.add(gp, BorderLayout.CENTER);
		this.add(gsp, BorderLayout.EAST);
//	    this.setLayout();
		this.getContentPane().setBackground(Color.yellow);
//		this.cb.addActionListener(e ->{
//			this.card.openCard();
//		});
		
		this.setSize(1000,1000);
	}
	
	
	
}
