package test02;
class AdditionOperation extends BinaryOperation{//加法算式子类
	AdditionOperation(){
		generateBinaryOperation('+');
	}
	public boolean checkingCalculation(int anInteger) {
		return anInteger<=UPPER;
	}
	int calculate(int left,int right) {
		return left+right;
	}
}