package liu;

import java.util.Random;
public class suanshi {
	static int x,y,w;
	static Formula []formula = new Formula[100];
	static int randoms() {
		Random random = new Random();
		return ((int)random.nextInt(100));
	}
	static void Generating(){
		x=randoms();
		y=randoms();
		w=randoms();
		w=w%2==0?1:-1;
	}
	static Boolean panduan(int s) {
		if((x+(y*w))<0 || (x+(y*w)>100))
			return false;
		for(int j=1;j<s;j++) {
			if(x==formula[j].x && y==formula[j].y && w==formula[j].w) {
				return false;
			}
		}
		return true;
	}
	static void output(int s) {
		formula[s] = new Formula(x,y,w);
		System.out.print(s + " : ");
		System.out.print(x + (w==1?" + ":" - ") + y + " = " + (x+y*w));
		if(s%5==0) 
			System.out.println();
		else
			System.out.print(" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=50;i++) {
			 Generating();
			 if(panduan(i)==false) {
				 i--;
			 }
			 else
				 output(i);
		}
	}

}
