package test02;
class SubstractOperation extends BinaryOperation{//������ʽ����
	SubstractOperation(){
		generateBinaryOperation('-');
	}
	public boolean checkingCalculation(int anInteger) {
		return anInteger>=LOWER;
	}
	int calculate(int left,int right) {
		return left-right;
	}
}