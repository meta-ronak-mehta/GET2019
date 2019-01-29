/**
 * 
 * @author Ronak Mehta
 *
 */
public class Snake extends Reptile{

    public static final String SNAKE="Snake";
    /**
     * constructor
     * @param name of animal (String)
     * @param age of animal (integer)
     * @param Weigtht of animal (float)
     */
    public Snake(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    /**
     * 
     * @return String of sound that animal make
     */
    @Override
    public String makeSound() {
        return "hissss";
    }
    /**
     * 
     * @return type of animal  here it is Snake
     */
    @Override
    public String getType() { return SNAKE; }
}

