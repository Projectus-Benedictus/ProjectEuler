import java.lang.Math;

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
	
	
	public long Problem3(){
		long n=600851475143L;
		long div=2;
		while (true==true){
			long primo = n/div;
			if(n%primo==0 && Problem3_2(primo)){return primo;
			}div++;
		}
	}
	
	public boolean Problem3_2(long primo){
		if(primo%2==0){return false;
		}
		long meio=(primo/2)%2==0 ? (primo/2)-1 : primo/2;
		for (int i=3;i<meio;i+=2){
			if(primo%i==0){return false;	
			}
		}return true;
	}
	
	
	
	public int Problem5(){
		int[] n={20,19,18,17,16,15,14,13,12,11};
		int mmc=Minmc(n[0],n[1]);
		for (int i=2; i<n.length;i++){
			mmc=Minmc(mmc,n[i]);
		}return mmc;
	}
	
	public int Maxmc(int x, int y){	
		return ((y==0)? x:Maxmc(y, x%y));
	}
	
	public int Minmc(int x, int y){
		return ((x*y)/(Maxmc(x,y)));
	}
	
	
	
	public int Problem6(int n){
		int sumSquares=0;
		int squareSum=0;
		for (int i=1;i<=n;i++){
			sumSquares+=i*i;
			squareSum+=i;
		}return ((int)Math.pow(squareSum, 2) - sumSquares);
	}
	
	
	

	
	
}