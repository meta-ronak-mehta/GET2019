/**
 * 
 * @author Ronak Mehta
 *
 */
abstract public class Bird extends  Animal{

    public static final String BIRD="Bird";
    /**
     * constructor
     * @param name of animal (String)
     * @param age of animal (integer)
     * @param Weigtht of animal (float)
     */
    public Bird(String name, int age, float Weigtht) {
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
     * @return Category of Animal : here it is Bird
     */
    public String getCategory() { return BIRD;  }

    
    /**
     * 
     * @return type of animal (like Lion ,Tiger, Snake ,Sparrow)
     */
    @Override
    abstract public String getType();

}
