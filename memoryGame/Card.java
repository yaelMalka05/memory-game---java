package memoryGame;

public class Card {
	
	public int value;
	public boolean isOpen;
	public boolean isFound;
	
	
	public Card(int v) {
		this.value = v;
		this.isOpen = false;
		this.isFound = false;
	}
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public boolean isFound() {
		return isFound;
	}
	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}
	
	
	public void openCard() {
		this.isOpen = true;
	}

	public void closeCard() {
		this.isOpen = false;
	}
	
	
	public boolean equalsCards(Card other) {
		if(this.value == other.value) {
			this.isFound = true;
			other.setFound(true);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
}
