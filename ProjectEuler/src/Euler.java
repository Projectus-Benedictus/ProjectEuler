import java.lang.Math;
import java.math.BigInteger;
import java.io.*;

public class Euler {

	public Euler() {
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
				if (Utility.isPrime(i) && n%i==0) {
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

	
	public int Problem4() {
		int maior=0;
		int palindromo;
		for (int i=100;i<=999;i++) {
			for (int j=i; j<=999;j++) {
				palindromo=i*j;
				if (Utility.isPalindrome(palindromo) && palindromo>maior ) {
					maior=palindromo;
				}
			}
		}
		return maior;
	}
	
	
	public int Problem5() {
		int[] n={20,19,18,17,16,15,14,13,12,11};
		int mmc=Utility.minmc(n[0],n[1]);
		for (int i=2; i<n.length;i++) {
			mmc=Utility.minmc(mmc,n[i]);
		}
		return mmc;
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
			if (Utility.isPrime(primo)){
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
		int a,b;
		double c;
		for (a=1;;a++) {
			for (b=1;b<=a;b++) {
				c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
				if (c == (int) c) { 
					if (a+b+ (int) c == 1000) {
						return  a*b* (int) c;
					}
				}
			}
		}
	}
	
	
	
	public long Problem10() {
		long soma=0;
		for(int i=1;i<2000000;i++) {
			if (Utility.isPrime(i)) {
				soma+=i;
			}
		}
		return soma;
	}
	
	
	
	public int Problem11() {
		int vintePorVinte[][] = {{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},{49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},{81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},{52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},{22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},{24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},{32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},{67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},{24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},{21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},{78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},{16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},{86, 56, 0, 48, 35, 71, 89, 07, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},{19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},{4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},{88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},{4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},{20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},{20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},{1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}};
		return Utility.matrixRunner(vintePorVinte);
	}
	
		
	public int Problem12() {
		int n=0;
		for (int i=1;;i++) {
			n+=i; //
			if (Utility.countDivisors(n)>500) {
				return n;
			}
		}
	}
	
	
	public long Problem13() {
		BigInteger sum = BigInteger.valueOf(0);
		try (FileInputStream file= new FileInputStream("src/Number.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
		   
			for(String line; (line = br.readLine()) != null; ) {
		    	sum = sum.add(new BigInteger(line));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sumString = sum.toString();
		StringBuilder s = new StringBuilder();
		for (int i=0;i<10;i++) {
			s.append(sumString.charAt(i));
		}
		long fim = Long.parseLong(s.toString());
		return fim;
	}
	
	
	
	public int Problem16() {
		BigInteger bigNumber = new BigInteger("2");
		bigNumber = bigNumber.pow(1000);
		String n = bigNumber.toString();
		int sum = 0;
		for (int i=0;i<n.length();i++) {
			Character c = new Character(n.charAt(i));
			String s = c.toString();
			int num = Integer.parseInt(s);
			sum += num;
		}
		return sum;
	}
	
	
	
	public int Problem20() {
		int sum=0;
		String n = Utility.FactorialString(100);
		for (int i=0;i<n.length();i++) {
			Character c = new Character(n.charAt(i));
			String s = c.toString();
			int num = Integer.parseInt(s);
			sum += num;
		}
		return sum;
	}
}
