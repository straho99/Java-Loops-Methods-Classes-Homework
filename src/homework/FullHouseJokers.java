package homework;

public class FullHouseJokers {

	public static void main(String[] args) {
		// Problem 04:
		//N.B. This solution produces the same amount of full houses as is shown in the homework: 119 808,
		//but the combination of 5 jokers is repeated for each combination of 'normal' five cards.
		//the question is - is this correct behavior or the hand '*****' has to be counted only once???
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
		//first, we invoke the main method of the 'test' class with the sole intension of creating all combinations of jokers.
		//a combination is a string array that looks something like this: [- , - , *, *, -].
		//Asterisk shows where the jokers are located.
		//"-" stands for a normal card. 
		//(for a hand of 5 cards there are exactly 32 combinations). we do it only once because they do not change.
		test.main(args);
		
		//Generate all combinations with lots and lots of nested loops:
		String fullHouse="";
		int fullHouseCount=0;
		//the first 4 loops generate the combinations for the 3 cards of the first face:
		for (int firstFace = 0; firstFace < 13; firstFace++) {
			for (int i = 0; i < 2; i++) {
				for (int j = i+1; j < 3; j++) {
					for (int j2 = j+1; j2 < 4; j2++) {
						//with the next 3 loops we generate combinations for the 2 cards of the second face
						for (int secondFace = 0; secondFace < 13; secondFace++) {
							if (firstFace==secondFace) { //but first let's make sure that firstFace and secondFace are different:
								continue;
							}
							for (int k = 0; k < 3; k++) {
								for (int m = k+1; m < 4; m++) {
									fullHouse=faces[firstFace] +  suits[i] + " " + faces[firstFace] + suits[j] 
											+ " " + faces[firstFace] + suits[j2] + " " + faces[secondFace] + suits[k] 
										+ " " + faces[secondFace] +  suits[m];
									String[] cards=fullHouse.split(" ");
									for (String[] combination : test.combinations) {
										for (int l = 0; l < combination.length; l++) {
											if (combination[l].equals("-")) {
												combination[l]=cards[l];
											}
										}
										PrintStringArray(combination);
										fullHouseCount++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.printf("%d full houses", fullHouseCount);
	}

	private static void PrintStringArray(String[] combination) {
		// TODO Auto-generated method stub
		for (int i = 0; i < combination.length; i++) {
			System.out.print(combination[i] + " ");
		}
		System.out.println();
	}
}
