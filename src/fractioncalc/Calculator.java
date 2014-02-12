package fractioncalc;

import fractioncalc.Fraction;

public class Calculator
{
  static Fraction register[] = new Fraction[8]; // Creates the register

  /*
   * evalArray Evaluates an array of strings Preconditions: The array of strings
   * is nonempty, and the strings follow basic formatting guidelines
   * Postconditions: An array of fraction objects are returned, with values
   * equal to the input strings.
   */

  public static Fraction[] evalArray(String[] input)
    throws Exception
  {
    int j = 0;
    Fraction[] output = new Fraction[input.length];
    for (j = 0; j < input.length; j++)
      {
        output[j] = eval0(input[j]);
        output[j].showFrac();
      }

    // String[] stringArray = {"1/2 * 2 - 1/2", "-1/4 + 1", "1 - 4/14"};
    // evalArray(stringArray); //We couldn't get testing to formally work, but
    // this illustrates that this function works.

    return output;

  }

  /*
   * eval0 Evaluates a string containing an arithmetic expression Preconditions:
   * The string is nonempty, and the strings follow basic formatting guidelines
   * Postconditions: A fraction object is returned, whose value is that of the
   * input string.
   */

  public static Fraction eval0(String input)
    throws Exception
  {
    boolean isFrac = false; // true when value is a fraction (only used in
                            // special cases)
    boolean storeMode = false; // true when value is being stored to the
                               // register
    boolean noSkip = true; // true when parts of the program shouldn't be
                           // skipped (only false in special cases)
    boolean isNegative = false; // true when the number we are dealing with is
                                // negative
    boolean hasValue = false; // true when we already have a fractional value
                              // (only true in special cases)

    input = input.trim();
    StringBuilder fractionNum = new StringBuilder();
    StringBuilder fractionDenom = new StringBuilder();
    Fraction frac1 = new Fraction(0, 1);
    Fraction frac2 = new Fraction(0, 1);
    char operation1 = 0;
    int i = 0;
    int regSpot = 0;

    if ((input.charAt(i) == '-') && (input.charAt(i + 1) != ' ')) // checks for
                                                                  // negative
                                                                  // number
      {
        isNegative = true;
        i++;
      }

    if (input.charAt(i) == 'r') // checks for setting register
      {
        regSpot = input.charAt(i + 1) - '0';

        if (i + 3 < input.length() && input.charAt(i + 3) == '=')
          {
            storeMode = true;
            i += 5;
          }// if

        else
          // checks for call to register
          {
            if (register[regSpot] == null)
              {
                throw new Exception("There is no value at register spot " // throws
                                                                          // if
                                                                          // called
                                                                          // slot
                                                                          // is
                                                                          // not
                                                                          // initialized
                                    + regSpot);
              }// if
            frac1.setFrac(register[regSpot].numerator,
                          register[regSpot].denominator);
            noSkip = false;
            if (i + 2 < input.length())
              {
                i += 2;
              }
            hasValue = true;
          }// else
      }

    if ((!Character.isDigit(input.charAt(i)))
        && (!Character.isDigit(input.charAt(i + 1)))
        && (input.charAt(i + 1) != 'r') && (!hasValue))
      {
        throw new Exception("Please enter a valid number for your first value"); // throws
                                                                                 // if
                                                                                 // first
                                                                                 // value
                                                                                 // is
                                                                                 // invalid
      }

    while (i < input.length() && Character.isDigit(input.charAt(i)) && noSkip) // sets
                                                                               // first
                                                                               // number
                                                                               // as
                                                                               // fracNum
      {
        fractionNum.append(input.charAt(i));
        i++;
      }// while

    if (i == input.length() && storeMode) // Stores to register in special case
                                          // - (single number being stored)
      {
        frac1.setFrac(Integer.parseInt(fractionNum.toString()), 1);
        if (isNegative)
          {
            frac1.numerator *= -1;
            isNegative = false;
          }
        register[regSpot] = frac1;
      }// if

    if (i < input.length() && noSkip) // Checks for fractions if valid to do so
      {
        if (input.charAt(i) == '/')
          {
            isFrac = true;
            i++;
            while (i < input.length() && Character.isDigit(input.charAt(i)))
              {
                fractionDenom.append(input.charAt(i));
                i++;
              }// while
            if (i < input.length())
              {
                if (input.charAt(i) == '/')// throws exception for a fraction of
                                           // form "x/y/z"
                  {
                    throw new Exception(
                                        "You cannot make a fraction with two divisions! See location "
                                            + i);
                  }// if
              }// if
            frac1.setFrac(Integer.parseInt(fractionNum.toString()),
                          Integer.parseInt(fractionDenom.toString()));
          }// if
        else
          {
            frac1.setFrac(Integer.parseInt(fractionNum.toString()), 1); // Makes
                                                                        // integer
                                                                        // values
                                                                        // into
                                                                        // fractions
          }// else
      }// if

    if (i >= input.length() && !isFrac)
      {
        frac1.setFrac(Integer.valueOf(fractionNum.toString()), 1);
      }
    if (isNegative)
      {
        frac1.numerator *= -1;
        if (i >= input.length())
          {
            return frac1;
          }
      }

    noSkip = true; // Resets some boolean values
    isNegative = false;
    hasValue = false;
    if (i >= input.length())
      {
        if (isFrac)
          {
            return frac1;
          }
        frac1.setFrac(Integer.valueOf(fractionNum.toString()), 1);
        return frac1;
      }
    while (i < input.length())
      {
        fractionNum.setLength(0); // Resets numerator and denominator to use
                                  // later
        fractionDenom.setLength(0);

        if (i < input.length() - 2)
          {
            i++; // jump to the operation
            operation1 = (input.charAt(i));
            if (input.charAt(i + 1) != ' ') // Throws exception if there is no
                                            // space after operation
              throw new Exception(
                                  "Please enter a space between operations and operands.");
            i = i + 2; // jump to the next number
          }// if

        if ((!Character.isDigit(input.charAt(i)))
            && (!Character.isDigit(input.charAt(i + 1)))
            && (input.charAt(i + 1) != 'r'))
          {
            throw new Exception("Invalid value entered at position " + i); // Throws
                                                                           // exception
                                                                           // if
                                                                           // non-first
                                                                           // input
                                                                           // is
                                                                           // invalid
          }

        if ((input.charAt(i) == '-') && (input.charAt(i + 1) != ' ')) // checks
                                                                      // for
                                                                      // negative
                                                                      // number
          {
            isNegative = true;
            i++;
          }

        if (input.charAt(i) == 'r') // Checks for calls to register and
                                    // attempted assignments to register
          {
            regSpot = input.charAt(i + 1) - '0';

            if (i + 3 < input.length())
              {
                if (input.charAt(i + 3) == '=')
                  {
                    throw new Exception( // throws if register assignment is
                                         // attempted too late
                                        "To assign values to a register, please enter the desired register at the start of the expression");
                  }// if
              }// if
            if (register[regSpot] == null)
              {
                throw new Exception("There is no value at register spot " // Throws
                                                                          // if
                                                                          // called
                                                                          // register
                                                                          // is
                                                                          // empty
                                    + regSpot);
              }// if
            frac2.setFrac(register[regSpot].numerator,
                          register[regSpot].denominator);
            noSkip = false;
            i += 2;

          }// if

        while (i < input.length() && Character.isDigit(input.charAt(i)) // Assigns
                                                                        // values
                                                                        // to
                                                                        // fractionNum
               && noSkip)
          {
            fractionNum.append(input.charAt(i));
            i++;
          }// while
        if (i == input.length() && noSkip) // Turns an integer at the end of the
                                           // input string into a fraction
          {
            frac2.setFrac(Integer.parseInt(fractionNum.toString()), 1);
          }// if

        if (i < input.length() && noSkip) // Checks if the input is a fraction
          {
            if (input.charAt(i) == '/')
              {
                i++;
                while (i < input.length() && Character.isDigit(input.charAt(i)))
                  {
                    fractionDenom.append(input.charAt(i));
                    i++;
                  }// while
                if (i < input.length())
                  {
                    if (input.charAt(i) == '/') // throws exception for a
                                                // fraction
                                                // of form "x/y/z"
                      {
                        throw new Exception(
                                            "You cannot make a fraction with two divisions! See location "
                                                + i);
                      }// if

                  }// if
                frac2.setFrac(Integer.parseInt(fractionNum.toString()), // creates
                              // fraction
                              // object
                              Integer.parseInt(fractionDenom.toString()));
              }// if
            else
              // turns integer into a fraction
              {
                frac2.setFrac(Integer.parseInt(fractionNum.toString()), 1);
              }// else
          }// if

        if (isNegative)
          {
            frac2.numerator *= -1;
          }

        noSkip = true; // reset boolean values for later use
        isNegative = false;

        if (operation1 == '+') // Perform arithmetic on fractional values
          {
            frac1.add(frac2);
          }// if
        if (operation1 == '-')
          {
            frac2.numerator = frac2.numerator * -1;
            frac1.add(frac2);
          }// if
        if (operation1 == '*')
          {
            frac1.mult(frac2);
          }// if
        if (operation1 == '/')
          {
            frac2.flip();
            frac1.mult(frac2);
          }// if

        frac2.numerator = 0; // resets fields of frac2 for later use
        frac2.denominator = 1;

      }// while
    if (storeMode == true)
      {
        register[regSpot] = frac1;
      }// if

    return frac1;

  }// eval0

  public static void main(String[] args)
    throws Exception
  {
    register[0] = new Fraction(2, 1);
    eval0("r0 * r0");
  }// main

}// Calculator

// http://stackoverflow.com/questions/5585779/how-to-convert-string-to-int-in-java
// http://stackoverflow.com/questions/13252903/i-need-to-convert-an-int-variable-to-double
// http://stackoverflow.com/questions/3878192/converting-from-integer-to-biginteger
// http://stackoverflow.com/questions/4009198/java-get-greatest-common-divisor
// http://stackoverflow.com/questions/2627371/java-charat-convert-to-int
