import java.util.*;

public class FibSeq {
		
	static int fib1 = 0;
	static int fib2 = 1;
	static int fibn;
	static int i;
	static int input;
	
	public static void getInput() {
		
		Scanner scanner = new Scanner(System.in);
		
		// Get input from user 
		System.out.println("Enter a number");
		input = scanner.nextInt();
		scanner.close();
		
	}
	
	public static void generateFib() {
	
		for(i = 2; i < input; i++) {
			fibn = fib1 + fib2;
			System.out.print(" " + fibn);
			fib1 = fib2;
			fib2 = fibn;
		}
		
	}

	public static void main (String[] args) {
	
		FibSeq.getInput();
		System.out.print(fib1 + " " + fib2);
		FibSeq.generateFib();
	
	}
	

}