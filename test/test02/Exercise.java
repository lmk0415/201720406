package test02;
import java.util.ArrayList;
import java.util.Random;
public class Exercise {//习题类
	private static final short OPERATION_NUMBER=50;
	private ArrayList <BinaryOperation> operationList=new ArrayList <BinaryOperation> ();
	private int current=0;  //用于遍历数据集
	public void generateBinaryExercise(int operationCount) {
		BinaryOperation anOperation;
		while(operationCount>0) {
			do {
				anOperation=generateOperation();
			}while(contains(anOperation));
			operationList.add(anOperation);
			operationCount--;
		}
	}
	private BinaryOperation generateOperation() {
		Random random=new Random();
		int opValue=random.nextInt(2);
		if(opValue==1) {
			return new AdditionOperation();
		}
		return new SubstractOperation();
	}
	public void generateAdditionExercise(int operationCount) {
		BinaryOperation anOperation;
		while(operationCount>0) {
			do {
				anOperation=AdditionOperation();
			}while(contains(anOperation));
			operationList.add(anOperation);
			operationCount--;
		}
	}
	private BinaryOperation AdditionOperation() {
		return new AdditionOperation();
	}
	public void generateSubstractExercise(int operationCount) {
		BinaryOperation anOperation;
		while(operationCount>0) {
			do {
				anOperation=SubstractOperation();
			}while(contains(anOperation));
			operationList.add(anOperation);
			operationCount--;
		}
	}
	private BinaryOperation SubstractOperation() {
		return new SubstractOperation();
	}
	private boolean contains(BinaryOperation anOperation) {
		boolean found=false;
		for(int i=0;i<OPERATION_NUMBER;i++) {
			if(anOperation.equals(operationList)) {
				found=true;
				break;
			}
		}
		return found;
	}
	public boolean hasNext() {//若有元素，返回true,否则返回false
		return current<=operationList.size()-1;
	}
	public BinaryOperation next() {//返回类Exercise的下一个元素
		return operationList.get(current++);
	}
}