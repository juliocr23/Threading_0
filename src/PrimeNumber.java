import java.util.Scanner;


public class PrimeNumber {
	public static Thread primeThread;
	public static int input;

	public  void getInputs(){

		Scanner keyboard = new Scanner(System.in);

		//Get Input from the user
		System.out.print("Please enter a number: ");
		input = keyboard.nextInt();
		
	    System.out.println();
	    
	    keyboard.close();
	}
	
	public void calPrime(){
		//Calculate primes
		primeThread = new Thread(() -> {
			for (int x = 2; x <= input ; x++){
				for (int j = 2; j<=x;j++)
				{
					if (j==x)

					{
						System.out.print(x + " ");
					}
					if (x % j == 0)
					{
						break;
					}
				}
			}
		});primeThread.start();
	}
	
	public void getPrime(){
		calPrime();
		
		try{
			primeThread.join();
		}
		catch (InterruptedException e) { e.printStackTrace();}
	}

	public static void main(String[] args) {

		 PrimeNumber primeObject = new PrimeNumber();
		 primeObject.getInputs();
		 primeObject.getPrime();
	}
}