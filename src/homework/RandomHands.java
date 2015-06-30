package homework;

import java.util.Random;

public class RandomHands {

	public static void main(String[] args) {
		// Problem 6:
		String[] faces=new String[13];
		String[] suits=new String[4];
		suits[0] = "\u2663";
		suits[1] = "\u2666";
		suits[2] = "\u2665";
		suits[3] = "\u2660";
		for (int i = 0; i < 9; i++) {
			faces[i]="" + (i+2);
		}
		faces[9]="J";
		faces[10]="Q";
		faces[11]="P";
		faces[12]="A";
		
		Random rnd=new Random();
		//first loop is for each of the 5 hands:
		String hand="";
		for (int i = 0; i < 5; i++) {
			//2nd loop is for each of the 5 cards:
			for (int j = 0; j < 5; j++) {
				int randomFace=rnd.nextInt(13);
				int randomSuit=rnd.nextInt(4);
				hand=hand + faces[randomFace] + suits[randomSuit] + " ";
			}
			System.out.println(hand);
			hand="";
		}

	}

}
