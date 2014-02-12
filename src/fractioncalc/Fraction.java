package fractioncalc;

import java.math.BigInteger;

public class Fraction
{

  // +--------+---------------------------------------------------------
  // | Fields |
  // +--------+

  int numerator;
  int denominator;

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new rational with given values (two ints or a
   * decimal)(Constructor)
   */
  public Fraction(int num, int denom)
  {
    this.numerator = num;
    this.denominator = denom;
    this.simplify();
  }

  public Fraction(double decimal)
  {
    // STUB
  }

  // +---------+--------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Displays the rational (Observer)
   */
  public String showFrac()
  {
    return (this.numerator + "/" + this.denominator);
  }

  /**
   * Get the numerator of this rational number. (Observer)
   */
  
  public void setFrac(int num, int denom)
  {
    this.numerator = num;
    this.denominator = denom;
    this.simplify();
  }
  
  public int numerator()
  {
    return this.numerator;
  } // numerator

  /**
   * Get the denominator of the rational number. (Observer)
   */
  public int denominator()
  {
    return this.denominator;
  } // denominator

  /**
   * Divide the numerator and denominator by any factors they share to simplify
   * the rational (Mutator)
   */
  public void simplify()
  {
    if ((this.numerator < 0 && this.denominator < 0) || (this.numerator >= 0 && this.denominator < 0))
      {
        this.scale(-1);
      }
    BigInteger bigNum = BigInteger.valueOf(this.numerator);
    BigInteger bigDenom = BigInteger.valueOf(this.denominator);
    int gcd = bigNum.gcd(bigDenom).intValue();
    this.numerator = this.numerator / gcd;
    this.denominator = this.denominator / gcd;
    
    
  } // simplify

  /**
   * Multiply the numerator and denominator by input value. (Mutator)
   */
  public void scale(int factor)
  {
    this.numerator = this.numerator * factor;
    this.denominator = this.denominator * factor;
  }// scale

  /**
   * Gives the decimal equivalent of a rational number. (Observer)
   */
  public double decimal()
  {
    double output = (double) this.numerator / (double) this.denominator;
    return output;
  } // decimal

  /**
   * Add the provided rational to the rational. (Mutator)
   */
  public void add(Fraction rational)
  {
    int tempNum;
    tempNum = rational.numerator * this.denominator;
    this.denominator = this.denominator * rational.denominator;
    this.numerator = this.numerator * rational.denominator;   
    this.numerator += tempNum;
    this.simplify();
  }

  /**
   * Multiply the provided rational into the rational (Mutator)
   */
  public void mult(Fraction rational)
  {
    this.numerator = this.numerator * rational.numerator;
    this.denominator = this.denominator * rational.denominator;
    this.simplify();
  }

  /**
   * Flip this rational number, switching numerator and denominator. (Mutator)
   */
  public void flip()
  {
    int temp = this.numerator;
    this.numerator = this.denominator;
    this.denominator = temp;
  }// flip

  public static void main(String[] args)
  {
    // Desired calls to do things
  }

}
