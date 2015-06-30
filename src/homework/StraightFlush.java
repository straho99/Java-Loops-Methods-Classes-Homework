package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StraightFlush {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// get the hand and extract all cards in a string array:
		String input = scanner.nextLine();
		String[] cards = input.split("\\W+");

		// create one list per suite and add all cards that have the same suite:
		ArrayList<Integer> clubs = new ArrayList();
		ArrayList<Integer> diamonds = new ArrayList();
		ArrayList<Integer> hearts = new ArrayList();
		ArrayList<Integer> spades = new ArrayList();
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].charAt(cards[i].length() - 1) == 'C') {
				clubs.add(getCardFace(cards[i]));
			} else if (cards[i].charAt(cards[i].length() - 1) == 'D') {
				diamonds.add(getCardFace(cards[i]));
			} else if (cards[i].charAt(cards[i].length() - 1) == 'H') {
				hearts.add(getCardFace(cards[i]));
			} else if (cards[i].charAt(cards[i].length() - 1) == 'S') {
				spades.add(getCardFace(cards[i]));
			}
		}
		// now, from the lists create four sorted arrays:
		Object[] sortedClubs = clubs.toArray();
		Arrays.sort(sortedClubs);

		Object[] sortedDiamonds = diamonds.toArray();
		Arrays.sort(sortedDiamonds);

		Object[] sortedHearts = hearts.toArray();
		Arrays.sort(sortedHearts);

		Object[] sortedSpades = spades.toArray();
		Arrays.sort(sortedSpades);
		
//		for (int i = 0; i < sortedHearts.length; i++) {
//			System.out.print(sortedHearts[i] + ", ");
//		}
//		System.out.println();

		// and finally, for each array, print all combinations of five cards
		// faces that are sequential:
		int countOfFlushes=0;
		// Clubs:
		for (int i = 0; i <= sortedClubs.length - 5; i++) {
			if (sortedClubs.length < 5) {
				break;
			}
			if (areSequence((int) sortedClubs[i], (int) sortedClubs[i + 1],
					(int) sortedClubs[i + 2], (int) sortedClubs[i + 3],
					(int) sortedClubs[i + 4])) {
				printSequence('C', (int) sortedClubs[i],
						(int) sortedClubs[i + 1], (int) sortedClubs[i + 2],
						(int) sortedClubs[i + 3], (int) sortedClubs[i + 4]);
				countOfFlushes++;
			}
		}
		// Diamonds:
		for (int i = 0; i <= sortedDiamonds.length - 5; i++) {
			if (sortedDiamonds.length < 5) {
				break;
			}
			if (areSequence((int) sortedDiamonds[i],
					(int) sortedDiamonds[i + 1], (int) sortedDiamonds[i + 2],
					(int) sortedDiamonds[i + 3], (int) sortedDiamonds[i + 4])) {
				printSequence('D', (int) sortedDiamonds[i],
						(int) sortedDiamonds[i + 1],
						(int) sortedDiamonds[i + 2],
						(int) sortedDiamonds[i + 3],
						(int) sortedDiamonds[i + 4]);
				countOfFlushes++;
			}
		}
		// Hearts:
				for (int i = 0; i <= sortedHearts.length - 5; i++) {
					if (sortedHearts.length < 5) {
						break;
					}
					if (areSequence((int) sortedHearts[i],
							(int) sortedHearts[i + 1], (int) sortedHearts[i + 2],
							(int) sortedHearts[i + 3], (int) sortedHearts[i + 4])) {
						printSequence('H', (int) sortedHearts[i],
								(int) sortedHearts[i + 1],
								(int) sortedHearts[i + 2],
								(int) sortedHearts[i + 3],
								(int) sortedHearts[i + 4]);
						countOfFlushes++;
					}
				}
		// Spades:
		for (int i = 0; i <= sortedSpades.length - 5; i++) {
			if (sortedSpades.length < 5) {
				break;
			}
			if (areSequence((int) sortedSpades[i],
					(int) sortedSpades[i + 1], (int) sortedSpades[i + 2],
					(int) sortedSpades[i + 3], (int) sortedSpades[i + 4])) {
				printSequence('S', (int) sortedSpades[i],
						(int) sortedSpades[i + 1],
						(int) sortedSpades[i + 2],
						(int) sortedSpades[i + 3],
						(int) sortedSpades[i + 4]);
				countOfFlushes++;
			}
		}
		
		if (countOfFlushes==0) {
			System.out.print("No Straight Flushes");
		}
	}

	public static void printSequence(char suit, int... faces) {
		String output = ("[");
		for (int i = 0; i < faces.length; i++) {
			if (faces[i] == 11) {
				output = output + "J" + suit;
			} else if (faces[i] == 12) {
				output = output + "Q" + suit;
			} else if (faces[i] == 13) {
				output = output + "K" + suit;
			} else if (faces[i] == 14) {
				output = output + "A" + suit;
			} else {
				output = output + faces[i] + suit;
			}
			output = output + ", ";
		}
		output = output.substring(0, output.length() - 2);
		output = output + "]";
		System.out.println(output);

	}

	public static boolean areSequence(int... numbers) {
		boolean result = true;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i + 1] - numbers[i] != 1) {
				return false;
			}
		}
		return result;
	}

	public static int getCardFace(String card) {
		String face = card.substring(0, card.length() - 1);
		if (face.charAt(0) == 'J') {
			return 11;
		} else if (face.charAt(0) == 'Q') {
			return 12;
		} else if (face.charAt(0) == 'K') {
			return 13;
		} else if (face.charAt(0) == 'A') {
			return 14;
		} else if (face.charAt(0) == '1') {
			return 10;
		} else {
			return Integer.parseInt(String.valueOf(face.charAt(0)));
		}
	}
}
