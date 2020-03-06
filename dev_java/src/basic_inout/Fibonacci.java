package basic_inout;

public class Fibonacci {
	public int Fibonacci(int n) {
	
		if(n==0)
		return 0;
		if(n==1)	
		return 1;
		
		int a = 0;
		int b = 1;
		int c = 1;
		for(int i=0 ; i<n-2 ; i++) {
		a=b;
		b=c;
		c=a+b;
	}
		return c;
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		int a = f.Fibonacci(10);
		System.out.println(a);
	}
}	
