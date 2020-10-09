package junittest4;

import org.junit.Assert;
import org.junit.Test;

import app1.flow1;
 
public class flow1test {
	
    @Test
    public void divide_SixDividedByTwo_ReturnThree() {
        final int expected = 3;
 
        final int actual = flow1.divide(6, 2);
 
        Assert.assertEquals(expected, actual);
    }
 
    @Test
    public void divide_OneDividedByTwo_ReturnZero() {
        final int expected = 0;
 
        final int actual = flow1.divide(1, 2);
 
        Assert.assertEquals(expected, actual);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void divide_OneDividedByZero_ThrowsIllegalArgumentException() {
    	flow1.divide(1, 0);
    }
 
    @Test
    public void add_SixAddedByTwo_ReturnEight() {
        final int expected = 8;
 
        final int actual = flow1.add(6, 2);
 
        Assert.assertEquals(expected, actual);
    }
}
