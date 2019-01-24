package metacube;
import java.util.ArrayList;
import java.util.List;


public final class IntSet {

    private final int[] inputSet;
    private final int length;
    public static final int MAX_VALUE = 1000;
    private AssertionError emptyArray = new AssertionError("Array is empty"); 
    
    /**Constructor for IntSet
     * 
     * @param aInputSet to create Obj of Intset using integer Array
     */
    public IntSet(int[] aInputSet) {
        try{
            this.length=aInputSet.length;
            this.inputSet = (int[]) aInputSet.clone();
        }catch(Exception e){
            throw emptyArray;
        }
    }

    /**
     * 
     * @param value to be searched in IntSet
     * @return true if value found 
     */
    public boolean isMember(int value) {
        Boolean ismember = false;
        
        if (this.length == 0)
            throw emptyArray;
        
        for(int x: inputSet)
            if(x == value){
                ismember=true;
                break;
            }
        return ismember;
    }

    /**
     * 
     * @return return size of IntSet Object
     */
    public int getSetSize() {
        if (this.length == 0)
            throw emptyArray;
        
        return this.length;
    }

    /**
     * 
     * @param anotherSet to compare with callee Object
     * @return true if the anotherSet is subset of Calle 
     */
    public boolean isSubSet(IntSet anotherSet) {
        if (this.length == 0 || anotherSet.length == 0)
            throw emptyArray;

        int countValue = 0;
        
        for (int i = 0; i < this.length; i++) {
            countValue = 0;
            for (int j = 0; j < anotherSet.length; j++) {
                if (inputSet[i + countValue] == anotherSet.inputSet[j]) {
                    countValue++;
                }
            }
            if (countValue == anotherSet.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return complement Set of IntSet 
     *      where U = x{0 <= x =>1000}
     */
    public int[] complementedSet() {
        if (this.length == 0)
            throw emptyArray;
        
        int complicatedArray[] = new int[MAX_VALUE-this.length+1];
        
        for (int i = 0, j = 0; i <= MAX_VALUE; ++i) {
            if (! isMember(i)) {
                complicatedArray[j] = i;
                j++;
            }
        }
        return complicatedArray;
    }

    /**
     * 
     * @param anotherInputSet Intset
     * @return Union Of callee Intset and anotherInputSet intSet
     */
    public List<Integer> unionOfSet(IntSet anotherInputSet) {
        if (this.length == 0)
            throw emptyArray;
       
        List<Integer> unionSet= new ArrayList<Integer>(); 
        for (int i = 0; i < this.length; i++)
            unionSet.add(inputSet[i]);

        
        for (int i = 0; i < anotherInputSet.length; i++) {
            if (!unionSet.contains(anotherInputSet.inputSet[i]))
                unionSet.add(anotherInputSet.inputSet[i]);        
            }
        return unionSet;
    }

}
