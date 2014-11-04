import java.math.BigInteger;


public class Utility {
	
	public static boolean isPrime(int a) {
		if (a==2) return true;
		if (a % 2 == 0 || a == 1) return false;
		long sqrtPrimo = (long) Math.sqrt(a);
		for (int i=3;i<=sqrtPrimo;i+=2) {
			if (a%i==0) return false;
		}
		return true;
	}
	
	public static boolean isPalindrome(int n) {
		int i=0;
		int m=n;
		while (n!=0) {
			int r = n%10;
			i=(i*10)+r;
			n/=10;
		}
		return ((m == i) ? true: false);
	}
	
	public static int maxmc(int x, int y) {	
		return ((y==0)? x:maxmc(y, x%y));
	}

	public static int minmc(int x, int y) {
		return ((x*y)/(maxmc(x,y)));
	}
	
	public static int matrixRunner(int matriz[][]) {
		int produto=0;
		int maiorProduto=0;
		//Ver vertical
		for (int i=0;i<17;i++) {
			for  (int j=0; j<20;j++) {
				produto = matriz[j][i]*matriz[j][i+1]*matriz[j][i+2]*matriz[j][i+3];
				if (produto>maiorProduto) {
					maiorProduto = produto;
				}
			}
		}
		//Ver horizontal
		for (int i=0;i<20;i++) {
			for (int j=0;j<17;j++) {
				produto = matriz[j][i]*matriz[j+1][i]*matriz[j+2][i]*matriz[j+3][i];
				if (produto>maiorProduto) {
					maiorProduto=produto;
				}
			}
		}
		//Ver diagonal direita
		for (int i=0;i<17;i++) {
			for (int j=0;j<17;j++) {
				produto = matriz[j][i]*matriz[j+1][i+1]*matriz[j+2][i+2]*matriz[j+3][i+3];
				if (produto>maiorProduto) {
					maiorProduto=produto;
				}
			}
		}
		//Ver diagonal esquerda
		for (int i=3;i<17;i++) {
			for (int j=0;j<17;j++) {
				produto = matriz[j][i]*matriz[j+1][i-1]*matriz[j+2][i-2]*matriz[j+3][i-3];
				if (produto>maiorProduto) {
					maiorProduto=produto;
				}
			}
		}
		return maiorProduto;
	}
	
	public static int countDivisors(int n) {
		int numDivisores=0;
		int limite = (int) Math.sqrt(n);
		for (int i=1;i<=limite;i++) {
			if(n%i==0) {
				numDivisores+=2;
			}
		}
		if (limite*limite == n) {//verificação do quadrado perfeito
			numDivisores++;
		}
		return numDivisores;
	}
	
	public static String factorialString(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i=1;i<=n;i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact.toString();
	}
	
	public static int collatzSequence(long n) {
		int counter=0;
		while(n!=1) {
			n = (n%2==0) ? (n=n/2) : (n=n*3+1);
			counter++;
		}
		return counter;
	}
	
	public static BigInteger bigFibonacci(int n) {
		if(n==0) return BigInteger.ZERO;
		if(n==1) return BigInteger.ONE;
		return bigFibonacci(n-1).add(bigFibonacci(n-2));
	}
	
	public static BigInteger combinacoes(int n, int r) {
		BigInteger factn = new BigInteger(factorialString(n));
		BigInteger factr = new BigInteger(factorialString(r));
		BigInteger comb = factn.divide(factr.multiply(factr));
		return comb;
	}

	
	public static int somaDivisores(int n) {
		int sum=0;
		for (int i=1; i<n;i++) {
			if (n%i==0) {
				sum+=i;
			}
		}
		return sum;
	}
	
	
	public static boolean isAmicable(int a) {
		int b = somaDivisores(a);
		return b!=a && somaDivisores(b)==a;
	}
	
	
	public static int somaElevadoCinco(int x) {
		int sum=0;
		while (x!=0) {
			int y=x%10;
			sum+=y*y*y*y*y;
			x/=10;
		}
		return sum;
	}
}