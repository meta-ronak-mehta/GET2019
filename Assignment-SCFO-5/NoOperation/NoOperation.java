
public class NoOperation {

    /**
     * @param value1 integer value
     * @param value2 integer value
     * @return LCM of Value1 and Value2
     */
    public static int HCF(int value1, int value2){         
        if (value1 == 0) 
            return value2;           
        return HCF(value2 % value1, value1); 
    } 
    
    /**
     * @param value1 integer value
     * @param value2 integer value
     * @param i integer value
     * @return LCM of Value1 and Value2
     */
    private static int LCM(int value1, int value2, int i){
        int max=Math.max(value1, value2);
        if(i == (value1 * value2))
            return ( value1 * value2);
        if(i % value1 == 0 && i % value2 == 0)
            return i;
        else
            return LCM(value2,value1,i+max);
    }
    
    /**
     * @param value1 integer value
     * @param value2 integer value
     * @return LCM of Value1 and Value2
     */
    public static int LCM(int value1, int value2){
        return LCM(value2,value1,Math.max(value2, value1));        
    }

}
