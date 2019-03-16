/**
 * Statistic.java
 *
 * Group: Julio Rosario
 *        Jeson Rosario
 *        Ryan Wilson
 *        Lisa D. Smith
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Statistic {

    private static ArrayList<Double> inputs;
    private static double max;
    private static double min;
    private static double avg;
    private static Thread maxThread;
    private static Thread minThread;
    private static Thread avgThread;

    private  void getInputs(){
        Scanner keyboard = new Scanner(System.in);
        double number;

        //Get Input from the user as long as input is not -999
        inputs = new ArrayList<>();
        System.out.println("Enter -999 to finish entering numbers");
        do {

            //Read input from user.
            System.out.print("Enter  number: ");
            number = keyboard.nextDouble();
            System.out.println();

            //Add number to the input list if number is not -999
            if(number != -999) inputs.add(number);

        }while(number != -999);

        keyboard.close();
    }

    private   void calculateMin(){

        //Calculate minimum
      minThread = new Thread(() -> { //Use Lambda expression for the Runnable implementation
            min = inputs.get(0);
            for(int i = 1; i<inputs.size(); ++i)
                if(min > inputs.get(i)) min = inputs.get(i);
        });

        minThread.start();
        System.out.println("Min Thread started");
    }

   private  void calculateMax(){
        //Calculate maximum
        //lambda
       maxThread = new Thread(() -> { //Use lambda expression for the Runnable implementation

            max = inputs.get(0);
            for(int i = 1; i<inputs.size(); ++i)
                if(max < inputs.get(i)) max = inputs.get(i);
        });maxThread.start();

    }

    private  void calculateAvg(){
        //Calculate average
        avgThread = new Thread(() -> { //Use lambda expression for the Runnable implementation

            double sum= 0;
            for(int i = 0; i<inputs.size(); ++i)
                sum += inputs.get(i);

            avg = sum/inputs.size();
        });avgThread.start();
    }

    public void getStatistic(){

        calculateMin();
        calculateMax();
        calculateAvg();

        try {

            // Wait for the min, max, and avg threads
            // to died to display statistic result.
            minThread.join();
            maxThread.join();
            avgThread.join();
            displayResult();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayResult(){
        System.out.println("Your input was: ");
        for(var input: inputs)
            System.out.print(input + " ");

        System.out.println();
        System.out.println("The average value is " + avg);
        System.out.println("The minimum value is " + min);
        System.out.println("The maximum value is " + max);
    }


    public static void main(String[] args) {

        var statistic = new Statistic();
        statistic.getInputs();
        statistic.getStatistic();
    }
}
