package metacube;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPoly {
    
    private int polyArray1[];
    private int polyArray2[];
    private int valueOfX;
    
    private Poly polynomial1; 
    private Poly polynomial2;
    
    private int resultAdd[];
    private int resultMul[];
    private Poly polyResultAdd;
    private Poly polyResultMul;
    private float evaluateExpected;
    private int getDegreeExpected;
    
    
    public TestPoly(int inputArray1[], int inputArray2[], int x,int addArray[],int mulArray[],int evaluate,int degree ) {
        this.polyArray1=inputArray1;
        this.polyArray2=inputArray2;
        this.valueOfX=x;
        this.resultAdd=addArray;
        this.resultMul=mulArray;
        this.evaluateExpected=evaluate;
        this.getDegreeExpected=degree;
        
        this.evaluateExpected=evaluate;
        this.getDegreeExpected=degree;
        this.polynomial1 =new Poly(polyArray1); 
        this.polynomial2 =new Poly(polyArray2);
        this.polyResultAdd =new Poly(resultAdd);
        this.polyResultMul =new Poly(resultMul);
    }
        
    @Parameters(name = "")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,0,3,4,4}, new int[] {2,4,2,0,4,2}, 2,new int[] {3,4,5,4,8,2}, new int[]{2,4,8,20,34,26,20,22,24,8}, 109, 4},
                {new int[]{1,1}, new int[] {2,2,2}, 1,new int[] {3,3,2}, new int[]{2,4,4,2},2,1},
                {new int[]{0,1,3}, new int[] {1}, 1,new int[] {1,1,3}, new int[]{0,1,3},4,2},
                {new int[]{0,1}, new int[] {2}, 10,new int[] {2,1}, new int[]{0,2,},10,1},
        });
                
    }
    
    @Test
    public void test() {
        assertEquals(evaluateExpected, polynomial1.evaluate(valueOfX), 0);
        assertEquals(getDegreeExpected, polynomial1.getDegree());
        assertEquals(polyResultAdd.convertToString(),polynomial1.addPoly(polynomial2).convertToString());
        assertEquals(polyResultMul.convertToString(),polynomial1.multiplyPoly(polynomial2).convertToString());
    }

}
