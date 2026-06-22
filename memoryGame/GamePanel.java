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
	
	private GameStatusPanel gs;
	
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
		revalidate();
	    repaint();
	}
	
	
	
	
//	public GamePanel(GameOn game , GameStatusPanel gamestatus) {
//		this.arr = new CardButton[16];
//		this.setLayout(new GridLayout(4,4,10,10));
//		this.go = game; 
//		this.gs = gamestatus;
//		Card [] cards = this.go.getB().getCards();
//		for(int i=0; i<cards.length; i++) 
//		{
//			this.arr[i] = new CardButton(cards[i]);
//			
//			this.arr[i].addActionListener(e -> {
//		    CardButton btn = (CardButton)e.getSource();
//		    this.go.chooseCard(btn.GetCard());
//		    
//		    this.BoardRefresh();
//		    this.gs.Refresh();
//		});
////			this.arr[i].GetCard();
//			
//		this.add(arr[i]);
//		}
//		for(int i=0; i<this.arr.length; i++) {
//			this.arr[i].Refresh();
//		}
		
//		this.RebootPanel();
//		this.setLayout(new GridLayout(4,4,10,10));
//		this.BoardRefresh();
//	}
	public GamePanel(GameOn game, GameStatusPanel gamestatus) {
	    this.arr = new CardButton[16];
	    this.setLayout(new GridLayout(4, 4, 10, 10));
	    this.go = game;
	    this.gs = gamestatus;
	    
	    // הגדרת קולבק שיעדכן את הלוח ואת סטטוס הנקודות בכל שינוי במשחק
	    this.go.setUpdateCallback(() -> {
	        BoardRefresh();
	        gs.Refresh();
	    });
	    
	    // שליחת הכרטיסים מהלוח ואתחול כפתורי התצוגה
	    Card[] cards = go.getB().getCards();
	    for (int i = 0; i < this.arr.length; i++) {
	        this.arr[i] = new CardButton(cards[i]);
	        CardButton btn = this.arr[i];
	        
	        // הוספת מאזין לחיצה לכל כפתור
	        btn.addActionListener(e -> {
	            go.chooseCard(btn.GetCard());
	        });
	        
	        this.add(btn); // הוספת הכפתור לפאנל הגרפי
	    }
	    
	    BoardRefresh(); // ריענון ראשוני של הלוח
	}
	
	
	// פונקציה חדשה שמנקה את הלוח הגרפי ומייצרת כפתורים חדשים
		public void restartBoard() {
			this.removeAll(); // מוחק את כל הכפתורים הישנים מהמסך
			
			Card[] cards = go.getB().getCards(); // לוקח את מערך הקלפים החדש
			for (int i = 0; i < this.arr.length; i++) {
				this.arr[i] = new CardButton(cards[i]);
				CardButton btn = this.arr[i];
				
				// מחבר מחדש את מאזין הלחיצה לכל כפתור
				btn.addActionListener(e -> {
					go.chooseCard(btn.GetCard());
				});
				
				this.add(btn); // מוסיף את הכפתור החדש לפאנל
			}
			
			BoardRefresh(); // מריץ ריענון גרפי כדי שהשינויים יראו על המסך
		}
	
	
	
	

}
