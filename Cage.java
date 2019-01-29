import java.util.ArrayList;
/**
 * 
 * @author Ronak Mehta
 *
 */
public class Cage {
    
    private static int count=0;
    private int cageId;
    private final int cageCapacity;
    private String animalType;
    private int noOfAnimalInCage;
    private ArrayList<Animal> animalList= new ArrayList<Animal>();
    /**
     * 
     * @param capacity of Cage 
     * @param animalType type of animal (like Lion ,Tiger , Snake)
     */
    public Cage(int capacity, String animalType){
        count++;
        this.cageId =count;
        this.cageCapacity = capacity;
        this.animalType = animalType; 
        this.noOfAnimalInCage=0;
    }
    
    /**
     * 
     * @return true if cage has maximum no of animal that it can have
     */
    public Boolean isFull(){
        if(cageCapacity == noOfAnimalInCage)
            return true;
        return false;
    }
    
    /**
     * 
     * @param toBeAdded animal that want to added to that cage
     * @return true if animal Added Successfully
     */
    public boolean addAnimal(Animal toBeAdded){
        if(cageCapacity != noOfAnimalInCage && animalType == toBeAdded.getType()){
            getAnimalList().add(toBeAdded);
            noOfAnimalInCage++;
            return true;
        }
        else
            return false;
    }

    /**
     * 
     * @return Cage unique ID
     */
    public int getCageId() {    return cageId; }
    
    /**
     * 
     * @return type of animal that cage  have 
     */
    public String getAnimalType() {    return animalType;   }

    /**
     * 
     * @return capacity of Cage
     */
    public int getCapacity(){   return cageCapacity;    }
    
    /**
     * 
     * @return No of Animal that cage currently have
     */
    public int getNoOfAnimal(){    return noOfAnimalInCage;    }

    /**
     * 
     * @return Array List of Animal that cage have
     */
    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }
}
