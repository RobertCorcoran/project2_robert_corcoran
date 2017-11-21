import java.util.Scanner; /** Needed for Scanner class */
import java.io.*;      /** For file and IOException */

public class project2_robert_corcoran
{ /** Start class. */
   public static void main(String[] args) throws IOException
   { /** Start main. */
            
      File file = new File("boarding.txt"); /** Open the file. */
      Scanner inputFile = new Scanner(file); /** Read the file. */
      
      String kennelName = "Madison Kennel & Grooming \n \n";/** display the kennel's name on screen */
      System.out.println(kennelName);

      
      /** Declare the variables. */
      String firstName, lastName, breed;
      double weight;
      int numDays;
      double highRiskFee = 20.00;
      double tax = .06;    /** tax rate */
      double rate = .70;   /** cost per pound per day */
      double totalSales = 0; /** used for accumulator */
      int numCustomers = 0;
      double averageSales = 0;
      /** use while loop to read file until it reaches the end. */
      while(inputFile.hasNext())
      {
         firstName = inputFile.nextLine();
         lastName = inputFile.nextLine();
         breed = inputFile.nextLine();
         numDays = inputFile.nextInt();
         weight = inputFile.nextDouble();
         inputFile.nextLine(); /** Consume the newline character. */
         if(inputFile.hasNextLine())
         {
            inputFile.nextLine(); /** Avoid exception. */
         }
         
         /** Add $20.00 fee if breed is high risk. */
         if (breed.equals("Doberman Pinscher"))
            highRiskFee = 20.00;
         else if (breed.equals("Pit Bull"))  
            highRiskFee = 20.00;
         else if (breed.equals("Rottweiler"))
            highRiskFee = 20.00;
         else
            highRiskFee = 0;
         
         /** Calculate the cost of boarding. */
         double preTaxTotal = (((double)numDays * rate * weight) + highRiskFee);  /** calculate the boarding fee before tax */
         double totalPlusTax = (preTaxTotal + (preTaxTotal * tax));
         double taxAmount = (preTaxTotal * tax);
         /** Add multiple costumers' bills */
         totalSales += totalPlusTax;
         numCustomers += 1;
         
         /** Display breakdown of cost and dog ower's name */
         System.out.println("Owner: " + firstName + " " + lastName);
         System.out.println("Breed: " + breed);
         System.out.println("\nWeight: " + weight + " lbs");  /** display weight */  
		   System.out.println("Boarding Day(s): " +	numDays);   /** display number of days */ 
         System.out.printf("Total boarding fee for " + numDays + " days (before tax): $%.2f \n", preTaxTotal);/** display pre-tax total */
         System.out.printf("Total amount of tax (6 percent tax rate): $%.2f \n", (preTaxTotal * tax));/** display tax rate */
         System.out.printf("Total boarding fee with tax: $%.2f \n", totalPlusTax);/** display total + tax */

                  System.out.println();
      }
      inputFile.close();
      
      /** Display the accumulated sales from multiple costumers */
      System.out.printf("\nTotal payments: $%.2f \n", totalSales);
      /** Calculate and display the average payment amount */
      averageSales = totalSales / (double)numCustomers;
      System.out.printf("\nAverage payment amount: $%.2f \n", averageSales);
   }
}