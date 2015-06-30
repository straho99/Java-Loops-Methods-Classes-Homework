package homework;

import java.util.HashSet;
import java.util.Scanner;

public class CognateWords {

	public static void main(String[] args) {
		// Problem 12:
		Scanner input=new Scanner(System.in);
		String text=input.nextLine();
		
		//We split the text using regular expression:
		String[] words=text.split("[\\d \\s \\W]+");
		
//		for (int i = 0; i < words.length; i++) {
//			System.out.println("Element= " + words[i]);
//		}
		
		//Then we put all unique words in a HashSet:
		HashSet<String> setWords=new HashSet();
		for (int i = 0; i < words.length; i++) {
			if (!setWords.contains(words[i])) {
				setWords.add(words[i]);
			}
		}
		//We create one more set that will hold the found combinations:
		HashSet<String> combinations=new HashSet();
		
		//Then we try all combinations of two words and check if they equal any word in the set.
		//If yes, and if the same combination has not been already found, print the combination on the console.
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				//we check that i and j are not equal - we don't want combination of one and the same element.
				if (i==j) {
					continue;
				}
				String combined=words[i] + words[j];
				if (setWords.contains(combined)) {
					if (combinations.contains(combined)) {
						continue;
					}
					else {
						System.out.println(words[i] + "|" + words[j] + "=" + combined);
						combinations.add(combined);
					}
				}
			}
		}
		
		//Finally, if the combinations set is empty, print No:
		if (combinations.size()==0) {
			System.out.println("No");
		}
	}
}
