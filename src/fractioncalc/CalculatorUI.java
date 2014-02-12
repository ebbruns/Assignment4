package fractioncalc;

import java.io.IOException;

public class CalculatorUI
{

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args)
    throws Exception
  {
    java.io.BufferedReader eyes; // Makes reader to get user input
    java.io.InputStreamReader istream;
    istream = new java.io.InputStreamReader(System.in);
    eyes = new java.io.BufferedReader(istream);
    String input = "";

    System.out.println("Hello, and welcome to our calculator!");
    System.out.println("Please enter your input below!");

    while (true) // Infinite loop allowing user to enter equations to heart's
                 // content.
      { // Loop can be broken by entering "exit" [no quotes]
        input = eyes.readLine();
        if (input.equalsIgnoreCase("exit"))
          break;
        Fraction outFrac = Calculator.eval0(input);
        System.out.println(outFrac.showFrac());
      }

  }

}

// Input code based on code found at:
// http://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014S/readings/io.html
// For equalsIgnoreCase:
// http://msdn.microsoft.com/en-us/library/aa987503(v=vs.80).aspx