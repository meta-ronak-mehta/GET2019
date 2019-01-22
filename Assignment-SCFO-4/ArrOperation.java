import java.util.Arrays;


public class ArrOperation {

    private int array[];
    private int length=0;

    AssertionError arrayIsEmpty =new AssertionError("Array is Empty");
    AssertionError unequalXY =new AssertionError("there are unequal numbers of X and Y in input array");
    AssertionError AdjacentsX =new AssertionError("two Adjacent X values are there");
    AssertionError xAtLastIndex =new AssertionError("X occurs at the last index of array.");
    AssertionError unknownError =new AssertionError("Unknown Exception Found");
   

    /** Constructor of class ArrOperation
     * @param array of integer
     * @throw AssertionError if Array is empty
     */
    public ArrOperation(int a[]){
        try{
            length=a.length;
            array=Arrays.copyOf(a,this.length);
        }
        catch(Exception e){
            throw arrayIsEmpty;
        }
    }
  
    
    /**
     * @return result : maximum size of subString that appears in reverse order
     * @throw AssertionError if Array is empty
     */
    public int maxMirror(){
        int result=0;
        int count =0;
        
        for(int i=0 ; i<this.length ; i++){
            count=0;
            for(int j = this.length-1 ; j >= 0 && (i+count) < this.length ; j--){
                if(this.array[i + count] == this.array[j])
                    count++;
                else
                    count=0;
            }
            result =Math.max(result,count);
        }
        return result;
    }
    
    
    /**
     * @return  count: no of series of 2 or more adjacent elements of the same value
     * @throw AssertionError if Array is empty
     * 
     */
    public int countClumps(){ 
        int count=0;
        int match;
        
        for(int i=0 ; i  < (this.length-1) ; i++){
            if(this.array[i] == this.array[i+1]){
                match=this.array[i];
                count++;
                for( ; i < this.length && this.array[i] == match ; i++);
            }
        }    
        return count;
    }

    
    /**
     * @param X integer value
     * @param Y integer Value
     * @return  an array that contains exactly the same numbers as the input array, 
     *      but rearranged so that every X is immediately followed by a Y
     * @throw AssertionError if : 1: Array is empty
     *                            2: X appears at last index of Array
     *                            3: 2 Adjacent X are there
     *                            4: no of x and Y are not Equal
     */  
    public int[] fitXY(int x, int y){
        int result[]=new int[this.length];
        int noOfX=0;
        int noOfY=0;
        //check that array is not empty and X is not at the last index
        if(this.length !=0 && this.array[this.length-1] == x) 
            throw xAtLastIndex;
        
        //calculate no of X and Y and place X and Y at their require position in result Array
        for(int i=0; i<this.length ; i++){
            if(this.array[i] == x && this.array[i+1] !=x ){
                result[i]=x;
                result[i+1]=y;
                noOfX++;
            }
            else if(this.array[i] == y){
                noOfY++;
            }
            if(this.array[i] == x && this.array[i+1] ==x )
                throw AdjacentsX;
        }

        int arrayIndex=0,resultIndex=0;
        
        // if no of X and Y are same place  other value at their required position
        if(noOfX == noOfY){
            while(arrayIndex < this.length && resultIndex < this.length){
                if(result[resultIndex] == x || result[resultIndex] == y){
                    resultIndex++;
                }
                if(this.array[arrayIndex] ==x || this.array[arrayIndex] ==y){
                    arrayIndex++;
                }
                else if(result[resultIndex] != x && result[resultIndex] != y){
                    result[resultIndex]=this.array[arrayIndex];
                    arrayIndex++;
                    resultIndex++;
                }
                    
            }
        }
        else 
            throw unequalXY;
        return result; 
    }
     
    /**
     * @return index if there is a place to split the input array so that 
     *      the sum of the numbers on one side is equal to the sum of the numbers on the other side
     *      else -1
     * @throw AssertionError if Array is empty
     */
    public int splitArray(){
        int sum=0;
        float sumOfSplitArray;
        int index=-1;
        
        for(int x:this.array){
            sum += x;
        }   
        
        sumOfSplitArray=(float)sum/2;
        sum=0;
        
        for(int i=0 ; i < this.length ; i++){
            sum += this.array[i];
            if(sum == sumOfSplitArray){
                index= i+1;
                break;
            }
        }             
    return index;    
    }

}