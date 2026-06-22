package ng;


import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Board {
    public Card arrC[];
    
    // הפונקציה שלך שמקטינה את התמונות!
    public ImageIcon Convert(ImageIcon icon) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    
    public Board(int level) {
        int totalCards = (level == 1) ? 16 : 24;
        this.arrC = new Card[totalCards];
        
        ImageIcon[] a = {
            new ImageIcon("pic/1.jpg"), new ImageIcon("pic/2.jpg"),
            new ImageIcon("pic/3.jpg"), new ImageIcon("pic/4.jpg"), 
            new ImageIcon("pic/5.jpg"), new ImageIcon("pic/6.JPG"), 
            new ImageIcon("pic/7.jpg"), new ImageIcon("pic/8.jpg")
        };
        
        int j = 0;
        int pairs = totalCards / 2;
        
        for(int i = 0; i < pairs; i++) {
            ImageIcon resizedIcon = Convert(a[i % a.length]); // שימוש בפונקציית ההקטנה
            this.arrC[j] = new Card(resizedIcon);
            this.arrC[j+1] = new Card(resizedIcon);
            j += 2;
        }
        ShufflingCards();
    }
    
    public Card[] getCards() { return this.arrC; }
    
    public void ShufflingCards() {
        Random random = new Random();
        for(int i = 0; i < this.arrC.length; i++) {
            int index = random.nextInt(this.arrC.length);
            Card temp = arrC[i];
            arrC[i] = arrC[index];
            arrC[index] = temp;
        }
    }
    
    public boolean isFinished() {
        for(int i = 0; i < this.arrC.length; i++) {
            if(!arrC[i].isOpen())
                return false;
        }
        return true;
    }
}