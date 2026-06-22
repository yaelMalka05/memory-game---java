package memoryGame;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStatusPanel extends JPanel{

//	public CardButton arr[];
	public GameOn gameManneger;
//	private JPanel panel;
//	public Player currentPlyer;
	private JLabel labelCurrentPlayer;
	private JLabel labelPlayer1Score;
	private JLabel labelPlayer2Score;
	
	private GamePanel gp ;

	  
//	public int player2Score;
	
	
	public GameStatusPanel(GameOn gameManneger) {
		this.gameManneger = gameManneger;
//		this.arr = new CardButton[16];
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.labelCurrentPlayer = this.labelPlayer1Score = new JLabel();
		this.labelPlayer1Score = new JLabel();
		this.labelPlayer2Score = new JLabel();
//		this.labelPlayer1Score.setF
//		This.setLayout(new BoxLayout.createRigidArea(0,15);
		this.Refresh();
	}
	
	public void Refresh() {
//		this.labelCurrentPlyer.setForeground();
		if(this.gameManneger.getCurrent()==1)
			this.labelCurrentPlayer.setText("It's "+gameManneger.getP1().getName()+"is turn!");
		else
			this.labelCurrentPlayer.setText("It's "+gameManneger.getP2().getName()+"is turn!");
		this.labelPlayer1Score.setText(gameManneger.getP1().getName()+"is score is: "+gameManneger.getP1().getCore());
		this.labelPlayer2Score.setText(gameManneger.getP2().getName()+"is score is: "+gameManneger.getP2().getCore());
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

