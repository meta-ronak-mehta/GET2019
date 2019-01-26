
public class SparseMatrixOperation { 

    private final int MAX = 10000; 
    private final int noOfRow, noOfCol; 
    private int noOfElementInMatrix; 
    private int data[][] = new int[MAX][3]; 

    //Constructor
    public SparseMatrixOperation(int r, int c){ 
        noOfRow = r; 
        noOfCol = c; 
        noOfElementInMatrix = 0; 
    } 

    //Constructor
    public SparseMatrixOperation(int inputMatrix[][],int noOfRow,int noOfCol){
        this.noOfCol=noOfCol;
        this.noOfRow=noOfRow;
        for(int i=0; i <inputMatrix.length ;i++){
            if(inputMatrix[i][2] !=0){
                insert(inputMatrix[i][0],inputMatrix[i][1],inputMatrix[i][2]);
            }
        }
    }
    
    // insert elements into sparse matrix 
    private void insert(int r, int c, int val){ 
        if (r > noOfRow || c > noOfCol) { 
            System.out.println("Wrong entry");
        }
        else { 
            data[noOfElementInMatrix][0] = r; 
            data[noOfElementInMatrix][1] = c; 
            data[noOfElementInMatrix][2] = val; 
            noOfElementInMatrix++; 
        } 
    } 

    /**
     * @return true if the matrix is Symmetric
     */
    public boolean isSymmetrical() {
        boolean result=false;
        int count=0;
        if(this.noOfRow == this.noOfCol) {
            for(int i=0; i < this.noOfElementInMatrix;i++) {
                for(int j=0 ; j<this.noOfElementInMatrix ;j++) {
                    if(this.data[i][0] ==this.data[j][1] && this.data[i][1] ==this.data[j][0] && this.data[i][2] ==this.data[j][2])
                        count++;
                }
            }
            if(count==this.noOfElementInMatrix)
                result=true;
        }
        return result;
    }
    
    /**
     * @param b sparse Matrix to be Added
     * @return Addition of matrix
     */
    public SparseMatrixOperation add(SparseMatrixOperation b){
        
        SparseMatrixOperation result = new SparseMatrixOperation(noOfRow, noOfCol); 
        if (noOfRow != b.noOfRow || noOfCol != b.noOfCol) { 
            System.out.println("Matrices can't be added"); 
        } 
        else { 
            int apos = 0, bpos = 0; 

            while (apos < noOfElementInMatrix && bpos < b.noOfElementInMatrix) { 
                // if b's noOfRow and noOfCol is smaller - > insert smaller value into result 
                if (data[apos][0] > b.data[bpos][0] || (data[apos][0] == b.data[bpos][0] && data[apos][1] > b.data[bpos][1])){ 
                    result.insert(b.data[bpos][0], b.data[bpos][1], b.data[bpos][2]); 
                    bpos++; 
                } 
                // if a's noOfRow and noOfCol is smaller ->  insert smaller value into result 
                else if (data[apos][0] < b.data[bpos][0] || (data[apos][0] == b.data[bpos][0] && data[apos][1] < b.data[bpos][1])){ 
                    result.insert(data[apos][0], data[apos][1],data[apos][2]); 
                    apos++; 
                } 
                else { 
                    // add the values as noOfRow and noOfCol is same 
                    int addedval = data[apos][2] + b.data[bpos][2]; 
                    if (addedval != 0) 
                        result.insert(data[apos][0], data[apos][1],addedval); 
                    apos++; 
                    bpos++; 
                } 
            } 
            // insert remaining elements 
            while (apos < noOfElementInMatrix) 
                result.insert(data[apos][0], data[apos][1], data[apos++][2]); 

            while (bpos < b.noOfElementInMatrix) 
                result.insert(b.data[bpos][0],b.data[bpos][1],b.data[bpos++][2]); 
        }
        return result;
    } 

    /**
     * @return Transpose Sparse matrix
     */
    public SparseMatrixOperation transpose(){ 
        SparseMatrixOperation result = new SparseMatrixOperation(noOfCol, noOfRow); 
        result.noOfElementInMatrix = noOfElementInMatrix; 
        // to count number of elements in each noOfColumn 
        int count[] = new int[noOfCol + 1]; 

        for (int i = 0; i < noOfElementInMatrix; i++) 
            count[data[i][1]]++; 

        int[] index = new int[noOfCol + 1]; 

        // to count number of elements having noOfCol smaller than particular i 
        // there is no noOfCol with value < 1 
        index[1] = 0; 

        // initialize rest of the indices 
        for (int i = 2; i <= noOfCol; i++) 
            index[i] = index[i - 1] + count[i - 1]; 

        for (int i = 0; i < noOfElementInMatrix; i++) { 
            int rpos = index[data[i][1]]++; 
            result.data[rpos][0] = data[i][1]; 
            result.data[rpos][1] = data[i][0]; 
            result.data[rpos][2] = data[i][2]; 
        } 
        // sorted Transpose Matrix
        return result; 
    } 

    /**
     * @param b sparse Matrix to be Multiplied
     * @return Multiplied Sparse Matrix
     */
    public SparseMatrixOperation multiply(SparseMatrixOperation b){ 
        if (noOfCol != b.noOfRow) { 
            System.out.println("Can't multiply, "+ "Invalid dimensions"); 
            return null; 
        } 
        // transpose b to compare noOfRow and noOfCol values and to add them at the end 
        b = b.transpose(); 
        int apos, bpos; 
        SparseMatrixOperation result = new SparseMatrixOperation(noOfRow, b.noOfRow); 

        for (apos = 0; apos < noOfElementInMatrix;) { 
            // current noOfRow of result matrix 
            int currentRow = data[apos][0]; 
            for (bpos = 0; bpos < b.noOfElementInMatrix;) { 
                int currentCol = b.data[bpos][0]; 
                // temporary pointers created to add all multiplied values to obtain current element of result matrix 
                int tempa = apos; 
                int tempb = bpos; 
                int sum = 0; 

                // iterate over all elements with same noOfRow and noOfCol value to calculate result[r] 
                while (tempa < noOfElementInMatrix && data[tempa][0] == currentRow && tempb < b.noOfElementInMatrix && b.data[tempb][0] == currentCol) { 
                    if (data[tempa][1] < b.data[tempb][1]) 
                        // skip a 
                        tempa++; 
                    else if (data[tempa][1] > b.data[tempb][1]) 
                        // skip b 
                        tempb++; 
                    else
                        // same noOfCol, so multiply and increment 
                        sum += data[tempa++][2] * b.data[tempb++][2]; 
                }  
                if (sum != 0) 
                    result.insert(currentRow, currentCol, sum); 
                while (bpos < b.noOfElementInMatrix && b.data[bpos][0] == currentCol) 
                    // jump to next noOfColumn 
                    bpos++; 
            } 
            while (apos < noOfElementInMatrix && data[apos][0] == currentRow) 
                // jump to next noOfRow 
                apos++; 
        }
        return result;
    } 

    /**
     * @return sparse Matrix in Triplet Form
     */
    public int[][] to2DArray(){
        int result[][] = new int [3][noOfElementInMatrix];
        for(int i=0; i < noOfElementInMatrix ;i++) {
            result[0][i] = data[0][i];
            result[1][i] = data[1][i];
            result[2][i] = data[2][i];
        }
        return result;
    }
    
    /**
     * to print Sparse Matrix in Matrix Form
     */
    private void print(){ 
        int k=0;
        for(int i=0; i<= noOfRow; i++){
            for(int j=0; j<=noOfCol ;j++){
                if(k < this.data.length && this.data[k][0]==i && this.data[k][1]==j){
                    System.out.print(" "+data[k][2]);
                    k++;
                }
                else
                    System.out.print(" 0");
            }
            System.out.println();
        }
    }

    /**
     * to print Sparse Matrix in Triplet Form
     */
    private void printSparseMatrixFormat(){
      System.out.println("Dimension: " + noOfRow + "x" + noOfCol); 
      System.out.println("Sparse Matrix: \nnoOfRow noOfColumn Value"); 
      for (int i = 0; i < noOfElementInMatrix; i++) { 
          System.out.println(data[i][0] + " "+ data[i][1] + " " + data[i][2]); 
      }   
    }
} 

