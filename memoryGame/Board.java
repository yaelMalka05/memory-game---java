package memoryGame;

import java.util.Random;

public class Board {

	
	public Card arr[];
	
	
	public Board() {
		this.arr = new Card [16];
//		this.arr[0] = 1;
		int [] a= {1,2,3,4,5,6,7,8};
		int j=0;
		for(int i=0; i<a.length; i++) {
			this.arr[j]=new Card(a[i]);
			this.arr[j+1]=new Card(a[i]);
			j+=2;
		}
	}
	
	
	public Card[] getCards() {
		return  this.arr;
	}
	
	
	//ערבוב
	public void ShufflingCards() {
		//
		int index, x;
		Random random = new Random();
		
		for(int i=0; i<this.arr.length; i++) {
			index = random.nextInt(16);
			x = this.arr[i].getValue();
			this.arr[i].setValue(this.arr[index].getValue());
			this.arr[index].setValue(x);
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
