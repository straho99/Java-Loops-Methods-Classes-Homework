package homework;

import java.util.Scanner;

public class ThreeLetterWords {
	
	 static int sequenceSize = 3;
     static int n;
     static int[] numbers;
     static int combinationCount = 0;
     static char[] someWords;
	
	public static void main(String[] args) {
		//Problem 02:
		Scanner input=new Scanner(System.in);
		String inputCharacters=input.nextLine();
		someWords=new char[inputCharacters.length()];
		n=inputCharacters.length();
		for (int i = 0; i < someWords.length; i++) {
			someWords[i]=inputCharacters.charAt(i);
		}
		numbers = new int[sequenceSize];
        Sequences(0);
	}

	static void Sequences(int currentNumber)
    {
        int i;
        if (currentNumber == sequenceSize)
        {
            PrintSequence();
            return;
        }
        for (i = 1; i <= n; i++)
        {
            if (currentNumber>0)
            {
                //if (i<=numbers[currentNumber-1])
                //{
                //    continue;
                //}
            }
            numbers[currentNumber] = i;
            Sequences(currentNumber + 1);
        }
    }
	
	static void PrintSequence()
    {
        combinationCount++;
        
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.printf("%s ", someWords[numbers[i]-1]);
        }
        System.out.println();
    }
}
