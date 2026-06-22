package ng;
import javax.swing.ImageIcon;

public class Card {
    public ImageIcon value;
    public boolean isOpen;
    public boolean isFound;
    
    public Card(ImageIcon v) {
        this.value = v;
        this.isOpen = false;
        this.isFound = false;
    }
    
    public ImageIcon getValue() { return value; }
    public void setValue(ImageIcon value) { this.value = value; }
    
    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean isOpen) { this.isOpen = isOpen; }
    
    public boolean isFound() { return isFound; }
    public void setFound(boolean isFound) { this.isFound = isFound; }
    
    public void openCard() { this.isOpen = true; }
    public void closeCard() { this.isOpen = false; }
    
    public boolean equalsCards(Card other) {
        if(this.value == other.value) {
            this.isFound = true;
            other.setFound(true);
            return true;
        }
        return false;
    }
}