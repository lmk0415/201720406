package test02;
public class ExerciseSheet {//ʹ����Exercise.��ӡ������е�ÿ����ʽ
	private static final short COLUMN_NUMBER=5;
	public void formattedDisplay(Exercise ex,int columns) {//��ʽ����ʾ����
		int i=0;
		while(ex.hasNext()) {
			if(i%columns==0)
				System.out.println();
			System.out.print(+(i+1)+".");
			System.out.print(ex.next()+"   ");
			i++;
		}
	}
	public void formattedDisplay(Exercise ex) {//Ĭ�ϣ�ÿ�д�ӡ5����ʽ
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