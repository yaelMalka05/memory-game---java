package memoryGame;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Board {

	
	public Card arrC[];
//	public ImageIcon  arrM[];
	
//	public Board() {
//		this.arr = new Card [16];
////		this.arr[0] = 1;
//		int [] a= {1,2,3,4,5,6,7,8};
//		int j=0;
//		for(int i=0; i<a.length; i++) {
//			this.arr[j]=new Card(a[i]);
//			this.arr[j+1]=new Card(a[i]);
//			j+=2;
//		}
//		ShufflingCards();
//	}
	public ImageIcon Convert(ImageIcon icon) {
		Image image =   icon.getImage();
		Image resizedImage =   image.getScaledInstance(100, 100 , Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		return new ImageIcon(resizedImage);
	}
	public Board() {
		this.arrC = new Card [16];
//		this.arrM = new ImageIcon  [16];
//		this.arr[0] = 1;
		ImageIcon [] a= {new ImageIcon("pic/1.jpg"),new ImageIcon("pic/2.jpg"),
				new ImageIcon("pic/3.jpg"), new ImageIcon("pic/4.jpg"), new ImageIcon("pic/5.jpg"),
				new ImageIcon("pic/6.JPG"), new ImageIcon("pic/7.jpg"),new ImageIcon("pic/8.jpg")};
		int j=0;
		for(int i=0; i<a.length; i++) {
			this.arrC[j]=new Card(a[i]);
			this.arrC[j+1]=new Card(a[i]);
			j+=2;
		}
		ShufflingCards();
	}
	
	
	public Card[] getCards() {
		return  this.arrC;
	}
	
	
	//ערבוב
	public void ShufflingCards() {
		//
		int index, x;
		Random random = new Random();
		
		for(int i=0; i<this.arrC.length; i++) {
			index = random.nextInt(16);
//			x = this.arr[i].getValue();
//			this.arr[i].setValue(this.arr[index].getValue());
//			this.arr[index].setValue(x);
			Card temp = arrC[i];
			arrC[i] = arrC[index];
			arrC[index] = temp;
		}
	}
	
	public boolean isFinished() {
		for(int i=0; i<this.arrC.length; i++) {
			if(!arrC[i].isOpen())
				return false;
		}
		return true;
	}
	
	
	
	
	
	
}
