package memoryGame;

import javax.swing.JPanel;

public class EndPanel extends JPanel{

	
	
	public GameOn go;
	
	
	
	public EndPanel(GameOn game , GameStatusPanel gamestatus) {
		this.go = game;
		this.go.setUpdateCallback(() -> {
//	        BoardRefresh();
	        gamestatus.Refresh();
	    });
	}
	
	
	
	
	public boolean end() {
	
		if( this.go.victory()) {
			this.go.endGame();
			return true;
		}
//		this.go.endGame();
//	
//		this.go.restartGame();
//	
//		this.go.victory();
		return false;
	}
	
	
	
	
	
}
