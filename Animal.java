/**
 * 
 * @author Ronak Mehta
 *
 */
abstract public class Animal {

    private static int count=0;
    private int animalIid;
    private String animalName;
    private int animalAge;
    private float animalWeight;
    /**
     * constructor
     * @param name of animal (String)
     * @param age of animal (integer)
     * @param Weigtht of animal (float)
     */
    public Animal(String name,int age, float Weigtht){
        count++;
        this.animalIid=count;
        this.animalName=name;
        this.animalAge=age;
        this.animalWeight=Weigtht;
    }
    
    /**
     * 
     * @return unique animal id 
     */
    public int getAnimalId(){      return animalIid;       }
    
    /**
     * 
     * @return animal Name
     */
    public String getAnimalname(){  return animalName;      }
    
    /**
     * 
     * @return animal age
     */
    public int getAnimalAge(){      return animalAge;       }
    
    /**
     * 
     * @return Animal Weight
     */
    public float getAnimalWeight(){ return animalWeight;    }
    
    /**
     * 
     * @return Category of ANimal (Like Mammal ,Reptile ,Bird)
     */
    abstract public String getCategory();
    
    /**
     * 
     * @return String of sound that animal make
     */
    abstract public String makeSound();
    
    /**
     * 
     * @return type of animal (like Lion ,Tiger, Snake ,Sparrow)
     */
    abstract public String getType();
    
}
