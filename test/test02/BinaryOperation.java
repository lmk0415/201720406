package test02;
import java.util.Random;
abstract class BinaryOperation {//算式抽象类
		static final int UPPER=100;
		static final int LOWER=0;
		private int left_operand=0,right_operand=0;
		private char operator='+';
		private int value=0;
		//调用了两个抽象方法，生成合法的算式成分，调用者负责输入合法的参数
		protected void generateBinaryOperation(char anOperator) {
			int left,right,result;
			Random random=new Random();
			left=random.nextInt(UPPER+1);
			do {
				right=random.nextInt(UPPER+1);
				result=calculate(left,right);
			}while(!(checkingCalculation(result)));
			left_operand=left;
			right_operand=right;
			operator=anOperator;
			value=result;
		}
		//子类必须实现的两个方法
		abstract boolean checkingCalculation(int anInteger);
		abstract int calculate(int left,int right);
		public int getLeftOperand() {
			return left_operand;
		}
		public int getRightOperand() {
			return right_operand;
		}
		public char getOperator() {
			return operator;
		}
		public int getResult() {
			return value;
		}
		public boolean equals(BinaryOperation anOperation) {//要使用getOperator()
			return left_operand==anOperation.getLeftOperand() &
				   right_operand==anOperation.getRightOperand() &
				   operator==anOperation.getOperator();
		}
		public String toString() {
			String a=""+left_operand+operator+right_operand+"="+value+"";
			return a;
		}
	}