//Gerard Patrick Gibbons, Junior Computer Science
/*
 * This program will calculate a students grade
 * given the scores and weights by user input.
 * 
 */



import java.util.Scanner;

import java.lang.Math;

public class Grades {

	public static void main(String args[])
	{
		//variables
			double homeworkWeight;
			double homework;
			double examWeight;
			double exam;
			double examtwoWeight;
			double examtwo;
			double homeworkAvg;
			double examCurve;
			double examtwoCurve;
			double totalScore;
			
			int homeworkAmount;
			int labs;
			int labsLate;
			
			System.out.print("Homework weight: ");
			Scanner userIn = new Scanner(System.in);
			homeworkWeight = userIn.nextDouble();
			
			System.out.print("Exam Weight: ");
			examWeight = userIn.nextDouble();
			
			System.out.print("Exam 2 Weight: ");
			examtwoWeight = userIn.nextDouble();
			
			System.out.println("Using weights " + homeworkWeight + " " + examWeight + " " + examtwoWeight);
			
			System.out.print("Amount of homework assignments: ");
			homeworkAmount = userIn.nextInt();
			
			/*
			 * I was confused about the instructions 
			 * "If a user enters a negative number or zero for the number of assignments,
			 *  the student should get full credit for the homework grade"
			 *  hopefully this is what it meant.
			 */
			if(homeworkAmount <= 0)
				homeworkAmount = 10;
			
			System.out.print("Average homework grade: ");
			homeworkAvg = userIn.nextDouble();
			
			//checking to make sure inputs are valid.
			if(homeworkAmount <=0)
				homeworkAvg = 10;
			if(homeworkAvg < 0)
				homeworkAvg = 0;
			if(homeworkAvg > 10)
				homeworkAvg = 10;
			
			System.out.print("Labs attended: ");
			labs = userIn.nextInt();
			
			System.out.print("Labs late days used: ");
			labsLate = userIn.nextInt();
			
			homework = calculateHomeworkweighted(homeworkWeight, homeworkAvg, homeworkAmount, labs, labsLate);
			calculateHomeworkTotal(homeworkWeight, homeworkAvg, homeworkAmount, labs, labsLate);
			
			System.out.println("Weighted score: " + Math.floor(homework * 100) / 100);
			
			System.out.println("Exam 1: \n");
			System.out.print("Score: " );
			exam = userIn.nextDouble();
			
			//checking to make sure inputs are valid.
			if(exam > 100)
				exam = 100;
			if(exam < 0)
				exam = 0;
			
			System.out.print("Curve: ");
			examCurve = userIn.nextDouble();
			
			calculateExamTotal(exam, examCurve);
			
			exam = calculateExamWeighted(exam, examWeight, examCurve);
			System.out.println("Weighted Score: " + exam);
			
			System.out.println("Exam 2: \n");
			System.out.print("Exam 2 Score: ");
			examtwo = userIn.nextDouble();
			
			//checking to make sure inputs are valid.
			if(examtwo > 100)
				examtwo = 100;
			if(examtwo < 0)
				examtwo = 0;
			
			System.out.print("Exam 2 Curve: ");
			examtwoCurve = userIn.nextDouble();
			
			calculateExamTotal(examtwo, examtwoCurve);
			examtwo = calculateExamWeighted(examtwo, examtwoWeight, examtwoCurve);
			System.out.println("Weighted Score: " + examtwo);
			
			totalScore = examtwo + exam + homework;
			System.out.println("Course Grade: " + Math.floor(totalScore * 100) / 100);
			userIn.close();
	
	}
	
//Calculates and prints homeworks total score.
	public static void calculateHomeworkTotal(double hmwWght, double hmwAvg, int hmwAmt, int labs, int latelabs)
	{
		double score = 0;
		double total = 0;
		
		score = ((hmwAvg * 10) + (labs * 4) ) ;
		total = ((hmwAmt * 10) + (hmwAmt * 4));
		
		
		System.out.println("Total points: " + score + " / " + total);
	}
	
//Calculates and RETURNS the weighted score of all homeworks
public static double calculateHomeworkweighted(double hmwWght, double hmwAvg, int hmwAmt, int labs, int latelabs )
{
	double homeworkGrade;
	
	homeworkGrade = ((hmwWght) * ((hmwAvg * hmwAmt) + (labs * 4))   /   ((10 * hmwAmt	) + (4 * hmwAmt)));
	if(latelabs >= (hmwAmt / 2))
	{
		homeworkGrade =- homeworkGrade * .1;
	}
	if(latelabs <=0)
	{
		homeworkGrade =+ .5;
	}
	return homeworkGrade;
}

//calculates and prints the total score for that exam.
public static void calculateExamTotal(double exm, double exmCrve)
{
	double sum;
	sum = exm+exmCrve;
	if(sum > 100)
		sum = 100;
	
	System.out.println("Total: " + sum);
}

//calculates and PRINTS the weighted score for that exam.
public static double calculateExamWeighted(double exm, double exmWght, double exmCrve)
{
	double weightedScore;
	exm+=exmCrve;
	if(exm>100)
		exm = 100;
	
	weightedScore = (exm * (exmWght / 100)) ;
	return weightedScore;
}
}
