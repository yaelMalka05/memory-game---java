//package memoryGame;
//
//import javax.swing.AbstractButton;
//import javax.swing.BoxLayout;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class GameStatusPanel extends JPanel{
//
////	public CardButton arr[];
//	public GameOn gameManneger;
////	private JPanel panel;
////	public Player currentPlyer;
//	private JLabel labelCurrentPlayer;
//	private JLabel labelPlayer1Score;
//	private JLabel labelPlayer2Score;
//	
//	private GamePanel gp ;
//
//	  
////	public int player2Score;
//	
//	
//	public GameStatusPanel(GameOn gameManneger) {
//		this.gameManneger = gameManneger;
////		this.arr = new CardButton[16];
//		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//		this.labelCurrentPlayer = new JLabel();
//		this.labelPlayer1Score = new JLabel();
//		this.labelPlayer2Score = new JLabel();
////		this.labelPlayer1Score.setF
////		This.setLayout(new BoxLayout.createRigidArea(0,15);
//		this.add(labelCurrentPlayer);
//		this.add(labelPlayer1Score);
//		this.add(labelPlayer2Score);
//		this.Refresh();
//	}
//	
//	public void Refresh() {
////		this.labelCurrentPlyer.setForeground();
//		if(this.gameManneger.getCurrent()==1)
//			this.labelCurrentPlayer.setText("It's " + gameManneger.getP1().getName() + " is turn!");
//		else
//			this.labelCurrentPlayer.setText("It's " + gameManneger.getP2().getName() + " is turn!");
//		this.labelPlayer1Score.setText(gameManneger.getP1().getName() + " is score is: " + gameManneger.getP1().getCore());
//		this.labelPlayer2Score.setText(gameManneger.getP2().getName() + " is score is: " + gameManneger.getP2().getCore());
//	}
//		
//}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//


package memoryGame;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStatusPanel extends JPanel {

	public GameOn gameManneger;
	private JLabel labelCurrentPlayer;
	private JLabel labelPlayer1Score;
	private JLabel labelPlayer2Score;
	private JButton btnRestart; // הכפתור החדש שלנו
	
	private GamePanel gp; // שומר התייחסות לפאנל המשחק כדי שנוכל לרענן אותו

	public GameStatusPanel(GameOn gameManneger) {
		this.gameManneger = gameManneger;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.labelCurrentPlayer = new JLabel();
		this.labelCurrentPlayer = new JLabel();
		// הגדלת הלייבל של התור הנוכחי לגודל 22 ומודגש
		this.labelCurrentPlayer.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
		this.labelPlayer1Score = new JLabel();
		this.labelPlayer2Score = new JLabel();
		this.btnRestart = new JButton("New Game"); // אתחול הכפתור עם טקסט
		this.btnRestart.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 32));
		
		
		this.add(labelCurrentPlayer);
		this.add(labelPlayer1Score);
		this.add(labelPlayer2Score);
		this.add(btnRestart); // הוספת הכפתור למסך מתחת ללייבלים
		
		// הגדרת הפעולה שתקרה ברגע שלוחצים על הכפתור
		this.btnRestart.addActionListener(e -> {
			this.gameManneger.restartGame(); // מאפס את הנתונים בתוך GameOn
			if (this.gp != null) {
				this.gp.restartBoard(); // מאפס ומייצר מחדש את כפתורי הקלפים
			}
			this.Refresh(); // מרענן את הטקסט של הניקוד והתור הנוכחי
		});
		
		this.Refresh();
	}
	
	// פונקציה קטנה שמאפשרת לנו לקשר את ה-GamePanel מכאן
	public void setGamePanel(GamePanel gp) {
		this.gp = gp;
	}
	
	public void Refresh() {
		if(this.gameManneger.getCurrent()==1) {
			this.labelCurrentPlayer.setText("It's " + gameManneger.getP1().getName() + " is turn!");
			this.labelCurrentPlayer.setForeground(java.awt.Color.RED); // צבע אדום בולט לשחקן 1
			this.labelCurrentPlayer.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 42));
//			this.labelCurrentPlayer.setHorizontalTextPosition(BorderLayout.CENTER);
		}
		else {
			this.labelCurrentPlayer.setText("It's " + gameManneger.getP2().getName() + " is turn!");
			this.labelCurrentPlayer.setForeground(java.awt.Color.GREEN); // צבע כחול בולט לשחקן 2
			this.labelCurrentPlayer.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 42));
		}
		this.labelPlayer1Score.setText(gameManneger.getP1().getName() + " is score is: " + gameManneger.getP1().getCore());
		this.labelPlayer1Score.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 32));
		this.labelPlayer2Score.setText(gameManneger.getP2().getName() + " is score is: " + gameManneger.getP2().getCore());
		this.labelPlayer2Score.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 32));

	}
}
