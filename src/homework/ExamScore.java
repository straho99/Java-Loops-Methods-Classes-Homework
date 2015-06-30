package homework;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExamScore {

	public static void main(String[] args) {
		// Problem 14:
		Scanner input=new Scanner(System.in);
		input.nextLine();
		input.nextLine();
		input.nextLine();
		
		//Create a TreeMap that will hold the scores in sorted way; and for each score it will hold 
		//another TreeMap with the students' names as keys and grades as values:
		TreeMap<Integer, TreeMap<String, Double>> scores=new TreeMap<Integer, TreeMap<String, Double>>();
		
		//now process the input table with regex. If the score is already inside the dictionary, just 
		//add the student to it. If it is not, add it to the dictionary, then create a new dictionary 
		//to hold the student, add the current student to it; then add this dictionary to the parent dictionary.
		String line=input.nextLine();
		while (line.indexOf('-')<0) {
			String[] student=line.split("\\s*\\|\\s*");
			if (scores.containsKey(Integer.parseInt(student[2]))) {
				TreeMap<String, Double> studentsWithScore=scores.get(Integer.parseInt(student[2]));
				studentsWithScore.put(student[1], Double.parseDouble(student[3]));
				scores.put(Integer.parseInt(student[2]), studentsWithScore);
			}
			else {
				TreeMap<String, Double> studentsWithScore=new TreeMap<String, Double>();
				studentsWithScore.put(student[1], Double.parseDouble(student[3]));
				scores.put(Integer.parseInt(student[2]), studentsWithScore);
			}
			line=input.nextLine();
		}
		
		
		//go through data and print it together with the average grades:
		for(Map.Entry<Integer,TreeMap<String, Double>> score : scores.entrySet()) {
			double scoreAverageGrade=0.0;  
			Integer currentScore = score.getKey();
			  TreeMap<String, Double> studentsWithScore = score.getValue();
			  String output=currentScore + " -> [";
			  for(Map.Entry<String, Double> student : studentsWithScore.entrySet()) {
				  scoreAverageGrade=scoreAverageGrade + student.getValue();
				  output=output + student.getKey() + ", ";
			  }
			  scoreAverageGrade=scoreAverageGrade / studentsWithScore.size();
			  output=output.substring(0, output.length()-2);
			  output=output + "]; avg=" + String.format("%.2f", scoreAverageGrade);
			  System.out.println(output);
		}
	}
	
}
