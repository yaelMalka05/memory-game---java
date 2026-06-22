package ng;
import java.awt.Color;
	import java.awt.GridLayout;
	import javax.swing.JPanel;
	import javax.swing.BorderFactory;

	

	

	public class GamePanel extends JPanel {
	    public CardButton[] arr;
	    private GameStatusPanel gs;
	    public GameOn go;
	    
	    public GamePanel(GameOn game, GameStatusPanel gamestatus) {
	        this.go = game;
	        this.gs = gamestatus;
	        this.setBackground(new Color(245, 235, 255)); // סגול עדין מאוד לרקע
	        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	        
	        this.go.setUpdateCallback(() -> {
	            BoardRefresh();
	            gs.Refresh();
	        });
	        
	        restartBoard(); 
	    }
	    
	    public void BoardRefresh() {
	        for(int i = 0; i < this.arr.length; i++) {
	            this.arr[i].Refresh();
	        }
	        revalidate();
	        repaint();
	    }
	    
	    public void restartBoard() {
	        this.removeAll(); 
	        Card[] cards = go.getB().getCards(); 
	        this.arr = new CardButton[cards.length];
	        
	        // קובע גודל גריד לפי כמות הקלפים: 16 קלפים = 4x4, 24 קלפים = 4x6
	        int rows = 4;
	        int cols = cards.length / rows;
	        this.setLayout(new GridLayout(rows, cols, 10, 10));
	        
	        for (int i = 0; i < this.arr.length; i++) {
	            this.arr[i] = new CardButton(cards[i]);
	            CardButton btn = this.arr[i];
	            
	            btn.addActionListener(e -> {
	                go.chooseCard(btn.GetCard());
	            });
	            this.add(btn); 
	        }
	        BoardRefresh(); 
	    }
	}

