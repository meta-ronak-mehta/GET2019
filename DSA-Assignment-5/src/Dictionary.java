import java.util.List;

public interface Dictionary<T> {

    /**
     * Method to add tree node to a tree
     * 
     * @param key
     * @param value
     * @return true if tree node is added successfully else false
     */
    public void addNode(String key, T value);

    /**
     * Method to delete tree node with a given key
     * 
     * @param key to be deleted
     */
    public void deleteNode(String key);

    /**
     * Method to return the value mapped to the given key
     * 
     * @param key whose value is to be search
     * @return the value mapped to the given key
     */
    public T getValue(String key);

    /**
     * method to return list if data
     * 
     * @return sorted list of Data
     */
    public List<Data<T>> sortedOrder();

    /**
     * Method to return the list of sorted nodes between the given two key values
     * 
     * @param key1 is smaller than key2
     * @param key2 requires to greater than key2
     * @return list of sorted nodes between keys
     */
    public List<Data<T>> sortBetweenTwoKeyValue(String key1, String key2);
}
