import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Utility_J {
	
	private static int[] MOEDAS = {1, 2, 5, 10, 20, 50, 100, 200};
	private static String[] zeroNine = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static String[] tenNineteen = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static String[] twentyAndUp = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static boolean isPrime(int a) {
		if (a==2) return true;
		if (a % 2 == 0 || a == 1) return false;
		long sqrtPrimo = (long) Math.sqrt(a);
		for (int i=3;i<=sqrtPrimo;i+=2) {
			if (a%i==0) return false;
		}
		return true;
	}
	
	public static boolean[] listarPrimaliade(int n) {
		boolean[] primos = new boolean[n+1];
		for (int i=0;i<n+1;i++) {
			if (isPrime(i)) {
				primos[i] = true;
			}else {
				primos[i] = false;
			}
		}
		return primos;
	}
	
	public static int[] listarPrimalidade(int max) {
		boolean[] isPrime = listarPrimaliade(max);
		int count=0;
		for (boolean b : isPrime) {
			if (b) {
				count++;
			}
		}
		int[] primos = new int[count];
		for (int i=0, j=0;i<isPrime.length;i++) {
			if (isPrime[i]) {
				primos[j]=i;
				j++;
			}
		}
		return primos;
	}
	
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
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
	
	public static BigInteger factorial(int n) {
		if (n<0) {
			throw new IllegalArgumentException("Factorial de um número negativo");
		}
		BigInteger b = BigInteger.ONE;
		for (int i=2;i<=n;i++) {
			b=b.multiply(BigInteger.valueOf(i));
		}
		return b;
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
	
	
	public static int somaFactorial(int n) {
		int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		int sum = 0;
		while (n!=0) {
			sum += factorial[n%10];
			n/=10;
		}
		return sum;
	}
	
	public static int[][] somas(int total) {
		int[][] maneiras = new int[MOEDAS.length+1][total+1];
		maneiras[0][0] = 1;
		for (int i = 0; i<MOEDAS.length;i++) {
			for ( int j = 0;j<=total; j++) {
				maneiras[i+1][j] = maneiras[i][j] + (j >= MOEDAS[i] ? maneiras[i+1][j-MOEDAS[i]] : 0);
			}
		}
		return maneiras;
	}
	
	public static boolean isAbundante(int n) {
		if (n<1) {
			throw new IllegalArgumentException();
		}
		int sum=1;
		int fim = (int)  Math.sqrt(n);
		for (int i=2; i<=fim;i++) {
			if (n%i==0) {
				sum +=i+n/i;
			}
		}
		if (fim*fim == n) {
			sum -=fim;
		}
		return sum>n;
	}
	
	public static boolean isSoma2Abundantes(int n) {
		for (int i=0;i<=n;i++) {
			if (Euler_J.isAbundante[i] && Euler_J.isAbundante[n-i]) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean nextPermutation(int[] a) {
		int i, n = a.length;
		for (i = n - 2; ; i--) {
			if (i < 0)
				return false;
			if (a[i] < a[i + 1])
				break;
		}
		for (int j = 1; i + j < n - j; j++) {
			int tp = a[i + j];
			a[i + j] = a[n - j];
			a[n - j] = tp;
		}
		int j;
		for (j = i + 1; a[j] <= a[i]; j++);
		int tp = a[i];
		a[i] = a[j];
		a[j] = tp;
		return true;
	}
	
	
	public static int tamanhoCiclo(int d) {
		Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
		int a = 1;
		int b = 0;
		while (!dict.containsKey(a)) {
			dict.put(a, b);
			a = a*10%d;
			b++;
		}
		return b-dict.get(a);
	}
	
	
	public static boolean temProdutoPandigital(int n) {
		for (int i=1;i<=n;i++) {
			if (n%i == 0 && isPandigital("" + n + i + n/i)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPandigital(String p) {
		if (p.length()!=9) {
			return false;
		}
		char[] temp = p.toCharArray();
		Arrays.sort(temp);
		return new String(temp).equals("123456789");
	}
	
	public static int toInteger(int[] digits) {
		int result=0;
		for (int x : digits) { 
			result = result*10+x;
		}
		return result;
	}
	
	public static long toInteger(int[] digits, int off, int len) {
		long result=0;
		for (int i=off;i<off+len;i++) {
			result = result*10 + digits[i];
		}
		return result;
	}
	
	
	public static long numeroPentagonal(int x) {
		if (x<=0) {
			throw new IllegalArgumentException();
		}
		return (long) x*(x*3-1)>>>1;
	}
	
	
	public static boolean isNumeroPentagonal(long x) {
		if (x<=0) {
			return false;
		}
		long n = x*24+1;
		long sqrt = (long) Math.sqrt(n);
		return sqrt*sqrt==n && sqrt%6==5;
	}
	
	public static String paraIngles(int n) {
		if (n<0 || n>=100000) {
			throw new IllegalArgumentException();
			}
		if (n<100) {
			return twentyAndUp(n);
		}
		else {
			String s = "";
			if (n>=1000) {
				s+=twentyAndUp(n/1000)+"thousand";
			}
			if (n/100 % 10 != 0) {
				s+=zeroNine[n/100%10]+"hundred";
			}
			return s+(n%100 != 0 ? "and" + twentyAndUp(n%100) : "");
		}
	}
	
	public static String twentyAndUp(int n) {
		if (n<10) {
			return zeroNine[n];
		}else if (n<20) {
			return tenNineteen[n-10];
		}else {
			return twentyAndUp[n/10-2] + (n%10 !=0 ? zeroNine[n%10] : "");
		}
	}
	
	public static int diaDaSemana(int ano, int mes, int dia) {
		long m = mod((long)mes - 3, 4800);
		long a = mod(ano + m/12, 400);
		m%=12;
		return (int) ((a + a/4 - a/100 + (13*m+2) / 5 + dia + 2) % 7);
	}
	
	public static long mod(long x, long y) {
		x %= y;
		if (y<0 && x>0 || y>0 &&x<0) {
			x += y;
		}
		return x;
	}
	
	public static int numeroDePrimosGeradosSeguidos(int i, int f) {
		for (int a=0;;a++) {
			int n=a * a + a * i + f;
			if (n<0 || !isPrime(n)) {
				return a;
			}
		}
	}
	
	public static int contarSolucoes(int p) {
		int count=0;
		for (int a=1;a<=p;a++) {
			for (int b=a;b<=p;b++) {
				int c=p-a-b;
				if (b<=c && a*a + b*b == c*c) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean temOsMesmosDigitos(int x, int y) {
		char[] xDigitos = Integer.toString(x).toCharArray();
		char[] yDigitos = Integer.toString(y).toCharArray();
		Arrays.sort(xDigitos);
		Arrays.sort(yDigitos);
		if (Arrays.equals(xDigitos, yDigitos)) {
			return true;
		}
		return false;
	}
	
	public static BigInteger binomial(int i, int j) {
		return factorial(i).divide(factorial(i - j).multiply(factorial(j)));
	}
	
	public static boolean isCircularPrime(int n) {
		String s = ""+n;
		for (int i=0;i<s.length();i++) {
			if (!Euler_J.isPrime[Integer.parseInt(s.substring(i)+s.substring(0,i))]) {
				return false;
			}
		}
		return true;
	}
}
