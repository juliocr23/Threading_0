import java.util.*;

public class FibSeq implements Runnable {
		
	static int fib1 = 0;
	static int fib2 = 1;
	static int fibn;
	static int i;
	static int input;
	
	public FibSeq() {
		
	}
	
	public FibSeq (int fib1, int fib2, int fibn) {
		
		this.fib1 = fib1;
		this.fib2 = fib2;
		this.fibn = fibn;
	}
	public static void getInput() {
		
		Scanner scanner = new Scanner(System.in);
		
		// Get input from user 
		System.out.println("Enter a number");
		input = scanner.nextInt();
		scanner.close();
		
	}
	
	public void run() {
		
		for(i = 2; i <= input; i++) {
			fibn = fib1 + fib2;
			System.out.print(" " + fibn);
			fib1 = fib2;
			fib2 = fibn;
		}
		
	}


	public static void main (String[] args) {
		
		
		FibSeq fib = new FibSeq();
	
		FibSeq.getInput();
		System.out.print(fib1 + " " + fib2);
		
		Thread t1 = new Thread(fib);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	

}