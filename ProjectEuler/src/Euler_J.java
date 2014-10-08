import java.lang.Math;

public class Euler_J {

	public Euler_J() {
	}

	public int Problem1() {
		int sum=0;
		for(int i=3;i<1000;i++){
			if(i%3==0 || i%5==0) {
				sum+=i;
			}
		}
		return sum;
	}
	


	public int Problem2() {
		int first=0;
		int second=1;
		int result=0;
		int sum=0;
		while (result<4000000) {
			if (result%2==0) {
				sum+=result;
			}
			first=second;
			second=result;
			result=first+second;
		}
		return sum;
	}

	

	public long Problem3() {
		long n=Long.parseLong("600851475143");
		long maior=0;
		while(n!=1) {
			int i=2;
			while (i<=n) {
				if (ePrimo(i) && n%i==0) {
					if (i>maior) {
						maior = i;
					}
					n/=i;
					break;
				}
				i++;
			}
		}
		return maior;
	}

	public boolean ePrimo(int primo) {
		if (primo==2) { 
			return true;
		}
		if (primo % 2 == 0 || primo ==1) {
			return false;
		}
		long sqrtPrimo= (long)Math.sqrt(primo);
		for (int i=3;i<=sqrtPrimo;i+=2) {
			if (primo%i==0) {
				return false;
			}
		}
		return true;
	}


	
	public int Problem4() {
		int maior=0;
		int palindromo;
		for (int i=100;i<=999;i++) {
			for (int j=i; j<=999;j++) {
				palindromo=i*j;
				if (Palindromo(palindromo) && palindromo>maior ) {
					maior=palindromo;
				}
			}
		}
		return maior;
	}

	public boolean Palindromo(int n) {
		int i=0;
		int m=n;
		while (n!=0) {
			int r = n%10;
			i=(i*10)+r;
			n/=10;
		}
		return ((m == i) ? true: false);
	}
	
	
	
	public int Problem5() {
		int[] n={20,19,18,17,16,15,14,13,12,11};
		int mmc=Minmc(n[0],n[1]);
		for (int i=2; i<n.length;i++) {
			mmc=Minmc(mmc,n[i]);
		}
		return mmc;
	}

	public int Maxmc(int x, int y) {	
		return ((y==0)? x:Maxmc(y, x%y));
	}

	public int Minmc(int x, int y) {
		return ((x*y)/(Maxmc(x,y)));
	}

	

	public int Problem6(int n) {
		int sumSquares=0;
		int squareSum=0;
		for (int i=1;i<=n;i++) {
			sumSquares+=i*i;
			squareSum+=i;
		}
		return ((int)Math.pow(squareSum, 2) - sumSquares);
	}	
}