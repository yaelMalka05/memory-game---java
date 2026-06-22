package ng;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardButton extends JButton {

    public Card card;
    //  משתנה חדש שישמור את תמונת הגב המוקטנת כדי שלא נצטרך לעבד אותה כל רענון
    private ImageIcon cardBackIcon;
    
    public CardButton(Card card) {
        this.card = card;
        
        //  הפתרון: טעינת תמונת הגב והקטנתה לגודל 100x100 (בדיוק כמו שעשינו לחזית)
        ImageIcon originalIcon = new ImageIcon("pic/b.jpg");
        Image image = originalIcon.getImage();
        Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.cardBackIcon = new ImageIcon(resizedImage);
        
        // הגדרת תמונת ברירת המחדל ההתחלתית
        this.setIcon(this.cardBackIcon);
    }
    
    public Card GetCard() {
        return this.card;
    }
    
    public void Refresh() {
        // אם הכרטיס כבר נמצא או שהוא פתוח כרגע - נציג את החזית (שהוקטנה ב-Board)
        if (this.card.isFound || this.card.isOpen) {
            this.setIcon(this.card.getValue());
        } 
        // אם הכרטיס סגור - נציג את תמונת הגב המוקטנת והמתאימה
        else {
            this.setIcon(this.cardBackIcon);
        }
    }
}