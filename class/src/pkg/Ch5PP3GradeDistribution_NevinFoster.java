package pkg;

import java.util.Scanner;

/**
 * 
 * @Author Nevin Foster
 * 
 * @Class CSC110: 11384
 * @Title Chapter 5 practice problem 3, Grade Distribution
 * @Description made to test skills as a programmer
 */
public class Ch5PP3GradeDistribution_NevinFoster
{
	/*
	 * Class which handles distribution
	 */
	public static class StudentScore
	{
		private String name;

		// Student needs a name
		public StudentScore(String name)
		{
			this.name = name;
		}
		
		/*
		 * Auto fill everything with zeros
		 */
		private double q1 = 0;
		private double mid = 0;
		private double q2 = 0;
		private double fin = 0;
		
		private char grade = 'f';
		private double finalGrade = 0; 

		/*
		 *  Getters and setters that can be used if this 
		 *  class is to be implemented somewhere else
		 */
		public double getQ1()
		{
			return q1;
		}

		public void setQ1(double q1)
		{
			this.q1 = q1;
			updateGrade();
		}

		public double getMid()
		{
			return mid;
		}

		public void setMid(double mid)
		{
			this.mid = mid;
			updateGrade();
		}

		public double getQ2()
		{
			return q2;
		}

		public void setQ2(double q2)
		{
			this.q2 = q2;
			updateGrade();
		}

		public double getFin()
		{
			return fin;
		}

		public void setFin(double fin)
		{
			this.fin = fin;
			updateGrade();
		}

		public char getGrade()
		{
			return grade;
		}

		public double getFinalGrade()
		{
			return finalGrade;
		}
		
		/*
		 * The methods to handle getting and setting lager amounts of data
		 */

		public void setScores(double q1, double q2, double mid, double fin)
		{
			this.q1 = q1;
			this.q2 = q2;
			this.mid = mid;
			this.fin = fin;
			
			updateGrade();
		}

		private void updateGrade()
		{
			double quiz = (q1 + q2) / 2;
			finalGrade =
					fin * .50 +
					mid * .25 +
					quiz* .25;
			if(finalGrade >= 90)
				grade = 'a';
			else if(finalGrade >= 80)
				grade = 'b';
			else if(finalGrade >= 70)
				grade = 'c';
			else if(finalGrade >= 60)
				grade = 'd';
			else
				grade = 'f';
		}
		
		public String getRecord()
		{
			//Compose everything to a single string
			String s = "";
			String sep = System.lineSeparator(); // in case different software is used
			
			s += name + "'s Record:" + sep;
			s += "	Quiz One: " + q1 + sep;
			s += "	Quiz Two: " + q2 + sep;
			s += "	Midterm: " + mid + sep;
			s += "	Final Exam: " + fin + sep;
			
			s += "	Grade: " + grade + sep;
			s += "	Grade Percent: " + finalGrade + sep;
			
			return s;
		}
	}
	
	
	/*
	 * Example of implementation
	 */
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
				
		while(true)
		{
			System.out.println("Would you like to add a student? ('y' or 'n')");
			if(s.next().matches("n"))
				break;
			
			System.out.println("Enter name");
			StudentScore student = new StudentScore(s.next());
			
			System.out.println("Enter quiz one");
			double q1 = s.nextDouble();
			System.out.println("Enter quiz two");
			double q2 = s.nextDouble();
			System.out.println("Enter midterm");
			double mid = s.nextDouble();
			System.out.println("Enter final");
			double fin = s.nextDouble();
			
			student.setScores(q1, q2, mid, fin);
			
			System.out.println(student.getRecord());
		}
		System.out.println("Thank you for your time");
		s.close();
	}
}
