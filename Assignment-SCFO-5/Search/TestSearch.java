import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSearch {
    int array[];
    
    //Test 1 at Last Position
    @Test
    public void testLinearSearch1() {
        array= new int[] {1,2,3,4,5,6,7,8,9};
        int result = Search.LinearSearch(array,9);
        assertEquals(9,result);
    }
    
    // Test 2 at First Position
    @Test
    public void testLinearSearch2() {
        array= new int[] {1,2,3,4,5,6,7,8,9};
        int result = Search.LinearSearch(array,1);
        assertEquals(1,result);
    }
    
    // Test 3 for value that doesn't exist
    @Test
    public void testLinearSearch3() {
        array= new int[] {1,2,3,4,5,6,7,8,9};
        int result = Search.LinearSearch(array,10);
        assertEquals(-1,result);
    }
    
    // Test 4 for random value that is present in array
    @Test
    public void testLinearSearch4() {
        array= new int[] {1,2,3,4,5,6,7,8,9};
        int result = Search.LinearSearch(array,5);
        assertEquals(5,result);
    }

    // Test 1 at First position
    @Test
    public void testBinarySearch1(){
        array= new int[] {1,2,3,4,5,6,7,8,9};
        int result = Search.binarySearch(array,1);
        assertEquals(1,result);
    }
    
    // Test 2 at last position
    @Test
    public void testBinarySearch2(){
        array= new int[] {1,2,3,4,5,6,7,8,9};
        int result = Search.binarySearch(array,9);
        assertEquals(9,result);
    }
    
    // Test 3 for random value that is present in array
    @Test
    public void testBinarySearch3(){
        array= new int[] {1,2,3,4,5,6,7,8,9};
        int result = Search.binarySearch(array,6);
        assertEquals(6,result);
    }
    
    //Test 4 for value that doesn't exist
    @Test
    public void testBinarySearch4(){
        array= new int[] {0,1,2,3,4,5,6,7,8,9};
        int result = Search.binarySearch(array,91);
        assertEquals(-1,result);
    }
}
