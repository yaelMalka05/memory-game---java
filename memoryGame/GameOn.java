package memoryGame;

public class GameOn {
	
	public Board b;
	public Player p1;
	public Player p2;
	public int current;
	public Card card1;
	public Card card2;

	
	public GameOn(Player p1 , Player p2 ) {
		this.p1= p1;
		this.p2= p2;
		b = new Board();
		
		this.card1 = null;
		this.card2 = null;
		
		this.current = 1;
	}
	
//	public Board getBoard() {
//		return this.b;
//	}
	
	public void chooseCard(Card card) {
		if(this.card1==null)
		{
			this.card1=card;
			card1.openCard();
		}	
		else
		{
			this.card2=card;
			card2.openCard();
			if(card1.equals(card2))
			{
				if(current==1)
					p1.addScore(1);
				else
					p2.addScore(1);
			}
			else
			{
				card1.closeCard();
				card2.closeCard();
			}
			card1=null;
			card2=null;
		}
	}
	
	
	public void changeTurn() {
		if(this.current == 1) {
			this.current = 2;
			System.out.println("it is" + this.p2.getName() + "turn");
		}
		if(this.current == 2) {
			this.current = 1;
			System.out.println("it is" + this.p1.getName() + "turn");
		}
	}
	
	public Board getB() {
		return b;
	}

	public void setB(Board b) {
		this.b = b;
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public void endGame() {
		if(!this.victory())
		System.out.println("game over");
//		else {
//			b = new Board();
//			p1 = new Player();
//			p2 = new Player();
//			current = 1;
//		}
	}
	
	
	public boolean victory() {
		if(this.p1.getCore() > this.p2.getCore()) {
			System.out.println(this.p1.getName() +"is the winner!");
			return true;
		}
		if(this.p2.getCore() > this.p1.getCore()) {
			System.out.println(this.p2.getName() +"is the winner!");
			return true;
		}
		if( this.p2.getCore() == this.p1.getCore() ) {
			System.out.println("teko, both of you did not win, what a shame!");
			return true;
		}
		return false;
	}
	
	
	
	
}
