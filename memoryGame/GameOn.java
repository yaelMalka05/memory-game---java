package ng;
import javax.swing.Timer;

public class GameOn {
    public Board b;
    public Player p1;
    public Player p2;
    public int current;
    public Card card1;
    public Card card2;
    public int currentLevel = 1;
    
    private Runnable updateCallback;
    private Runnable gameOverCallback;

    // בנאי של המחלקה - השם חייב להיות תואם בדיוק לשם המחלקה
    public GameOn(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.current = 1;
        this.b = new Board(currentLevel);
        this.card1 = null;
        this.card2 = null;
    }
    
    public void setUpdateCallback(Runnable callback) { 
        this.updateCallback = callback; 
    }
    
    public void setGameOverCallback(Runnable callback) { 
        this.gameOverCallback = callback; 
    }

    public void chooseCard(Card card) {
        if (card.isFound() || card.isOpen() || (card1 != null && card2 != null)) return;

        if (this.card1 == null) {
            this.card1 = card;
            card1.openCard();
            if (updateCallback != null) updateCallback.run();
        } else {
            this.card2 = card;
            card2.openCard();
            if (updateCallback != null) updateCallback.run();

            if (card1.equalsCards(card2)) {
                if (current == 1) p1.addScore(1);
                else p2.addScore(1);
                
                card1 = null;
                card2 = null;
                if (updateCallback != null) updateCallback.run();
                
                if (b.isFinished()) {
                    if(gameOverCallback != null) gameOverCallback.run();
                }
            } else {
                Card temp1 = card1;
                Card temp2 = card2;
                
                Timer t = new Timer(1500, e -> {
                    temp1.closeCard();
                    temp2.closeCard();
                    card1 = null;
                    card2 = null;
                    changeTurn();
                    if (updateCallback != null) updateCallback.run();
                });
                t.setRepeats(false);
                t.start();
            }
        }
    }
    
    public void changeTurn() {
        if (this.current == 1) this.current = 2;
        else this.current = 1;
    }
    
    public void restartGame(int level) {
        this.currentLevel = level;
        this.b = new Board(level);
        this.p1.setCore(0);
        this.p2.setCore(0);
        this.current = 1;
        this.card1 = null;
        this.card2 = null;
    }
    
    public void setPlayers(String n1, String n2) {
        this.p1.setName(n1);
        this.p2.setName(n2);
    }

    public Board getB() { return b; }
    public Player getP1() { return p1; }
    public Player getP2() { return p2; }
    public int getCurrent() { return current; }
}