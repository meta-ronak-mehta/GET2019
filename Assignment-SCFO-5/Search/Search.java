
public class Search {
      
    /**
     * 
     * @param array integer array 
     * @param length of array
     * @param value to be found
     * @return result : position of value in array if value not found return -1 
     */
    private static int LinearSearch(int array[],int length , int value){
        int result = -1;
        if(length > 0){
            if(array[length-1] == value)
                result= length;
            else
                result=LinearSearch(array, length-1, value);
        }
        return result;
    }
    
    /**
     * 
     * @param array integer array 
     * @param value value to be found
     * @return result : position of value in array if value not found return -1
     */
    public static int LinearSearch(int array[] , int value){
        return LinearSearch(array,array.length,value);
    }
     
    /**
     * 
     * @param array integer array 
     * @param start position
     * @param end position
     * @param value value to be found
     * @return result : position of value in array if value not found return -1
     */
    private static int binarySearch(int array[],int start,int end,int value){
        int result=-1;
        int mid= (start+end) / 2;
        if(end >= start){
            if(array[mid] == value)
                result= mid+1;
            else if(array[mid] > value)
                result=binarySearch(array,start,mid-1, value);
            else
                result=binarySearch(array,mid+1,end, value);
        }
        return result;        
    }
    
    /**
     * 
     * @param array integer array 
     * @param value value to be found
     * @return result : position of value in array if value not found return -1
     */
    public static int binarySearch(int array[],int value){
        System.out.println();
        int result =binarySearch(array,0,array.length-1, value);
        return result;
    }
    

}
