package metacube;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestIntset{
    
    private int []inputArray;
    private IntSet inputSet;
    private int []anotherArray;
    private IntSet anotherSet;

    // Test 1: value is at 1st position
    @Test
    public void testIsMember() {       
        inputArray= new int[]{20,40,60,80,100,120};
        inputSet = new IntSet(inputArray);;
        assertEquals(true, inputSet.isMember(20));       
    }

    // Test 2: value is at random position
    @Test
    public void testIsMember2() {       
        inputArray= new int []{20,40,60,80,100,120};
        inputSet=new IntSet(inputArray);;
        assertEquals(true, inputSet.isMember(60));       
    }
    
    // Test 3: value is at last position
    @Test
    public void testIsMember3() {       
        inputArray= new int[]{20,40,60,80,100,120};
        IntSet inputSet=new IntSet(inputArray);;
        assertEquals(true, inputSet.isMember(120));       
    }
    
    // Test 5: array is empty
    @Test(expected=AssertionError.class)
    public void testIsMember4() { 
        inputArray=new int[]{};
        inputSet=new IntSet(inputArray);;
        assertEquals(true, inputSet.isMember(60));        
    }
    
    // Test 6: value is not in Array
    @Test
    public void testIsMember5() {        
        inputArray= new int[]{20,40,60,80,100,120};
        inputSet=new IntSet(inputArray);;
        assertEquals(false, inputSet.isMember(160));        
    }
    
    //Test 1: Array has Some Value
    @Test
    public void testSize1() {       
        inputArray= new int[]{20,40,60,80,100,120};
        inputSet=new IntSet(inputArray);
        assertEquals(6, inputSet.getSetSize());       
    }
    
    //Test 2: Array  is Empty
    @Test(expected=AssertionError.class)
    public void testSize2() {        
        inputArray= new int[]{};
        inputSet=new IntSet(inputArray);
        assertEquals(0, inputSet.getSetSize());
        
    }
    
    //Test 1: array is sub set
    @Test
    public void testIsSubSet() {        
        inputArray= new int []{20,40,60,80,100,120};
        inputSet=new IntSet(inputArray);
        anotherArray=new int[]{40,60,80};
        anotherSet=new IntSet(anotherArray);
        assertEquals(true, inputSet.isSubSet(anotherSet));
    }
    
    //Test 2: array is not a subset
    @Test
    public void testIsSubSet2() {        
        inputArray= new int []{20,40,60,80,100,120};
        inputSet=new IntSet(inputArray);
        anotherArray=new int[]{10,40,60,80};
        anotherSet=new IntSet(anotherArray);
        assertEquals(false, inputSet.isSubSet(anotherSet));
    }
    
    //Test 3: array is empty
    @Test(expected=AssertionError.class)
    public void testIsSubSet3() {       
        inputArray= new int[] {};
        inputSet=new IntSet(inputArray);
        anotherArray=new int[]{40,60,80};
        anotherSet=new IntSet(anotherArray);
        assertEquals(true, inputSet.isSubSet(anotherSet));        
    }

    //Test 1: array has some value
    @Test
    public void testComplement1() {
        inputArray= new int []{20,40,60};
        inputSet=new IntSet(inputArray);
        anotherArray=new int[IntSet.MAX_VALUE - inputArray.length+1];
        for(int i=0, j=0 ; i <= IntSet.MAX_VALUE ; i++){
            if(! inputSet.isMember(i)){
                anotherArray[j]=i;
                j++;
            }
        }
        assertArrayEquals(anotherArray, inputSet.complementedSet());     
    }

    //Test 2: Array is empty
    @Test(expected=AssertionError.class)
    public void testComplement2() {
        inputArray= new int[]{};
        inputSet=new IntSet(inputArray);
        int []expectedArray= {980,960,940};
        assertArrayEquals(expectedArray, inputSet.complementedSet());    
    }
    
    //Test 3: both Array has some value
    @Test(expected=AssertionError.class)
    public void testUnion() {     
        inputArray=new int[] {};
        inputSet=new IntSet(inputArray);
        anotherArray= new int []{20,40,60};
        anotherSet=new IntSet(anotherArray);
        Integer []expectedArray= {20,40,60,20,40,60};
        assertArrayEquals(expectedArray, inputSet.unionOfSet(anotherSet).toArray());        
    }
    
    // Test 4: One array is empty
    @Test
    public void testUnion2() {
        
        int []inputArray= {20,40,60};
        IntSet inputSet1=new IntSet(inputArray);
        int []inputArray2= {};
        IntSet inputSet2=new IntSet(inputArray2);
        Integer []expectedArray= {20,40,60};
        assertArrayEquals(expectedArray, inputSet1.unionOfSet(inputSet2).toArray());
        
    }
    
}
