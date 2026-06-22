package memoryGame;

import javax.swing.JButton;

public class CardButton extends JButton{

	public Card card;
	
	public CardButton(Card card) {
		this.card = card;
		this.setText("?");
		
	}
	
	
	
	public Card GetCard() {
		return this.card;
	}
	
	public void Refresh() {
//		if(this.card.isFound)
//			this.setText(""+this.card.getValue()+"");
//		if(this.card.isOpen)
//			this.setText(""+this.card.getValue()+"");
//		if(!this.card.isFound)
//			this.setText("?");
//		if(!this.card.isOpen)
//			this.setText("?");
//		this.addActionListener(e ->{
//			this.card.openCard();
//			this.card.
//		});
		if (this.card.isFound || this.card.isOpen) {
	        this.setText(String.valueOf(this.card.getValue()));
	    } else {
	        this.setText("?");
	    }
		
	}

	
}

