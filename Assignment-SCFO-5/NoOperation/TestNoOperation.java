import static org.junit.Assert.*;

import org.junit.Test;


public class TestNoOperation {

    // test 1:  for LCM of 65 and 10 expected 130 
    @Test
    public void testLCM1() {
        int result = NoOperation.LCM(65,10);
        assertEquals(130,result);
    }
    
    // test 2:  for LCM of 1 and 10 expected 10 
    @Test
    public void testLCM2() {
        int result = NoOperation.LCM(1,10);
        assertEquals(10,result);
    }
    
    // test 3:  for LCM of 65 and 1 expected 65
    @Test
    public void testLCM3() {
        int result = NoOperation.LCM(65,1);
        assertEquals(65,result);
    }

    // test 4:  for LCM of 1 and 1 expected 1 
    @Test
    public void testLCM4() {
        int result = NoOperation.LCM(1,1);
        assertEquals(1,result);
    }
    
    // test 1:  for HCM of 65 and 10 expected 5 
    @Test
    public void testHCF1() {
        int result = NoOperation.HCF(65,10);
        assertEquals(5,result);
    }
    
    // test 2:  for HCM of 65 and 1 expected 1
    @Test
    public void testHCF2() {
        int result = NoOperation.HCF(65,1);
        assertEquals(1,result);
    }

    // test 3:  for HCM of 10 and 10 expected 10 
    @Test
    public void testHCF3() {
        int result = NoOperation.HCF(10,10);
        assertEquals(10,result);
    }
    
    // test 4:  for HCM of 1 and 1 expected 1 
    @Test
    public void testHCF4() {
        int result = NoOperation.HCF(1,1);
        assertEquals(1,result);
    }

}
