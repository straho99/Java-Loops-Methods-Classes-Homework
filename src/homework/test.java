package homework;

import java.util.ArrayList;
import java.util.List;

public class test {
	
	static int numberOfLoops=5;
    static int numberOfIterations=2;
    static int[] loops=new int[5];
    static String[] cards;
    public static List<String[]> combinations=new ArrayList<String[]>();
	
	public static void main(String[] args) {
		cards=new String[5];
		for (int i = 0; i < 5; i++) {
			cards[i]="-";
		}
		NestedLoops(0);
		
//		for (String[] combination : combinations) {
//			for (int i = 0; i < combination.length; i++) {
//				System.out.print(combination[i] + " ");
//			}
//			System.out.println();
//		}
	}

	static void NestedLoops(int currentLoop)
    {
        if (currentLoop == numberOfLoops)
        {
            PrintLoops();
            return;
        }
        for (int counter = 1; counter <= numberOfIterations; counter++)
        {
            loops[currentLoop] = counter;
            NestedLoops(currentLoop + 1);
        }
    }
    static void PrintLoops()
    {
        for (int i = 0; i < numberOfLoops; i++)
        {
            if (loops[i]==2) {
				cards[i]="*";
			}
        }
        String[] newHand=new String[5];
        for (int i = 0; i < newHand.length; i++) {
			newHand[i]=cards[i];
		}
//        for (int i = 0; i < cards.length; i++) {
//			System.out.print(cards[i] + " ");
//		}
//        System.out.println();
        combinations.add(newHand);
        initCards();
    }
    
    static void initCards(){
    	for (int i = 0; i < cards.length; i++) {
			cards[i]="-";
		}
    }
}
