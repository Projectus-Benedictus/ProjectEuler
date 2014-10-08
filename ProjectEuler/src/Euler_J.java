import java.lang.Math;
import java.math.*;

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
	
	
	
	public int Problem7(){
		int contador=1;
		int primo=3;
		while (contador<10001) {
			if (ePrimo(primo)){
				contador++;
			}
			primo+=2;
		}
		return (primo-2);
	}
	
	
	public long Problem8() {
		String n= "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		long maior=0;
		long m =1;
		for (int i=0;i<n.length()-13;i++) {
			int j=i+12;
			while(j>=i) {
				int x = Character.getNumericValue(n.charAt(j));
				m=m*x;
				j=j-1;
				}
			if (m>maior) {
				maior=m;
			}
			m=1;
		}
		return maior;
	}
	
	
	public int Problem9() {
		
	}
	
}