package memoryGame;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
//	Scanner s = new Scanner (System.in);
//	
//	public int i;
//	public String n1;
//	public String n2;
	
//	Player p1 = new Player(n1);
//	Player p2 = new Player(n2);
//	GameOn game = new GameOn(p1, p2);
	
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
	
//	GameStatusPanel gameStatus = new GameStatusPanel(game);
	
	public CardButton [] arr;
	
	public GameOn go;
	
	public void RebootPanel() {
		this.setLayout(new GridLayout(4,4,10,10));
	}
	
	public void  BoardRefresh() {
		
//		this.arr = new CardButton[16];
		
//		for (int i = 0; i <arr.length; i++) {
//				arr[i].Refresh();
//		}
		for(int i=0; i<this.arr.length; i++) {
			this.arr[i].Refresh();
		}
	}
	
	
	
	
	public GamePanel(GameOn game) {
		this.arr = new CardButton[16];
		this.setLayout(new GridLayout(4,4,10,10));
		this.go = game; 
		Card [] cards = this.go.getB().getCards();
		for(int i=0; i<cards.length; i++) {
			this.arr[i] = new CardButton(cards[i]);
			this.add(arr[i]);
		}
		for(int i=0; i<this.arr.length; i++) {
			this.arr[i].Refresh();
		}
		
//		this.RebootPanel();
//		this.setLayout(new GridLayout(4,4,10,10));
//		this.BoardRefresh();
	}
	
	
	

}
