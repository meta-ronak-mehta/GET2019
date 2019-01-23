import static org.junit.Assert.*;
import org.junit.Test;


public class TestNQueenProblem {
    
    private NQueenProblem Queen;
    private int a[][];
    
    // Test for n=4 Queen expected true 
    @Test
    public void test1(){
        Queen = new NQueenProblem(); 
        assertEquals(true,Queen.nQueen(a,0,4)); 
    }
    
    // Test for n=8 Queen expected true 
    @Test
    public void test2(){
        Queen = new NQueenProblem(); 
        assertEquals(true,Queen.nQueen(a,0,8)); 
    }
    
    // Test for n=1 Queen expected true 
    @Test
    public void test3(){
        Queen = new NQueenProblem(); 
        assertEquals(true,Queen.nQueen(a,0,1)); 
    }
    
    // Test for n=2 Queen expected false 
    @Test
    public void test4(){
        Queen = new NQueenProblem(); 
        assertEquals(false,Queen.nQueen(a,0,2)); 
    }
    
    // Test for n=3 Queen expected false 
    @Test
    public void test5(){
        Queen = new NQueenProblem(); 
        assertEquals(false,Queen.nQueen(a,0,3)); 
    }

}
