import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrOperation {
    int a[],b[];

    @Test
    public void splitTest1(){
        a = new int[] {1,1,1,2,1};
        ArrOperation array= new ArrOperation(a);
        assertEquals(3, array.splitArray());
    }
    @Test
    public void splitTest2(){
        a = new int[] {2, 1, 1, 2, 1};
        ArrOperation array= new ArrOperation(a);
        assertEquals(-1, array.splitArray());
    }
    @Test
    public void splitTest3(){
        a = new int[] {10, 10};
        ArrOperation array= new ArrOperation(a);
        assertEquals(1, array.splitArray());
    }

    /*
     * Empty Array Test Case
     */
    @Test (expected = AssertionError.class) 
    public void splitTest4(){
        a = new int[] {};
        ArrOperation array= new ArrOperation(a);
        assertEquals(3, array.splitArray());
    }
    
    @Test
    public void TestCountClumps1(){
        a = new int[] {1, 2, 2, 3, 4, 4};
        ArrOperation array=new ArrOperation(a);
        assertEquals(2,array.countClumps());
    }
    @Test
    public void TestCountClumps2(){
        a = new int[] {1, 1, 2, 1, 1};
        ArrOperation array=new ArrOperation(a);
        assertEquals(2,array.countClumps());
    }
    @Test
    public void TestCountClumps3(){
        a = new int[] {1, 1, 1, 1, 1};
        ArrOperation array=new ArrOperation(a);
        assertEquals(1,array.countClumps());
    }
    
    /*
     * Empty Array Test Case
     */
    @Test (expected = AssertionError.class) 
    public void TestCountClumps4(){
        a = new int[] {};
        ArrOperation array=new ArrOperation(a);
        assertEquals(1,array.countClumps());
    }
    
    @Test
    public void TestfitXY1(){
        a = new int[] {5, 4, 9, 4, 9, 5};
        ArrOperation array=new ArrOperation(a);
        b = new int[]{9, 4, 5, 4, 5, 9};
        assertArrayEquals(b, array.fitXY(4,5));
    }
    @Test
    public void TestfitXY2(){
        a = new int[] {1, 4, 1, 5};
        ArrOperation array=new ArrOperation(a);
        b = new int[]{1, 4, 5, 1};
        assertArrayEquals(b, array.fitXY(4,5));
    }
    @Test
    public void TestfitXY3(){
        a = new int[] {1, 4, 1, 5, 5, 4, 1};
        ArrOperation array=new ArrOperation(a);
        b = new int[] {1, 4, 5, 1, 1, 4, 5};
        assertArrayEquals(b, array.fitXY(4,5));
    }
    
    /*
     * Empty Array Test Case
     */
    @Test (expected = AssertionError.class) 
    public void TestfitXY4(){
        a = new int[] {};
        ArrOperation array=new ArrOperation(a);
       b = new int[] {1, 4, 5, 1, 1, 4, 5};
        assertArrayEquals(b, array.fitXY(4,5));
    }
    /*
     * unequal no of X and Y
     */
    @Test(expected = AssertionError.class) 
    public void TestfitXY5(){
        a = new int[] {1, 4, 1, 2, 5, 4, 1};
        ArrOperation array=new ArrOperation(a);
        b = new int []{1, 4, 5, 1, 1, 4, 5};
        assertArrayEquals(b, array.fitXY(4,5));
    }
    /*
     * two adjacent X values are there.
     */
    @Test(expected = AssertionError.class) 
    public void TestfitXY6(){
        a = new int[] {1, 4, 4, 5, 1, 5, 1};
        ArrOperation array=new ArrOperation(a);
        b = new int[] {1, 4, 5, 1, 1, 4, 5};
        assertArrayEquals(b, array.fitXY(4,5));
    }
    /*
     * X occurs at the last index of array.
     */
    @Test(expected = AssertionError.class) 
    public void TestfitXY7(){
        a = new int[] {1, 4, 1, 5, 5, 1, 4};
        ArrOperation array=new ArrOperation(a);
        b = new int[]{1, 4, 5, 1, 1, 4, 5};
        assertArrayEquals(b, array.fitXY(4,5));
    }

    
    @Test
    public void TestmaxMirror1(){
        a = new int[] {1, 2, 3, 8, 9, 3, 2, 1};
        ArrOperation array=new ArrOperation(a);
        assertEquals(3,array.maxMirror());
    }
    @Test
    public void TestmaxMirror2(){
        a = new int[] {7, 1, 4, 9, 7, 4, 1};
        ArrOperation array=new ArrOperation(a);
        assertEquals(2,array.maxMirror());
    } 
    @Test
    public void TestmaxMirror3(){
        a = new int[] {1, 2, 1, 4};
        ArrOperation array=new ArrOperation(a);
        assertEquals(3,array.maxMirror());
    }
    @Test
    public void TestmaxMirror4(){
        a = new int[] {1, 4, 5, 3, 5, 4, 1};
        ArrOperation array=new ArrOperation(a);
        assertEquals(7,array.maxMirror());
    }
   
    /*
     * Empty Array Test Case
     */
    @Test(expected = AssertionError.class) 
    public void TestmaxMirror5(){
        a = new int[] {};
        ArrOperation array=new ArrOperation(a);
        assertEquals(7,array.maxMirror());
    }
    
    
    
 

}
