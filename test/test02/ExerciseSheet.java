package test02;
public class ExerciseSheet {//使用类Exercise.打印输出其中的每个算式
	private static final short COLUMN_NUMBER=5;
	public void formattedDisplay(Exercise ex,int columns) {//格式化显示方法
		int i=0;
		while(ex.hasNext()) {
			if(i%columns==0)
				System.out.println();
			System.out.print(+(i+1)+".");
			System.out.print(ex.next()+"   ");
			i++;
		}
	}
	public void formattedDisplay(Exercise ex) {//默认：每行打印5个算式
		formattedDisplay(ex,COLUMN_NUMBER);
	}
	public static void main(String[] args) {
		ExerciseSheet sheet=new ExerciseSheet ();
		Exercise exercise=new Exercise();
		exercise.generateBinaryExercise(50);
		System.out.println("----generate and dispaly add exercise----");
		sheet.formattedDisplay(exercise);
	}
}