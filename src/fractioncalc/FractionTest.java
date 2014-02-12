package fractioncalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest
{

  @Test
  public void showFracTest()
  {
    Fraction frac1 = new Fraction (12,3);
    assertEquals("ShowFrac Case 1", "4/1", frac1.showFrac());
    Fraction frac2 = new Fraction (-24,8);
    assertEquals("ShowFrac Case 2", "-3/1", frac2.showFrac());
  }
  
  @Test
  public void setFracTest()
  {
    Fraction frac1 = new Fraction (12,3);
    frac1.setFrac(2, 3);
    assertEquals("SetFrac Case 1", "2/3", frac1.showFrac());
    Fraction frac2 = new Fraction (-24,8);
    frac2.setFrac(-9,7);
    assertEquals("SetFrac Case 2", "-9/7", frac2.showFrac());
    Fraction frac3 = new Fraction (0,1);
    frac3.setFrac(94,5);
    assertEquals("SetFrac Case 3", "94/5", frac3.showFrac());
  }
  
  @Test
  public void numeratorTest()
  {
    Fraction frac1 = new Fraction (4,1);
    Fraction frac2 = new Fraction (-4,1);
    Fraction frac3 = new Fraction (0,1);
    assertEquals("Numerator Case 1", 4, frac1.numerator());
    assertEquals("Numerator Case 2", -4, frac2.numerator());
    assertEquals("Numerator Case 3", 0, frac3.numerator());
  }
  
  @Test
  public void denominatorTest()
  {
    Fraction frac1 = new Fraction (12,3);
    Fraction frac2 = new Fraction (-25,-8);
    Fraction frac3 = new Fraction (0,1);
    assertEquals("Denominator Case 1", 1, frac1.denominator());
    assertEquals("Denominator Case 2", 8, frac2.denominator());
    assertEquals("Denominator Case 3", 1, frac3.denominator());  
  }
  
  @Test
  public void scaleTest()
  {
    Fraction frac1 = new Fraction (12,3);
    Fraction frac2 = new Fraction (-24,-8);
    Fraction frac3 = new Fraction (0,1);
    frac1.scale(3);
    frac2.scale(-1);
    frac3.scale(45);     
    assertEquals("Scale Case 1", "12/3", frac1.showFrac());
    assertEquals("Scale Case 2", "-3/-1", frac2.showFrac());
    assertEquals("Scale Case 3", "0/45", frac3.showFrac());
  }
  
  @Test
  public void decimalTest()
  {
    Fraction frac1 = new Fraction (12,3);
    Fraction frac2 = new Fraction (-24,-7);
    Fraction frac3 = new Fraction (0,1);
    assertEquals("Decimal Case 1", 4.0, frac1.decimal(), .01);
    assertEquals("Decimal Case 2", 3.428, frac2.decimal(), .01);
    assertEquals("Decimal Case 3", 0.0, frac3.decimal(), .01);  
  }
  
  @Test
  public void addTest()
  {
    Fraction frac1 = new Fraction (1,2);
    Fraction frac2 = new Fraction (2,3);
    Fraction frac3 = new Fraction (5,8);
    Fraction frac4 = new Fraction (5,8);
    frac3.add(frac1);
    frac1.add(frac2);
    frac2.add(frac4);
    assertEquals("Add Case 1", "7/6", frac1.showFrac());
    assertEquals("Add Case 2", "31/24", frac2.showFrac());
    assertEquals("Add Case 3", "9/8", frac3.showFrac());
  }
  
  @Test
  public void multTest()
  {
    Fraction frac1 = new Fraction (1,2);
    Fraction frac2 = new Fraction (2,3);
    Fraction frac3 = new Fraction (5,8);
    frac1.mult(frac1);
    frac2.mult(frac1);
    frac3.mult(frac1);
    assertEquals("Mult Case 1", "1/4", frac1.showFrac());
    assertEquals("Mult Case 2", "1/6", frac2.showFrac());
    assertEquals("Mult Case 3", "5/32", frac3.showFrac());
  }
  
  @Test
  public void flipTest()
  {
    Fraction frac1 = new Fraction (1,2);
    Fraction frac2 = new Fraction (2,3);
    Fraction frac3 = new Fraction (5,8);
    frac1.flip();
    frac2.flip();
    frac3.flip();
    assertEquals("Mult Case 1", "2/1", frac1.showFrac());
    assertEquals("Mult Case 2", "3/2", frac2.showFrac());
    assertEquals("Mult Case 3", "8/5", frac3.showFrac());    
  }
  
  @Test
  public void simplifyTest()
  {
    Fraction frac1 = new Fraction (10,20);
    Fraction frac2 = new Fraction (6,8);
    Fraction frac3 = new Fraction (1,2);
    assertEquals("Simplify Case 1", "1/2", frac1.showFrac());
    assertEquals("Simplify Case 2", "3/4", frac2.showFrac());
    assertEquals("Simplify Case 3", "1/2", frac3.showFrac());
  }

}
