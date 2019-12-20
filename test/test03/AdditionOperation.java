package test03;
public class AdditionOperation extends BinaryOperator {
	public AdditionOperation() {
		generateBinaryOperator('+');
	}
	int calculate(int left, int right) {
		return left + right;
	}
	boolean check(int results) {
		return results <= UPPER;
	}
}