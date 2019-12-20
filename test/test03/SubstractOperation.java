package test03;
public class SubstractOperation extends BinaryOperator{
	public SubstractOperation() {
		generateBinaryOperator('-');
	}
	int calculate(int left, int right) {
		return left - right;
	}
	boolean check(int results) {
		return results >= LOWER;
	}
}