import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestSparseMatrixTranspose {

    private SparseMatrixOperation sparseMatrix1;
    private SparseMatrixOperation sparseMatrixTranspose;
    
    
    //Constructor
    public TestSparseMatrixTranspose(int sparseMatrixTranspose[][], int sparseMatrix1[][],int maxRow1,int maxCol1) {
        this.sparseMatrix1=new SparseMatrixOperation(sparseMatrix1,maxRow1,maxCol1);
        this.sparseMatrixTranspose=new SparseMatrixOperation(sparseMatrixTranspose,maxCol1,maxRow1);
    }
    
    // parameter passing
    @Parameters(name = "")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{{2,1,2},{3,3,15}}, new int[][]{{1,2,2},{3,3,15}},3,3},
                {new int[][]{{4,3,15}}, new int[][]{{1,2,0},{3,4,15}},3,4},
                {new int[][]{{1,3,7},{5,3,6}}, new int[][]{{3,1,7},{3,5,6}},3,5},
                {new int[][]{}, new int[][]{{3,1,0},{3,5,0}},3,5},
                {new int[][]{}, new int[][]{},3,5},
        });
                
    }
    
    //Test for sparse Matrix Transpose
    @Test
    public void test() {  
        assertArrayEquals(this.sparseMatrixTranspose.to2DArray(),this.sparseMatrix1.transpose().to2DArray());
    }
  
}
