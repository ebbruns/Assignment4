package fractioncalc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;

public class CalculatorTest
{

  @Test
  public void evalArrayTest() throws ArrayComparisonFailure, Exception
  {
    Fraction frac1 = new Fraction (1,2);
    Fraction frac2 = new Fraction (3,4);
    Fraction frac3 = new Fraction (5,7);
    Fraction[] fracArray = {frac1,frac2,frac3};
    String[] stringArray = {"1/2 * 2 - 1/2", "-1/4 + 1", "1 - 4/14"};
    assertEquals(true, Arrays.deepEquals(fracArray, Calculator.evalArray(stringArray)));
  }

}


//http://stackoverflow.com/questions/8051084/java-how-to-test-on-array-equality