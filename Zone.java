import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Ronak Mehta
 *
 */
public class Zone {
    
    private static int count=0;
    private String zoneName;
    private int zoneID;
    private final int maxCage;
    private boolean hasPark;
    private boolean hasCanteen;
    private ArrayList<Cage> cageList= new ArrayList<Cage>();
    private String category;
    private Scanner sc=new Scanner(System.in);
    
    /**
     * constructor
     * @param name name of Zone
     * @param hasPark true if it have park
     * @param hasCanteen true if it have canteen
     * @param maxCage Maximum no Of cage that zone can have
     * @param category
     */
    public Zone(String name ,boolean hasPark, Boolean hasCanteen, int maxCage ,String category){
        count++;
        zoneID=count;
        this.zoneName=name;
        this.hasPark=hasPark;
        this.hasCanteen=hasCanteen;
        this.maxCage= maxCage;
        this.category=category;
    }
    
    
    /** Add Animal to Cage
     * 
     * @param animalToBeAdded animal that want to be added to the Zone
     * @return true if animal Added successfully
     */
    public boolean addAnimalToCage(Animal animalToBeAdded){
        boolean cagefound=false;
            for(Cage x:getCageList()) {
                if(x.getAnimalType() == animalToBeAdded.getType() && (! x.isFull()))  {
                    x.addAnimal(animalToBeAdded);
                     cagefound = true;
                     return true;
                }
            }
            if(! cagefound) {
                System.out.println("Cage not Found :");
                if(addCage(animalToBeAdded.getType()))
                    if(addAnimalToCage(animalToBeAdded))
                        return true;
                else
                    return false;
            }
        return false;
    }
    
    /**
     * 
     * @return unique zoo id
     */
    public int getZooID() {     return zoneID;    }
    
    /**
     * 
     * @return true if zoo have park
     */
    public boolean hasPark() {    return hasPark;   }
    
    /**
     * 
     * @return true if zoo have Canteen
     */
    public boolean hasCanteen() {    return hasCanteen; }
    
    /**
     * 
     * @return Category of ANimal that zone is of 
     */
    public String getCategory(){     return category; }
    
    /**
     * 
     * @param type of animal that cage want to be
     * @return true if the new cage is added successfully
     */
    public boolean addCage(String type){       
        if(maxCage != getCageList().size()){
            System.out.println("Enter the Capacity Of New Cage :");
            int capacity = getValidInteger();
            Cage c=new Cage(capacity,type);
            getCageList().add(c);
            return true;
        }
        System.out.println("zone have reaches maximum no of cage Capacity");
        System.out.println("please Create a new Zone");
        return false;
        
    }
    
    
    /**
     * @return :an integer passed by user with exception handling
     */
    public int getValidInteger(){
        int value=0;
        boolean continueInput=true; 
        do {
            try{
                value=sc.nextInt();
                continueInput = false;
                }
            catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                sc.nextLine();
                }
            }
        while(continueInput);
        return value;
    }

    /**
     * 
     * @return ArrayList of cages that azone have
     */
    public ArrayList<Cage> getCageList() {
        return cageList;
    }
    
    /**
     * display Cage details of a Zone
     */
    public void display(){
        System.out.println("details Of Zone :" +zoneID +"  "+zoneName);
        System.out.println("Cage id  cage Animal Type  Cage Capacity  No of Animal In Cage" );
        for(Cage c: cageList)
            System.out.println(c.getCageId() +" "+ c.getAnimalType() +" "+ c.getCapacity() +" " +c.getNoOfAnimal());
    }

}
