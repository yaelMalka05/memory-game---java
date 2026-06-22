package memoryGame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	public Runnable r;
	
	
	public EndPanel ep;
	public StartPanel sp;
	public GameOn gm;
	public GameStatusPanel gsp;
	public GamePanel gp;
	public CardLayout cardLayout;
	public JPanel mainPanel;
	

	public GameFrame() {
		
//		r = run;
		Player p1 = new Player("player 1");
		Player p2 = new Player("player 2");
		gm = new GameOn(p1, p2);
		
		gsp = new GameStatusPanel(gm);
		
		ep = new EndPanel(gm , gsp);
		
		sp = new StartPanel(gm ,gsp , this);
		
		 cardLayout= new CardLayout();
		 mainPanel = new JPanel(cardLayout);
		
		
//		JFrame gf = new JFrame();
		
//		Card c = new Card(1);
		 
		 
		 gp = new GamePanel(gm ,gsp);
//	    CardButton cb = new CardButton(c);
		gsp.setGamePanel(gp); // מחבר את פאנל המשחק לפאנל הסטטוס שבו נמצא הכפתור
	    
		this.setTitle("memory game");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLayout(new FlowLayout());
//	    this.BorderLayout();
		this.setLayout(new CardLayout());
//		this.setLayout(new BorderLayout(10,10));
//		this.add(gp, BorderLayout.CENTER);
//		this.add(gsp, BorderLayout.NORTH);
//		this.add(gp, CardLayout());
//		this.add(gsp, CardLayout.NORTH);
//	    this.setLayout();
		mainPanel.add(sp,"start");
		mainPanel.add(ep,"end");
		 mainPanel.add(gp, "game");
		this.getContentPane().setBackground(Color.white);
//		this.cb.addActionListener(e ->{
//			this.card.openCard();
//		});
		this.setContentPane(mainPanel);
		this.setSize(1000,1000);
		this.showStartScreen("start");
//		cardLayout.show(mainPanel, "start");
	}
	
	public void showStartScreen(String n ) {
	    cardLayout.show(mainPanel, n);
//	    cardLayout.show(mainPanel, "game");
//	    cardLayout.show(mainPanel, "end");
	}
	
}
