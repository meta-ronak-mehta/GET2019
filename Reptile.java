/**
 * 
 * @author Ronak Mehta
 *
 */
abstract public class Reptile extends Animal {

    public static final String RAPTILE="Raptile";
    
    /**
     * constructor
     * @param name of animal (String)
     * @param age of animal (integer)
     * @param Weigtht of animal (float)
     */
    public Reptile(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    /**
     * 
     * @return String of sound that animal make
     */
    @Override
    abstract public String makeSound();
    
    /**
     * 
     * @return Category of Animal : here it is Reptile
     */
    @Override
    public String getCategory() {   return RAPTILE;    }
    
    /**
     * 
     * @return type of animal (like Lion ,Tiger, Snake ,Sparrow)
     */
    @Override
    abstract public String getType();
    
    

}
