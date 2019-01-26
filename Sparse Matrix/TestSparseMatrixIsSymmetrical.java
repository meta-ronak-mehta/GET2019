import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSparseMatrixIsSymmetrical {
    
    private SparseMatrixOperation sparseMatrix;
    private boolean expectedResult;
    
    //Constructor
    public TestSparseMatrixIsSymmetrical(boolean expectedResult,int sparseMatrix[][],int maxRow,int maxCol) {
        this.expectedResult=expectedResult;
        this.sparseMatrix=new SparseMatrixOperation(sparseMatrix,maxRow,maxCol);
    }
    
    // parameter passing
    @Parameters(name = "")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {false,new int[][]{{1,2,5},{3,4,15}},3,4},
                {true,new int[][]{{0,1,5},{1,0,5}},1,1},
                
        });
    }
    
    //Test for sparse Matrix is Symmetric or not
    @Test
    public void test() {
        assertEquals(expectedResult,this.sparseMatrix.isSymmetrical());        
    }

}
