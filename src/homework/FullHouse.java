package homework;

public class FullHouse {

	public static void main(String[] args) {
		// Problem 03:
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
		String fullHouse="";
		//Generate all combinations with lots and lots of nested loops:
		int fullHouseCount=0;
		//the first 4 loops generate the combinations for the 3 cards of the first face:
		for (int firstFace = 0; firstFace < 13; firstFace++) {
			for (int i = 0; i < 2; i++) {
				for (int j = i+1; j < 3; j++) {
					for (int j2 = j+1; j2 < 4; j2++) {
						//with the next 3 loops we generate combinations for the 2 cards of the second face
						for (int secondFace = 0; secondFace < 13; secondFace++) {
							if (firstFace==secondFace) {
								continue; //must be different faces...
							}
							
							for (int k = 0; k < 3; k++) {
								for (int m = k+1; m < 4; m++) {
									fullHouse=faces[firstFace] +  suits[i] + " " + faces[firstFace] + suits[j] 
											+ " " + faces[firstFace] + suits[j2] + " " + faces[secondFace] + suits[k] 
										+ " " + faces[secondFace] +  suits[m];
									fullHouseCount++;
									System.out.println(fullHouse);
								}
							}
						}
					}
				}
			}
		}
		System.out.printf("%d full houses", fullHouseCount);
	}

}
