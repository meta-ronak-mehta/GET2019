/**
 * 
 * @author Ronak Mehta
 *
 */
public class Tiger extends Mammal{

    public static final String TIGER="Tiger";
    
    /**
     * constructor
     * @param name of animal (String)
     * @param age of animal (integer)
     * @param Weigtht of animal (float)
     */
    public Tiger(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    /**
     * 
     * @return String of sound that animal make
     */
    @Override
    public String makeSound() {
        return "Roar";
    }
    
    /**
     * 
     * @return type of animal here it is Tiger
     */
    @Override
    public String getType() { return TIGER; }
    
}

