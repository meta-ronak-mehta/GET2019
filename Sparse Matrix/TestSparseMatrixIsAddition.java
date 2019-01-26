import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSparseMatrixIsAddition {

    private SparseMatrixOperation sparseMatrix1;
    private SparseMatrixOperation sparseMatrix2;
    private SparseMatrixOperation sparseMatrixSum;
    
    //Constructor
    public TestSparseMatrixIsAddition(int sparseMatrixSum[][], int sparseMatrix1[][],int maxRow1,int maxCol1,int sparseMatrix2[][],int maxRow2,int maxCol2) {
        this.sparseMatrix1=new SparseMatrixOperation(sparseMatrix1,maxRow1,maxCol1);
        this.sparseMatrix2=new SparseMatrixOperation(sparseMatrix2,maxRow2,maxCol2);
        this.sparseMatrixSum=new SparseMatrixOperation(sparseMatrixSum,maxRow1,maxCol1);
    }
    
    // parameter passing
    @Parameters(name = "")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{{1,2,7},{3,3,15},{3,4,15}}, new int[][]{{1,2,2},{3,3,15}},3,4, new int[][]{{1,2,5},{3,4,15}},3,4},
                {new int[][]{{1,2,0},{3,3,15},{3,4,15}}, new int[][]{{1,2,2},{3,3,15}},3,4, new int[][]{{1,2,-2},{3,4,15}},3,4},
                {new int[][]{{1,2,2},{3,3,15}}, new int[][]{{1,2,1},{3,3,7}},3,4, new int[][]{{1,2,1},{3,3,8}},3,4},
                {new int[][]{{1,2,2},{3,3,15}}, new int[][]{{1,2,2}},3,4, new int[][]{{3,3,15}},3,4}
        });
                
    }
    
    //Test for sparse Matrix Addition
    @Test
    public void test() {  
        assertArrayEquals(this.sparseMatrixSum.to2DArray(),this.sparseMatrix1.add(this.sparseMatrix2).to2DArray());
    }
}
