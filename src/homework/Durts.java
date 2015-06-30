package homework;

import java.util.Scanner;

public class Durts {

	public static void main(String[] args) {
		// Problem 13:
		Scanner input=new Scanner(System.in);
		Durts parent = new Durts();
		//read the center:
		IntPoint center = parent.new IntPoint(input.nextInt(), input.nextInt());
		input.nextLine();
		//read the size:
		int size = input.nextInt();
		input.nextLine();
		//read the number of points:
		int pointsCount=input.nextInt();
		input.nextLine();
		
		//read the individual points, hold them into array:
		IntPoint[] durts = new IntPoint[pointsCount];
		for (int i = 0; i < pointsCount; i++) {
			durts[i]=parent.new IntPoint(input.nextInt(), input.nextInt());
		}
		
		//go through all points and check if they are inside the cross:
		for (IntPoint point : durts) {
			if (IsInsideRectangle(point, center, (double)size, (double)(size / 2)) || 
					IsInsideRectangle(point, center, (double)(size / 2), (double)size) ){
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}

	public static boolean IsInsideRectangle(IntPoint point, IntPoint rectangleCenter,
			double rectangleWidth, double rectangleHeight) {
		boolean result = false;
		if (point.getX() >= (double) rectangleCenter.getX() - rectangleWidth
				&& point.getX() <= (double) rectangleCenter.getX() + rectangleWidth
				&& point.getY() >= (double) rectangleCenter.getY() - rectangleHeight
				&& point.getY() <= (double) rectangleCenter.getY() + rectangleHeight) {
			result=true;
			return result;
		}

		return result;
	}

	public class IntPoint {
		private int x;
		private int y;

		// these are the constructors:
		public IntPoint(int X, int Y) {
			this.x = X;
			this.y = Y;
		}

		public IntPoint() {
			this.x = 0;
			this.y = 0;
		}

		// these are the getters and setters for the two points:
		public int getX() {
			return this.x;
		}

		public void setX(int X) {
			this.x = X;
		}

		public int getY() {
			return this.y;
		}

		public void setY(int Y) {
			this.y = Y;
		}
	}
}
