package test02;
class AdditionOperation extends BinaryOperation{//�ӷ���ʽ����
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