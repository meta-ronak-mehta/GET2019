package metacube;

public final class Poly {

    private int polynomial[][]=new int[2][];
    private int maxPower;
    
    /**
     * Constructor for Polynomial
     * @param array of integer to create object of Polynomial
     */
    public Poly(int array[]){
        this.maxPower=array.length-1;
        this.polynomial =new int [2][maxPower+1];
        
        for(int i=0,j=0; i <= this.maxPower; i++){
            if(array[i] != 0){
                this.polynomial[0][j]=i;
                this.polynomial[1][j]=array[i];
                j++;
            }
        }
//        printPoly();
    }
       
    /**
     * 
     * @param anotherPoly : another Object of Polynomial
     * @return addition of callee object and anotherPoly object
     */
    public Poly addPoly(Poly anotherPoly){
        
        int max=Math.max(this.maxPower,anotherPoly.maxPower);        
        int resultPolyArray[] = new int [max+1];

        // a[0][power] index has value  b[1][Coefficient] + b[1][Coefficient]
         
        for(int i=0; i <= max ; i++){
            if(i <= this.maxPower)
                resultPolyArray[this.polynomial[0][i]] += this.polynomial[1][i];
            if(i <= anotherPoly.maxPower)
                resultPolyArray[anotherPoly.polynomial[0][i]] += anotherPoly.polynomial[1][i]; 
        }
        
        Poly resultPoly=new Poly(resultPolyArray);
        return resultPoly;
    }
 
    /**
     * 
     * @param value :value of X in float
     * @return evaluated float value of polynomial function at x=value and return result 
     */
    public float evaluate(float value){
        float result=0;
        
        //result = a[1][Coefficient] * value^a[0][power]
        
        for(int i=0; i <= this.maxPower ;i++){
            result += this.polynomial[1][i] * Math.pow(value,this.polynomial[0][i]);
        }
        System.out.println(result);
        return result;
    }
    
    /**
     * 
     * @return degree of polynomial in integer
     */
    public int getDegree(){
        return this.maxPower;
    }
    
    /**
     * 
     * @param anotherPoly another Object of Polynomial
     * @return Multiplication of callee object and anotherPoly object
     */
    public  Poly multiplyPoly(Poly anotherPoly){
        int maxDegree=this.maxPower+anotherPoly.maxPower;
        int resultPolyArray[]=new int[maxDegree+1];
        
        //  power ware added 
        //  Coefficient will be multiplied
        
        for(int i=0 ; i <= this.maxPower ; i++){
            for(int j=0; j <= anotherPoly.maxPower; j++){
                resultPolyArray[polynomial[0][i] + anotherPoly.polynomial[0][j]] += this.polynomial[1][i] * anotherPoly.polynomial[1][j];
            }
        }
        
        Poly resultPoly=new Poly(resultPolyArray);
        return resultPoly;
    }

    /**
     *  to print polynomial function
     */
    private void printPoly(){
        for (int i=0; i<=this.maxPower; i++) 
            System.out.print(this.polynomial[1][i] +" X^"+this.polynomial[0][i]+"  "); 
        System.out.println();
    }

    /**
     * 
     * @return Polynomial in string format
     */
    public String convertToString(){
        String result = null;
        for(int i=0 ;i<=this.maxPower ; i++)
            result +=this.polynomial[1][i];
        return result;
    }
}
