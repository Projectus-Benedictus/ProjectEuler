import java.math.*;

public class Euler {
	
	public Euler(){
	}
	
	public int Problem1(){
		int sum=0;
		for(int i=3;i<1000;i++){
			if(i%3==0 || i%5==0){sum+=i;
			}
		}return sum;
	}
	
	
	public int Problem2(){
		int first=0;
		int second=1;
		int result=0;
		int sum=0;
		while (result<4000000){
			if (result%2==0){sum+=result;
			}
			first=second;
			second=result;
			result=first+second;
		}return sum;
	}
}
