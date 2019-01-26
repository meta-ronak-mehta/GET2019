import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSparseMatrixIsMultiplication {

    private SparseMatrixOperation sparseMatrix1;
    private SparseMatrixOperation sparseMatrix2;
    private SparseMatrixOperation sparseMatrixMul;
    
    
    //Constructor
    public TestSparseMatrixIsMultiplication(int sparseMatrixMul[][], int sparseMatrix1[][],int maxRow1,int maxCol1,int sparseMatrix2[][],int maxRow2,int maxCol2) {
        this.sparseMatrix1=new SparseMatrixOperation(sparseMatrix1,maxRow1,maxCol1);
        this.sparseMatrix2=new SparseMatrixOperation(sparseMatrix2,maxRow2,maxCol2);
        this.sparseMatrixMul=new SparseMatrixOperation(sparseMatrixMul,maxRow1,maxCol1);
    }
    // parameter passing
    @Parameters(name = "")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{{1,2,10}}, new int[][]{{1,2,2}},3,4, new int[][]{{2,2,5}},4,3},
                {new int[][]{{1,1,25},{1,2,10},{2,1,25}}, new int[][]{{1,2,2},{1,3,5},{2,3,5}},3,4, new int[][]{{2,2,5},{3,1,5}},4,3},
                {new int[][]{{1,1,35},{1,2,8},{3,3,345}}, new int[][]{{1,1,2},{1,2,5},{1,3,3},{3,4,15}},3,4, new int[][]{{1,2,4},{2,1,7},{4,3,23}},4,3}
        });
    }
    
    //Test for sparse Matrix Multiplication
    @Test
    public void test() {
        this.sparseMatrix1.multiply(this.sparseMatrix2);
        assertArrayEquals(this.sparseMatrixMul.to2DArray(),this.sparseMatrix1.multiply(this.sparseMatrix2).to2DArray());
    }
}
