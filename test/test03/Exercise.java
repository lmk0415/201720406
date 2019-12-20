package test03;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Exercise {
	static final int COLUMN_NUMBER = 5;
	private ArrayList<BinaryOperator> list = new ArrayList<BinaryOperator>();
	private ArrayList<String> valuelist = new ArrayList<String>();
	private ArrayList<String[]> listFile = new ArrayList<String[]>();

	public void generateExercise(int equationNumber){
		BinaryOperator bo;
		while(equationNumber > 0){
			do{	bo = generateOperation();
			}while(contains(bo));	
			list.add(bo);
			equationNumber--;
		}
		}
	public void generateAdditionExercise(int equationNumber){
		BinaryOperator bo;
		for(int i = 0; i <  equationNumber; i++){
			bo = new AdditionOperation();
			while(contains(bo)){
			bo = new AdditionOperation();
			}
			list.add(bo);
		}
	}
	public void generateSubstractExercise(int equationNumber){
		BinaryOperator bo;
		for(int i = 0; i <  equationNumber; i++){
			bo = new SubstractOperation();
			while(contains(bo)){
			bo = new SubstractOperation();
			}
			list.add(bo);
		}
	}
	private BinaryOperator generateOperation() {
		int intOperator;
		Random random = new Random();
		intOperator = random.nextInt(2);
		if(intOperator == 1) return new AdditionOperation();
		else return new SubstractOperation();
	}
	
	public boolean contains(BinaryOperator bo){
		boolean appear = false;
		for(int i = 0; i < list.size(); i++){
			if(bo.equals(list.get(i))){
				appear = true;
				break;
			}
		}
		return appear;
	}
		public  void writeCSV(String csvFilePath1, String csvFilePath2){
		    try {
		        // ����CSVд����  (�ļ�·�����ָ����������ʽ);
		        CsvWriter csvWriter1 = new CsvWriter(csvFilePath1, ',', Charset.forName("gbk"));
		        // д��ͷ
		        CsvWriter csvWriter2 = new CsvWriter(csvFilePath2, ',', Charset.forName("gbk"));
		        String[] csvHeaders = { "��һ��", "�ڶ���", "������", "������", "������" };
		        csvWriter1.writeRecord(csvHeaders);
		        for (int i = 0; i < list.size(); i++) {
					BinaryOperator bo1 = list.get(i);
	String csvContent1 = bo1.getLeftOperator()+""+bo1.getOperator()+""+bo1.getRightOperator()+"=";
					String csvContent2 = bo1.getResult()+"";
		            csvWriter1.write(csvContent1);
		            csvWriter2.write(csvContent2);
			        if((i+1) % COLUMN_NUMBER == 0){
			        	csvWriter1.endRecord();
			        	csvWriter2.endRecord();
			        }
		        }	
		        csvWriter1.close();
		        csvWriter2.close();
		        list.clear();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		@SuppressWarnings("null")
		public  void readCSV(String type, int number, int equationNumber){//ϰ�������
			File file = new File("F://"+type+"��ϰ���");
			if(!file.exists())file.mkdir();
			String value;
			String csvFilePath1 = "F://"+type+"ϰ��//��"+number+"��"+equationNumber+"��"+type+"��ϰ��.csv";                 //��ȡϰ������·��
			String csvFilePath2 = "F://"+type+"��ϰ���//��"+number+"��"+equationNumber+"��"+type+"��ϰ���.csv";            //����ϰ������·��
			ArrayList<String[]> listFile = new ArrayList<String[]>();
			ArrayList<String> resultlist = new ArrayList<String>();
			 @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			try{
				CsvReader reader = new CsvReader(csvFilePath1,',',Charset.forName("gbk"));
				reader.readHeaders();
				while(reader.readRecord()){//��ȡϰ��
					String[] row = reader.getValues();
					listFile.add(row);
				}
				reader.close();
			
			for(int i=0;i<listFile.size();i++){
				for(int j=0;j<listFile.get(i).length;j++){
					String content = listFile.get(i)[j].toString();
					resultlist.add(content);
					System.out.print(content+" ");
				}
				System.out.println();	
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for(int i = 0;i < equationNumber;i++){
				System.out.print("��"+(i+1)+"��:");
				value = sc.next();
				if(value != null || value.length() <= 0){
				valuelist.add(value);
				}else valuelist.add("");
			}
			
			 try {
			        // ����CSVд���� (�ļ�·�����ָ����������ʽ);
			        CsvWriter csvWriter = new CsvWriter(csvFilePath2, ',', Charset.forName("gbk"));
			        for (int i = 0; i < valuelist.size(); i++) {
						String csvContent = resultlist.get(i)+valuelist.get(i);
			            csvWriter.write(csvContent);
				            if((i+1) % COLUMN_NUMBER == 0)csvWriter.endRecord();
			        }	
			        csvWriter.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			 CorrecteExercise(type, number, equationNumber);
		}
		public  void openCSV(String type, int number, int equationNumber){
			String value;
			String csvFilePath = "F://"+type+"��ϰ���//��"+number+"��"+equationNumber+"��"+type+"��   ϰ���.csv";         //����ϰ������·��
			ArrayList<String> resultlist = new ArrayList<String>();
			 @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			try{
				CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("gbk"));
				//reader.readHeaders();
				while(reader.readRecord()){//��ȡϰ��
					String[] row = reader.getValues();
					listFile.add(row);
				}
				reader.close();
			
			for(int i=0;i<listFile.size();i++){
				for(int j=0;j<listFile.get(i).length;j++){
					String content = listFile.get(i)[j].toString();
					resultlist.add(content);
					System.out.print(content+" ");
					
				}
				System.out.println();	
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for(int i = 0;i < equationNumber;i++){
				System.out.print("��"+(i+1)+"��:");
				value = sc.next();
				if(value != null || value.length() <= 0){
				valuelist.add(value);
				}else valuelist.add("");
			}
			
			 try {
			        // ����CSVд����  (�ļ�·�����ָ����������ʽ);
			        CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("gbk"));
			        for (int i = 0; i < valuelist.size(); i++) {
						String csvContent = resultlist.get(i)+valuelist.get(i);
			            csvWriter.write(csvContent);
				            if((i+1) % COLUMN_NUMBER == 0)csvWriter.endRecord();
			        }	
			        csvWriter.close();
			        valuelist.clear();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			 CorrecteExercise(type, number, equationNumber);
		}
		public  void writeCsvSubstractExercise(int exerciseNumber, int equationNumber){
			File file1 = new File("F://����ϰ��");
			if(!file1.exists())file1.mkdir();
			File file2 = new File("F://����ϰ���");
			if(!file2.exists())file2.mkdir();
			String csvFilePath1;
			String csvFilePath2;
		    for(int j = exerciseNumber; j > 0; j--){
			generateSubstractExercise(equationNumber);
			csvFilePath1 = "F://����ϰ��//��"+j+"��"+equationNumber+"��������ϰ��.csv";
			csvFilePath2 = "F://����ϰ���//��"+j+"��"+equationNumber+"��������ϰ���.csv";
			writeCSV(csvFilePath1,csvFilePath2);
		    }
		}
		public  void writeCsvAdditionExercise(int exerciseNumber, int equationNumber){
			File file1 = new File("F://�ӷ�ϰ��");
			if(!file1.exists())file1.mkdir();
			File file2 = new File("F://�ӷ�ϰ���");
			if(!file2.exists())file2.mkdir();
			String csvFilePath1;
			String csvFilePath2;
		    for(int j = exerciseNumber; j > 0; j--){
			generateAdditionExercise(equationNumber);
			csvFilePath1 = "F://�ӷ�ϰ��//��"+j+"��"+equationNumber+"���ӷ���ϰ��.csv";
			csvFilePath2 = "F://�ӷ�ϰ���//��"+j+"��"+equationNumber+"���ӷ���ϰ���.csv";
			writeCSV(csvFilePath1, csvFilePath2);
		    }
		}
		public  void writeCsvGenerateExercise(int exerciseNumber, int equationNumber){
			File file1 = new File("F://���ϰ��");
			if(!file1.exists())file1.mkdir();
			File file2 = new File("F://���ϰ���");
			if(!file2.exists())file2.mkdir();
			String csvFilePath1;
			String csvFilePath2;
		    for(int j = exerciseNumber; j > 0; j--){
			generateExercise(equationNumber);
			csvFilePath1 = "F://���ϰ��//��"+j+"��"+equationNumber+"�������ϰ��.csv";
			csvFilePath2 = "F://���ϰ���//��"+j+"��"+equationNumber+"�������ϰ���.csv";
			writeCSV(csvFilePath1, csvFilePath2);
		    }
		}
		public void CorrecteExercise(String type, int number, int equationNumber){
			String csvFilePath1 = "F://"+type+"ϰ���//��"+number+"��"+equationNumber+"��"+type+"       ��ϰ���.csv";
			String csvFilePath2 = "F://"+type+"ϰ�����Ľ��//��"+number+"��"+equationNumber+"��  "+type+"��ϰ�����Ľ��.csv";
			int wrong = 0;
			int right = 0;
			ArrayList<String> resultslist = new ArrayList<String>();
			try{
				CsvReader reader = new CsvReader(csvFilePath1,',',Charset.forName("gbk"));
				while(reader.readRecord()){   //��ȡϰ���
					String[] row = reader.getValues();
					listFile.add(row);
				}
				reader.close();

				for(int i=0;i<listFile.size();i++){
					for(int j=0;j<listFile.get(i).length;j++){
						String content = listFile.get(i)[j].toString();
						resultslist.add(content);
					}
					System.out.println();	
				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			for(int i = 0; i < valuelist.size(); i++){
				if(resultslist.get(i).equals(valuelist.get(i)))right++;
				else wrong++;
			}
			try {
		        // ����CSVд���� 
		        CsvWriter csvWriter = new CsvWriter(csvFilePath2, ',', Charset.forName("gbk"));
		        String[] csvHeaders = { "��ȷ", "����"};
		        csvWriter.writeRecord(csvHeaders);
		        for (int i = 0; i < valuelist.size(); i++) {
		        	String[] csvContent = { right+"", wrong+""};
		            csvWriter.writeRecord(csvContent);
		        }
		        csvWriter.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	public static void main(String[] args) {
		int exerciseNumber, equationNumber, number;
		String type;
		
		Scanner sc = new Scanner(System.in);
		Exercise exercise = new Exercise();
		System.out.print("���������ϰ��������");
		exerciseNumber = sc.nextInt();
		System.out.print("�����������ʽ������");
		equationNumber = sc.nextInt();
		System.out.print("��������ѡϰ������ͣ�");
		type = sc.next();
		System.out.print("��������ѡϰ�����ţ�");
		number = sc.nextInt();
		System.out.print("��������ѡϰ�����ʽ������");
		equationNumber = sc.nextInt();
		//exercise.readCSV("�ӷ�",1,3);
		System.out.print("������������ĵ�ϰ������ͣ���ţ���ʽ������");
		type = sc.next();number = sc.nextInt();equationNumber = sc.nextInt();
		//exercise.openCSV("�ӷ�",1,3);
	}
}