package test03;

import java.util.Random;

public abstract class BinaryOperator<GenerateEquation> {
		static final int UPPER = 100;
		static final int LOWER = 0;
		private int leftOperator;
		private int rightOperator;
		private char operator;
		private int result;
		public int getLeftOperator() {
			return leftOperator;
		}
		public int getRightOperator() {
			return rightOperator;
		}
		public char getOperator() {
			return operator;
		}
		public int getResult() {
			return result;
		}
		public void generateBinaryOperator(char operators){
			int left, right, results;
			Random random = new Random();
			left = random.nextInt(UPPER + 1);
			do{
				right = random.nextInt(UPPER + 1);
				results = calculate(left, right);
			}while(!(check(results)));
			leftOperator = left;
			rightOperator = right;
			result = results;
			operator = operators;
			
		}
		public boolean IsEquals(GenerateEquation ge){
			return (leftOperator == getLeftOperator() && rightOperator == getRightOperator() && operator == getOperator()) || (leftOperator == getRightOperator() && rightOperator == getRightOperator() && operator == getOperator());
		}
		abstract int calculate(int left, int right);
		abstract boolean check(int results);
	}